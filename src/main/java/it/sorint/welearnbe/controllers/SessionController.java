package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import it.sorint.welearnbe.converter.SessionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.FullSessionFE;
import it.sorint.welearnbe.controllers.entity.SessionFE;
import it.sorint.welearnbe.services.CourseService;
import it.sorint.welearnbe.services.SessionService;

@RestController
@RequestMapping("/api")
public class SessionController {

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value="/sessions")
	public ResponseEntity<List<SessionFE>> getSessions(Principal principal) {
	    //TODO: Return the list of sessions asStudent or asTeacher
		return null;
	}
	
	@GetMapping(value="/sessions", params="asStudent")
	public ResponseEntity<List<SessionFE>> getSessionsAsStudent(Principal principal) {
		//Return the list of the principal's sessions as student converted to SessionFE
		return ResponseEntity.ok(
                sessionService.getSessionsByStudentName(principal.getName()).stream()
                        .map(be -> SessionConverter.convertToSessionFE(be, principal.getName()))
                .collect(Collectors.toList())
        );
	}

	@GetMapping(value="/sessions", params="asTeacher")
	public ResponseEntity<List<SessionFE>> getSessionsAsTeacher(Principal principal) {
		//Return the list of the principal's sessions as teacher converted to SessionFE
		return ResponseEntity.ok(
                sessionService.getSessionsByTeacherName(principal.getName()).stream()
                        .map(be -> SessionConverter.convertToSessionFE(be, principal.getName()))
                        .collect(Collectors.toList())
        );
	}

	@GetMapping(value="/sessions", params="full")
	public ResponseEntity<List<FullSessionFE>> getSessionsFull(Principal principal) {
	    //TODO: Return the list of sessions asStudent or asTeacher
		return null;
	}
	
	@GetMapping(value="/sessions", params={"full", "asStudent"})
	public ResponseEntity<List<FullSessionFE>> getSessionsAsStudentFull(Principal principal) {
		//Return the list of the principal's sessions as student converted to SessionFE
		return ResponseEntity.ok(
                sessionService.getSessionsByStudentName(principal.getName()).stream()
                        .map(be -> SessionConverter.convertToFullSessionFE(be, principal.getName(), courseService.getCourseById(principal.getName(), be.getCourseID())))
                .collect(Collectors.toList())
        );
	}

	@GetMapping(value="/sessions", params= {"full", "asTeacher"})
	public ResponseEntity<List<FullSessionFE>> getSessionsAsTeacherFull(Principal principal) {
		//Return the list of the principal's sessions as teacher converted to SessionFE
		return ResponseEntity.ok(
                sessionService.getSessionsByTeacherName(principal.getName()).stream()
                        .map(be -> SessionConverter.convertToFullSessionFE(be, principal.getName(), courseService.getCourseById(principal.getName(), be.getCourseID())))
                        .collect(Collectors.toList())
        );
	}
	
	@GetMapping("/sessions/{sessionID}")
	public ResponseEntity<SessionFE> getSession(Principal principal, @PathVariable("sessionID") UUID sessionID) {
		//Check if the principal is the course's teacher or course's student
		if (sessionService.isStudentOfSession(principal.getName(), sessionID) | sessionService.isTeacherOfSession(principal.getName(), sessionID)) {
			SessionFE sessionFE = SessionConverter.convertToSessionFE(sessionService.getSessionById(sessionID), principal.getName());

			if(sessionFE==null){
				//Return 404 NOT FOUND
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.ok(sessionFE);
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}

	@GetMapping("/sessions/{sessionID}/students")
	public ResponseEntity<List<String>> getSessionStudents(Principal principal, @PathVariable("sessionID") UUID sessionID) {
		//Check if the principal is the course's teacher or course's student
		if (sessionService.isStudentOfSession(principal.getName(), sessionID) | sessionService.isTeacherOfSession(principal.getName(), sessionID)) {
			List<String> students = sessionService.getStudentsFromSessionId(sessionID);
			if(students.size()==0){
				//Return 404 NOT FOUND
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}else{
				return ResponseEntity.ok(students);
			}
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}
