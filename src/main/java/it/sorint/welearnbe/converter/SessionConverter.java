package it.sorint.welearnbe.converter;

import it.sorint.welearnbe.controllers.entity.FullSessionFE;
import it.sorint.welearnbe.controllers.entity.SessionFE;
import it.sorint.welearnbe.repository.entity.CourseBE;
import it.sorint.welearnbe.repository.entity.SessionBE;

public class SessionConverter {

	public static SessionFE convertToSessionFE(SessionBE backend, String username) {
		SessionFE frontend = new SessionFE();
		//Copy the fields
		frontend.setCourseID("/api/courses/" + backend.getCourseID());
		frontend.setEndDate(backend.getEndDate());
		frontend.setSessionID("/api/sessions/" + backend.getId());
		frontend.setStartDate(backend.getStartDate());
		frontend.setStudentsID(backend.getStudents());
		frontend.setTeacherID(backend.getTeacher());
		frontend.setFollowAsStudent(backend.getStudents().contains(username));
		frontend.setFollowAsTeacher(backend.getTeacher().equals(username));
		return frontend;
	}

	public static FullSessionFE convertToFullSessionFE(SessionBE backend, String username, CourseBE relativeCourseBE) {
		FullSessionFE frontend = new FullSessionFE();
		//Copy the fields
		frontend.setCourseID("/api/courses/" + backend.getCourseID());
		frontend.setEndDate(backend.getEndDate());
		frontend.setSessionID("/api/sessions/" + backend.getId());
		frontend.setStartDate(backend.getStartDate());
		frontend.setStudentsID(backend.getStudents());
		frontend.setTeacherID(backend.getTeacher());
		frontend.setFollowAsStudent(backend.getStudents().contains(username));
		frontend.setFollowAsTeacher(backend.getTeacher().equals(username));
		frontend.setCourse(CourseConverter.convertToCourseWithUnitsFE(relativeCourseBE));
		return frontend;
	}
}
