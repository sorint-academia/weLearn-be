package it.sorint.welearnbe.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import it.sorint.welearnbe.repository.entity.UnitBE;
import it.sorint.welearnbe.repository.entity.WidgetBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sorint.welearnbe.repository.CourseRepository;
import it.sorint.welearnbe.repository.entity.CourseBE;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SessionService sessionService;

    public List<CourseBE> getCourses(String name) {
        //Get the viewable sessions and then map to course
        return sessionService.getSessionsByStudentOrTeacherName(name).stream()
                .map(s -> courseRepository.findOne(s.getCourseID()))
                .collect(Collectors.toList());
    }

    public CourseBE getCourseById(String username, UUID id) {
        //Get course from its id
        //FIXME
        List<CourseBE> courseBEs = getCourses(username).stream()
                .filter(c -> c.getId().equals(id))
                .collect(Collectors.toList());
        if (courseBEs.size() == 0) {
            return null;
        } else {
            return courseBEs.get(0);
        }
    }

    public List<UnitBE> getUnits(String username, UUID id) {
        //Get units from a specified course id
        return getCourseById(username, id).getUnits();
    }

    public UnitBE getUnitFromCourseID(String username, UUID courseId, UUID unitId) {
        //Get Single unit from id
        List<UnitBE> unitBEs = getUnits(username, courseId).stream()
                .filter(u -> u.getId().equals(unitId))
                .collect(Collectors.toList());
        if (unitBEs.size() == 0) {
            return null;
        } else {
            return unitBEs.get(0);
        }
    }

    public List<WidgetBE> getWidgetsFromUnit(String username, UUID id, UUID unitId) {

        return getUnitFromCourseID(username, id, unitId).getWidgets();
    }
}
