package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.nuvolamagica.objects.BuildResponse;
import it.sorint.welearnbe.services.BuildAndExecService;

@RestController
@RequestMapping("/api")
public class BuildAndExecController {

	@Autowired
	private BuildAndExecService buildAndExecService;
	
	@GetMapping("/progresses/{student}/projects/{projectID}/build/{executionConfig}")
	public ResponseEntity<BuildResponse> buildProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID, @PathVariable("executionConfig") String executionConfig) {
		final String student2;
		if (student.equals("myself")) {
			student2 = principal.getName();
		} else {
			student2 = student;
		}
		if (student2.equals(principal.getName())) {
			Optional<BuildResponse> out = buildAndExecService.build(principal.getName(), student2, projectID, executionConfig);
			
			if (out.isPresent())
				return ResponseEntity.ok(out.get());
			else
				return ResponseEntity.notFound().build();
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}	
		
		
	}
	
	@GetMapping("/progresses/{student}/projects/{projectID}/exec/{executionConfig}")
	public ResponseEntity<Void> execProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID, @PathVariable("executionConfig") String executionConfig) {
		final String student2;
		if (student.equals("myself")) {
			student2 = principal.getName();
		} else {
			student2 = student;
		}
		if (student2.equals(principal.getName())) {
			boolean res = buildAndExecService.exec(principal.getName(), student2, projectID, executionConfig);
			
			if (res)
				return ResponseEntity.ok().build();
			else
				return ResponseEntity.notFound().build();
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}	
	}

	@GetMapping("/progresses/{student}/projects/{projectID}/stdout")
	public ResponseEntity<byte[]> stdoutProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID) {
		final String student2;
		if (student.equals("myself")) {
			student2 = principal.getName();
		} else {
			student2 = student;
		}
		if (student2.equals(principal.getName())) {
			Optional<byte[]> out = buildAndExecService.pullStdout(principal.getName(), student2, projectID);
			
			if (out.isPresent())
				return ResponseEntity.ok(out.get());
			else
				return ResponseEntity.notFound().build();
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}	
	}

	@GetMapping("/progresses/{student}/projects/{projectID}/stderr")
	public ResponseEntity<byte[]> stderrProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID) {
		final String student2;
		if (student.equals("myself")) {
			student2 = principal.getName();
		} else {
			student2 = student;
		}
		if (student2.equals(principal.getName())) {
			Optional<byte[]> out = buildAndExecService.pullStderr(principal.getName(), student2, projectID);
			
			if (out.isPresent())
				return ResponseEntity.ok(out.get());
			else
				return ResponseEntity.notFound().build();
		} else {
			//Return 403 FORBIDDEN
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}		
	}

//	@PutMapping("/progresses/{student}/projects/{projectID}/stdin")
//	public ResponseEntity<byte[]> writeStdinProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID, InputStream stream) throws IOException {
//		//Get stream content
//		byte[] content = IOUtils.toByteArray(stream);
//		
//		return null;		
//	}	
}
