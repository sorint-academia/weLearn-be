package it.sorint.welearnbe.converter;

import java.util.HashMap;
import java.util.stream.Collectors;


import it.sorint.welearnbe.controllers.entity.ProgressCourseFE;
import it.sorint.welearnbe.controllers.entity.ProgressFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectWithFilenamesFE;
import it.sorint.welearnbe.controllers.entity.ProgressUnitFE;
import it.sorint.welearnbe.controllers.entity.ProgressWidgetFE;
import it.sorint.welearnbe.controllers.entity.ProgressWithProgressCourseFE;
import it.sorint.welearnbe.repository.entity.ProgressBE;
import it.sorint.welearnbe.repository.entity.ProgressCourseBE;
import it.sorint.welearnbe.repository.entity.ProgressProjectBE;
import it.sorint.welearnbe.repository.entity.ProgressUnitBE;
import it.sorint.welearnbe.repository.entity.ProgressWidgetBE;

public class ProgressConverter {
	public static ProgressFE convertToProgressFE(ProgressBE backend) {
		ProgressFE frontend = new ProgressFE();
		frontend.setProgressID("/api/progresses/" + backend.getStudent());
		frontend.setStudentID(backend.getStudent());
		return frontend;
	}

	public static ProgressCourseFE convertToProgressCourseFE(ProgressCourseBE backend, String progressID) {
		ProgressCourseFE frontend = new ProgressCourseFE();
		frontend.setCourseID(progressID+"/"+backend.getId());
		frontend.setUnits(backend.getUnits().stream().map(be -> convertToProgressUnitFE(be, frontend.getCourseID())).collect(Collectors.toList()));
		//TODO: set completed
		frontend.setCompleted(false);
		return frontend;
	}
	
	public static ProgressUnitFE convertToProgressUnitFE(ProgressUnitBE backend, String progressCourseID) {
		ProgressUnitFE frontend = new ProgressUnitFE();
		frontend.setUnitID(progressCourseID+"/" + backend.getId());
		frontend.setWidgets(backend.getWidgets().stream().map(be -> convertToProgressWidgetFE(be, frontend.getUnitID())).collect(Collectors.toList()));
		//TODO: set completed
		frontend.setCompleted(false);
		return frontend;
	}
	
	public static ProgressWidgetFE convertToProgressWidgetFE(ProgressWidgetBE backend, String progressUnitID) {
		ProgressWidgetFE frontend = new ProgressWidgetFE();
		frontend.setWidgetID(progressUnitID + "/" + backend.getId());
		frontend.setCompleted(backend.getCompleted());
		return frontend;
	}

	public static ProgressWithProgressCourseFE convertToProgressWithProgressCourseFE(ProgressBE backend) {
		ProgressWithProgressCourseFE frontend = new ProgressWithProgressCourseFE();
		frontend.setProgressID("/api/progresses/" + backend.getStudent());
		frontend.setStudentID(backend.getStudent());
		frontend.setCourses(backend.getCourses().stream().map(be -> convertToProgressCourseFE(be, frontend.getProgressID())).collect(Collectors.toList()));
		return frontend;
	}
	
	public static ProgressProjectFE convertToProgressProjectFE(ProgressProjectBE backend, String progressID) {
		ProgressProjectFE frontend = new ProgressProjectFE();
		frontend.setProjectID("/api/projects/" + backend.getId());
		frontend.setProgressProjectID(progressID + "/projects/" + backend.getId());
		frontend.setVersion(backend.getVersion());
		return frontend;
	}
	
	public static ProgressProjectWithFilenamesFE convertToProgressProjectWithFilenamesFE(ProgressProjectBE backend, String progressID, HashMap<String, String> files) {
		ProgressProjectWithFilenamesFE frontend = new ProgressProjectWithFilenamesFE();
		frontend.setProjectID("/api/projects/" + backend.getId());
		frontend.setProgressProjectID(progressID + "/projects/" + backend.getId());
		frontend.setVersion(backend.getVersion());
		frontend.setFilenames(backend.getFiles().stream().map(id -> files.get(id)).collect(Collectors.toList()));
		return frontend;
	}
}
