package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.CourseFE;
import it.sorint.welearnbe.controllers.entity.CourseWithUnitsFE;
import it.sorint.welearnbe.controllers.entity.UnitFE;
import it.sorint.welearnbe.controllers.entity.UnitWithWidgetsFE;
import it.sorint.welearnbe.controllers.entity.WidgetFE;

@RestController
@RequestMapping("/api")
public class CourseController {

	@GetMapping("/courses")
	public ResponseEntity<List<CourseFE>> getCourses() {
		return null;
	}
	
	@GetMapping("/courses/{courseID}")
	public ResponseEntity<CourseWithUnitsFE> getCourse(Principal principal, @PathVariable("courseID") UUID courseID) {
		return null;
	}
	
	@GetMapping("/courses/{courseID}/units")
	public ResponseEntity<List<UnitFE>> getUnits(Principal principal, @PathVariable("courseID") UUID courseID) {
		return null;
	}
	
	@GetMapping("/courses/{courseID}/units/{unitID}")
	public ResponseEntity<UnitWithWidgetsFE> getUnit(Principal principal, @PathVariable("courseID") UUID courseID, @PathVariable("unitID") UUID unitID) {
		return null;
	}
	
	@GetMapping("/courses/{courseID}/units/{unitID}/widgets")
	public ResponseEntity<List<WidgetFE>> getWidget(Principal principal, @PathVariable("courseID") UUID courseID, @PathVariable("unitID") UUID unitID) {
		return null;
	}
}
