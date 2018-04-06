package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.ProgressFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectWithFilenamesFE;

@RestController
@RequestMapping("/api")
public class ProgressController {
	
	@GetMapping("/progresses")
	public ResponseEntity<List<ProgressFE>> getProgresses() {
		return null;
	}
	
	@GetMapping("/progresses/{progressID}")
	public ResponseEntity<ProgressFE> getProgresses(Principal principal, @PathVariable("progressID") UUID progressID) {
		return null;
	}
	
	@GetMapping("/progresses/{progressID}/projects")
	public ResponseEntity<List<ProgressProjectFE>> getProgressProjects(Principal principal, @PathVariable("progressID") UUID progressID) {
		return null;
	}
	
	@GetMapping("/progresses/{progressID}/projects/{projectID}")
	public ResponseEntity<ProgressProjectWithFilenamesFE> getProgressProject(Principal principal, @PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID) {
		return null;
	}
	
	@GetMapping("/progresses/{progressID}/projects/{projectID}/files/**") //I know, the ** and HttpServletRequest suck
	public ResponseEntity<Byte[]> getProgressProject(Principal principal, @PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID, HttpServletRequest request) {
		//Get file name
		String filename = new AntPathMatcher()
	            .extractPathWithinPattern( "/progresses/{progressID}/projects/{projectID}/files/**", request.getRequestURI() );
		//I don't know why but the filename start with files/.
		filename = filename.replaceFirst("files/", "");
		return null;
	}
}
