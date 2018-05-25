package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.ProgressFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectFE;
import it.sorint.welearnbe.controllers.entity.ProgressProjectWithFilenamesFE;
import it.sorint.welearnbe.converter.ProgressConverter;
import it.sorint.welearnbe.repository.entity.ProgressBE;
import it.sorint.welearnbe.repository.entity.ProgressProjectBE;
import it.sorint.welearnbe.services.ProgressService;

@RestController
@RequestMapping("/api")
public class ProgressController {
	
	@Autowired
	private ProgressService progressService;
	
	@GetMapping("/progresses")
	public List<ProgressFE> getProgresses(Principal principal) {
		return progressService.getProgresses(principal.getName()).stream()
				.map(be -> ProgressConverter.convertToProgressFE(be))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/progresses/{student}")
	public ResponseEntity<ProgressFE> getProgresses(Principal principal, @PathVariable("progressID") String student) {
		//Return if the principal is the progress' student
		if (student == "myself") {
			student = principal.getName();
		}
		if (student == principal.getName()) {
			Optional<ProgressBE> be = progressService.getProgress(student);
			if (be.isPresent())
				return ResponseEntity.ok(ProgressConverter.convertToProgressWithProgressCourseFE(be.get()));
			else
				return ResponseEntity.notFound().build();
			
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@GetMapping("/progresses/{student}/projects")
	public ResponseEntity<List<ProgressProjectFE>> getProgressProjects(Principal principal, @PathVariable("student") final String student) {
		//Return if the principal is the progress' student
		final String student2;
		if (student == "myself") {
			student2 = principal.getName();
		} else {
			student2 = student;
		}
		if (student == principal.getName()) {
			Optional<ProgressBE> be = progressService.getProgress(student2, principal.getName());
			if (be.isPresent())
				return ResponseEntity.ok(be.get().getProjects().stream()
						.map(item -> ProgressConverter.convertToProgressProjectFE(item, "/progresses/" + student2))
						.collect(Collectors.toList()));
			else
				return ResponseEntity.notFound().build();
			
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@GetMapping("/progresses/{progressID}/projects/{projectID}")
	public ResponseEntity<ProgressProjectWithFilenamesFE> getProgressProject(Principal principal, @PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID) {
		//Return if the principal is the progress' student
		if (progressService.isStudentOfProgress(principal.getName(), progressID)) {
			//TODO: return the correct value! not null
			return ResponseEntity.ok(null);	
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@GetMapping("/progresses/{progressID}/projects/{projectID}/files/**") //I know, the ** and HttpServletRequest suck
	public ResponseEntity<Byte[]> getProgressProject(Principal principal, @PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID, HttpServletRequest request) {
		//Get file name
		String filename = new AntPathMatcher()
	            .extractPathWithinPattern( "/progresses/{progressID}/projects/{projectID}/files/**", request.getRequestURI() );
		//I don't know why but the filename start with files/.
		filename = filename.replaceFirst("files/", "");
		//Return if the principal is the progress' student
		if (progressService.isStudentOfProgress(principal.getName(), progressID)) {
			//TODO: return the correct value! not null
			return ResponseEntity.ok(null);	
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}
