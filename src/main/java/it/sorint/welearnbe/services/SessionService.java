package it.sorint.welearnbe.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class SessionService {
	
	//_course_student_ 
	public boolean isStudentOfCourse(String user, UUID courseID) {
		//TODO: implement this function
		return true;
	}
	//_course_student_ 
	public boolean isTeacherOfCourse(String user, UUID courseID) {
		//TODO: implement this function
		return true;
	}
	//_course_student_ 
	public boolean isStudentOfSession(String user, UUID sessionID) {
		//TODO: implement this function
		return true;
	}	
	//_course_teacher_ 
	public boolean isTeacherOfSession(String user, UUID sessionID) {
		//TODO: implement this function
		return true;
	}	

}
