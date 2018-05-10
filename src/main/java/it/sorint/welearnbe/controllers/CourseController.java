package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import it.sorint.welearnbe.controllers.entity.*;
import it.sorint.welearnbe.repository.entity.CourseBE;
import it.sorint.welearnbe.repository.entity.WidgetBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.converter.CourseConverter;
import it.sorint.welearnbe.services.CourseService;
import it.sorint.welearnbe.services.SessionService;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseFE>> getCourses(Principal principal) {
        //Return all viewable courses mapped from CourseBE to CourseFE
        return ResponseEntity.ok(
                courseService.getCourses(principal.getName()).stream()
                        .map(be -> CourseConverter.convertToCourseFE(be))
                        .collect(Collectors.toList()));
    }

    @GetMapping("/courses/{courseID}")
    public ResponseEntity<CourseWithUnitsFE> getCourse(Principal principal, @PathVariable("courseID") UUID courseID) {
        //Check if the principal is the course's teacher or course's student
        if (sessionService.isStudentOfCourse(principal.getName(), courseID) | sessionService.isTeacherOfCourse(principal.getName(), courseID)) {
            CourseBE courseBE = courseService.getCourseById(principal.getName(), courseID);
            if (courseBE == null) {
                //Return 404 NOT FOUND
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(CourseConverter.convertToCourseWithUnitsFE(courseBE));
            }
        } else {
            //Return 403 FORBIDDEN
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/courses/{courseID}/units")
    public ResponseEntity<List<UnitFE>> getUnits(Principal principal, @PathVariable("courseID") UUID courseID) {
        //Check if the principal is the course's teacher or course's student
        if (sessionService.isStudentOfCourse(principal.getName(), courseID) | sessionService.isTeacherOfCourse(principal.getName(), courseID)) {
            List<UnitFE> unitFEs = courseService.getUnits(principal.getName(), courseID).stream()
                    .map(be -> CourseConverter.convertToUnitFE(be, courseID))
                    .collect(Collectors.toList());
            if (unitFEs.size() == 0) {
                //Return 404 NOT FOUND
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(unitFEs);
            }
        } else {
            //Return 403 FORBIDDEN
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/courses/{courseID}/units/{unitID}")
    public ResponseEntity<UnitWithWidgetsFE> getUnit(Principal principal, @PathVariable("courseID") UUID courseID, @PathVariable("unitID") UUID unitID) {
        //Check if the principal is the course's teacher or course's student
        if (sessionService.isStudentOfCourse(principal.getName(), courseID) | sessionService.isTeacherOfCourse(principal.getName(), courseID)) {
            UnitWithWidgetsFE unitWithWidgetsFE = CourseConverter.convertToUnitWithWidgetsFE(courseService.getUnitFromCourseID(principal.getName(), courseID, unitID), courseID);
            if (unitWithWidgetsFE == null) {
                //Return 404 NOT FOUND
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(unitWithWidgetsFE);
            }
        } else {
            //Return 403 FORBIDDEN
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/courses/{courseID}/units/{unitID}/widgets")
    public ResponseEntity<List<WidgetFE>> getWidget(Principal principal, @PathVariable("courseID") UUID courseID, @PathVariable("unitID") UUID unitID) {
        //Check if the principal is the course's teacher or course's student
        if (sessionService.isStudentOfCourse(principal.getName(), courseID) | sessionService.isTeacherOfCourse(principal.getName(), courseID)) {

            List<WidgetFE> widgetFEs = courseService.getWidgetsFromUnit(principal.getName(), courseID, unitID).stream()
                    .map(be -> CourseConverter.convertToWidgetFE(be, courseID, unitID))
                    .collect(Collectors.toList());
            if (widgetFEs.size() == 0) {
                //Return 404 NOT FOUND
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(widgetFEs);
            }

        } else {
            //Return 403 FORBIDDEN
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
