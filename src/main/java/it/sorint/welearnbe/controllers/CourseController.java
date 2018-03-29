package it.sorint.welearnbe.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.CourseFE;
import it.sorint.welearnbe.controllers.entity.CourseIDFE;
import it.sorint.welearnbe.controllers.entity.CourseWithUnitsFE;
import it.sorint.welearnbe.controllers.entity.UnitFE;
import it.sorint.welearnbe.controllers.entity.UnitWithWidgetsFE;
import it.sorint.welearnbe.controllers.entity.WidgetFE;

@RestController
@RequestMapping("/api")
public class CourseController {

	@GetMapping("/courses")
	public List<CourseFE> getCourses() {
		return null;
	}
	
	@GetMapping("/courses/{courseID}")
	public CourseWithUnitsFE getCourse(@PathVariable("courseID") UUID courseID) {
		return null;
	}
	
	@GetMapping("/courses/{courseID}/units")
	public List<UnitFE> getUnits(@PathVariable("courseID") UUID courseID) {
		return null;
	}
	
	@GetMapping("/courses/{courseID}/units/{unitID}")
	public UnitWithWidgetsFE getUnit(@PathVariable("courseID") UUID courseID, @PathVariable("unitID") UUID unitID) {
		return null;
	}
	
	@GetMapping("/courses/{courseID}/units/{unitID}/widgets")
	public List<WidgetFE> getWidget(@PathVariable("courseID") UUID courseID, @PathVariable("unitID") UUID unitID) {
		return null;
	}
}
