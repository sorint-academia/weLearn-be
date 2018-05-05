package it.sorint.welearnbe.converter;

import java.util.UUID;
import java.util.stream.Collectors;

import it.sorint.welearnbe.controllers.entity.CourseFE;
import it.sorint.welearnbe.controllers.entity.CourseWithUnitsFE;
import it.sorint.welearnbe.controllers.entity.UnitFE;
import it.sorint.welearnbe.controllers.entity.UnitWithWidgetsFE;
import it.sorint.welearnbe.controllers.entity.WidgetFE;
import it.sorint.welearnbe.repository.entity.CourseBE;
import it.sorint.welearnbe.repository.entity.UnitBE;
import it.sorint.welearnbe.repository.entity.WidgetBE;

public class CourseConverter {
	
	public static CourseFE convertToCourseFE(CourseBE backend) {
		CourseFE frontend = new CourseFE();
		//Copy the fields
		frontend.setAuthor(backend.getAuthor());
		frontend.setCourseID("/api/courses/" + backend.getId());
		frontend.setDescription(backend.getDescription());
		frontend.setTitle(backend.getTitle());
		return frontend;
	}
	
	public static CourseWithUnitsFE convertToCourseWithUnitsFE(CourseBE backend) {
		CourseWithUnitsFE frontend = new CourseWithUnitsFE();
		//Copy the fields
		frontend.setAuthor(backend.getAuthor());
		frontend.setCourseID("/api/courses/" + backend.getId());
		frontend.setDescription(backend.getDescription());
		frontend.setTitle(backend.getTitle());
		frontend.setUnits(backend.getUnits().stream().map(be -> convertToUnitFE(be, backend.getId())).collect(Collectors.toList()));
		return frontend;
	}
	
	public static UnitFE convertToUnitFE(UnitBE backend, UUID courseID) {
		UnitFE frontend = new UnitFE();
		//Copy the fields
		frontend.setDescription(backend.getDescription());
		frontend.setTitle(backend.getTitle());
		frontend.setUnitID("/api/courses/" + courseID + "/units/" + backend.getId());
		return frontend;
	}
	
	public static UnitWithWidgetsFE convertToUnitWithWidgetsFE(UnitBE backend, UUID courseID) {
		UnitWithWidgetsFE frontend = new UnitWithWidgetsFE();
		//Copy the fields
		frontend.setDescription(backend.getDescription());
		frontend.setTitle(backend.getTitle());
		frontend.setUnitID("/api/courses/" + courseID + "/units/" + backend.getId());
		//Copy the widgets converted to WidgetFE
		frontend.setWidgets(backend.getWidgets().stream().map(be -> convertToWidgetFE(be, courseID, backend.getId())).collect(Collectors.toList()));
		return frontend;
	}
	
	public static WidgetFE convertToWidgetFE(WidgetBE backend, UUID courseID, UUID unitID) {
		WidgetFE frontend = new WidgetFE();
		//Copy the fields
		frontend.setLang(backend.getLang());
		frontend.setProjectID("/api/projects/" + backend.getProjectID());
		frontend.setText(backend.getText());
		frontend.setType(backend.getType());
		frontend.setWidgetID("/api/courses/" + courseID + "/units/" + backend.getId() + "/widgets/"+ backend.getId());
		return frontend;
	}
}
