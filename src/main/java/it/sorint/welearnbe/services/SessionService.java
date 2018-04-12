package it.sorint.welearnbe.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sorint.welearnbe.repository.SessionRepository;
import it.sorint.welearnbe.repository.entity.SessionBE;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	public List<SessionBE> getSessions() {
		return sessionRepository.findAll();
	}

	public List<SessionBE> getSessionsAsStudent(String name){
		return sessionRepository.findAll().stream()
                .filter(s -> s.getStudents().contains(name))
                .collect(Collectors.toList());
	}
    public List<SessionBE> getSessionsAsTeacher(String name){
        return sessionRepository.findAll().stream()
                .filter(s ->  s.getTeacher().equals(name))
                .collect(Collectors.toList());
    }

	
	public List<SessionBE> getSessionsByTeacherName(String username) {
		return sessionRepository.findAllByTeacher(username);
	}
	
	public List<SessionBE> getSessionsByStudentName(String username) {
		return sessionRepository.findAll().stream()
				.filter(s -> s.getStudents()
				.contains(username)).collect(Collectors.toList());
	}
	
	public List<SessionBE> getSessionsByStudentOrTeacherName(String username) {
		return sessionRepository.findAll().stream()
				.filter(s -> 
					s.getStudents().contains(username) || s.getTeacher() == username
				).collect(Collectors.toList());
	}
		
	
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
