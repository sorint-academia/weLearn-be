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
        //Return all sessions
        return sessionRepository.findAll();
    }

    public List<SessionBE> getSessionsByTeacherName(String username) {
        //Return all sessions filtered by teacher
        return sessionRepository.findAllByTeacher(username);
    }

    public List<SessionBE> getSessionsByStudentName(String username) {
        //Return all sessions where the user(name) is a student.
        return sessionRepository.findAll().stream()
                .filter(s -> s.getStudents()
                        .contains(username)).collect(Collectors.toList());
    }

    public List<SessionBE> getSessionsByStudentOrTeacherName(String username) {
        //Return all sessions where the user(name) is a teacher or a student
        return sessionRepository.findAll().stream().filter(s ->
                s.getStudents().contains(username) || s.getTeacher() == username
        ).collect(Collectors.toList());
    }

    public SessionBE getSessionById(UUID sessionId) {
        //Return one session having the specified ID
        List<SessionBE> sessionBEs = sessionRepository.findAll().stream()
                .filter(s -> s.getId().equals(sessionId))
                .collect(Collectors.toList());
        if(sessionBEs.size()==0){
            return null;
        }else{
            return sessionBEs.get(0);
        }
    }

    public List<String> getStudentsFromSessionId(UUID sessionId){
        //Return all students from one session
        return getSessionById(sessionId).getStudents();
    }

    //_course_student_
    public boolean isStudentOfCourse(String user, UUID courseID) {
        //Return true if defined student is in specified course
        SessionBE sessionBE = getSessions().stream()
                .filter(s -> s.getCourseID().equals(courseID))
                .collect(Collectors.toList())
                .get(0);
        return sessionBE.getStudents().contains(user);
    }

    //_course_student_
    public boolean isTeacherOfCourse(String user, UUID courseID) {
        //Return true if defined teacher teaches on specified course
        SessionBE sessionBE = getSessions().stream()
                .filter(s -> s.getCourseID().equals(courseID))
                .collect(Collectors.toList())
                .get(0);
        return sessionBE.getTeacher().equals(user);
    }

    //_course_student_
    public boolean isStudentOfSession(String user, UUID sessionID) {
        //Return true if defined student is in specified session
        return getSessionById(sessionID).getStudents().contains(user);
    }

    //_course_teacher_
    public boolean isTeacherOfSession(String user, UUID sessionID) {
        //Return true if defined teacher is in specified session
        return getSessionById(sessionID).getTeacher().equals(user);
    }

}
