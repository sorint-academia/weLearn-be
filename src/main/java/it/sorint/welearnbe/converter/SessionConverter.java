package it.sorint.welearnbe.converter;

import it.sorint.welearnbe.controllers.entity.SessionFE;
import it.sorint.welearnbe.repository.entity.SessionBE;

public class SessionConverter {

	public static SessionFE convertToSessionFE(SessionBE backend) {
		SessionFE frontend = new SessionFE();
		//Copy the fields
		frontend.setCourseID("/api/courses/" + backend.getCourseID());
		frontend.setEndDate(backend.getEndDate());
		frontend.setSessionID("/api/sessions/" + backend.getId());
		frontend.setStartDate(backend.getStartDate());
		frontend.setStudentsID(backend.getStudents());
		frontend.setTeacherID(backend.getTeacher());
		return frontend;
	}
}
