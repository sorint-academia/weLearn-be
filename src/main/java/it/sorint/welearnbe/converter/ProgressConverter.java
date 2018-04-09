package it.sorint.welearnbe.converter;

import java.util.UUID;
import java.util.stream.Collectors;

import it.sorint.welearnbe.controllers.entity.ProgressFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectWithFilenamesFE;
import it.sorint.welearnbe.controllers.entity.ProgressUnitFE;
import it.sorint.welearnbe.controllers.entity.ProgressWidgetFE;
import it.sorint.welearnbe.controllers.entity.ProgressWithProgressUnitFE;
import it.sorint.welearnbe.repository.entity.ProgressBE;
import it.sorint.welearnbe.repository.entity.ProgressProjectBE;
import it.sorint.welearnbe.repository.entity.ProgressUnitBE;
import it.sorint.welearnbe.repository.entity.ProgressWidgetBE;

public class ProgressConverter {
	public static ProgressFE convertToProgressFE(ProgressBE backend) {
		ProgressFE frontend = new ProgressFE();
		frontend.setCourseID("/api/courses/" + backend.getCourseID());
		frontend.setProgressID("/api/progresses/" + backend.getId());
		frontend.setStudentID(backend.getStudent());
		return frontend;
	}
	
	public static ProgressProjectFE convertToProgressProjectFE(ProgressProjectBE backend, UUID progressID) {
		ProgressProjectFE frontend = new ProgressProjectFE();
		frontend.setProgressProjectID("/api/progresses/" + progressID + "/projects/" + backend.getId());
		frontend.setProjectID("/api/projects/" + backend.getId());
		frontend.setVersion(backend.getVersion());
		return frontend;
	}
	
	public static ProgressProjectWithFilenamesFE convertToProgressProjectWithFilenameFE(ProgressProjectBE backend, UUID progressID) {
		ProgressProjectWithFilenamesFE frontend = new ProgressProjectWithFilenamesFE();
		frontend.setProgressProjectID("/api/progresses/" + progressID + "/projects/" + backend.getId());
		frontend.setProjectID("/api/projects/" + backend.getId());
		frontend.setVersion(backend.getVersion());
		//TODO: set filenames
		//frontend.setFilenames(backend.get);
		return frontend;
	}
	
	public static ProgressUnitFE convertToProgressUnitFE(ProgressUnitBE backend, UUID progressID) {
		ProgressUnitFE frontend = new ProgressUnitFE();
		frontend.setCompleted(backend.getCompleted());
		frontend.setUnitID("/api/progresses/" + progressID + "/courses/" + backend.getCourseId() + "/units/" + backend.getId());
		frontend.setWidgets(backend.getWidgets().stream().map(be -> convertToProgressWidgetFE(be, progressID, backend.getCourseId() , backend.getId())).collect(Collectors.toList()));
		return frontend;
	}
	
	public static ProgressWidgetFE convertToProgressWidgetFE(ProgressWidgetBE backend, UUID progressID, UUID courseID, UUID unitID) {
		ProgressWidgetFE frontend = new ProgressWidgetFE();
		frontend.setCompleted(backend.getCompleted());
		frontend.setWidgetID("/api/progresses/" + progressID + "/courses/" + courseID + "/units/" + backend.getId() + "/widgets/" + backend.getId());
		return frontend;
	}
	
	public static ProgressWithProgressUnitFE convertToProgressWithUnitFE(ProgressBE backend) {
		ProgressWithProgressUnitFE frontend = new ProgressWithProgressUnitFE();
		frontend.setCourseID("/api/courses/" + backend.getCourseID());
		frontend.setProgressID("/api/progresses/" + backend.getId());
		frontend.setStudentID(backend.getStudent());
		frontend.setUnits(backend.getUnits().stream().map(be -> convertToProgressUnitFE(be, backend.getId())).collect(Collectors.toList()));
		return frontend;
	}
}
