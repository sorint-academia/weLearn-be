package it.sorint.welearnbe.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.SessionFE;

@RestController
@RequestMapping("/api")
public class SessionController {

	@GetMapping("/sessions")
	public List<SessionFE> getSessions() {
		return null;
	}
	
	@GetMapping("/sessions/?asStudent")
	public List<SessionFE> getSessionsAsStudent() {
		return null;
	}
	
	@GetMapping("/sessions/?asTeacher")
	public List<SessionFE> getSessionsAsTeacher() {
		return null;
	}
	
	@GetMapping("/sessions/{sessionID}")
	public List<SessionFE> getSession(@PathVariable("sessionID") UUID sessionID) {
		return null;
	}
	
	@GetMapping("/sessions/{sessionID}/students")
	public List<String> getSessionStudents(@PathVariable("sessionID") UUID sessionID) {
		return null;
	}
	
}
