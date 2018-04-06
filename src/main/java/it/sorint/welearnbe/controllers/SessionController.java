package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.SessionFE;

@RestController
@RequestMapping("/api")
public class SessionController {

	@GetMapping("/sessions")
	public ResponseEntity<List<SessionFE>> getSessions(Principal principal) {
		return null;
	}
	
	@GetMapping("/sessions/?asStudent")
	public ResponseEntity<List<SessionFE>> getSessionsAsStudent(Principal principal) {
		return null;
	}
	
	@GetMapping("/sessions/?asTeacher")
	public ResponseEntity<List<SessionFE>> getSessionsAsTeacher(Principal principal) {
		return null;
	}
	
	@GetMapping("/sessions/{sessionID}")
	public ResponseEntity<List<SessionFE>> getSession(Principal principal, @PathVariable("sessionID") UUID sessionID) {
		return null;
	}
	
	@GetMapping("/sessions/{sessionID}/students")
	public ResponseEntity<List<String>> getSessionStudents(Principal principal, @PathVariable("sessionID") UUID sessionID) {
		return null;
	}
	
}
