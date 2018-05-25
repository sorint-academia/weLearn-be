package it.sorint.welearnbe.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.nuvolamagica.objects.BuildResponse;
import it.sorint.welearnbe.services.BuildAndExecService;

@RestController
@RequestMapping("/api")
public class BuildAndExecController {

	@Autowired
	private BuildAndExecService buildAndExecService;
	
	@PostMapping("/progresses/{student}/projects/{projectID}/build/{executionConfig}")
	public ResponseEntity<BuildResponse> buildProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID, @PathVariable("executionConfig") String executionConfig) {
		Optional<BuildResponse> out = buildAndExecService.build(principal.getName(), student, projectID, executionConfig);
		
		if (out.isPresent())
			return ResponseEntity.ok(out.get());
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/progresses/{student}/projects/{projectID}/exec/{executionConfig}")
	public ResponseEntity<Void> execProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID, @PathVariable("executionConfig") String executionConfig) {
		return null;		
	}

	@GetMapping("/progresses/{student}/projects/{projectID}/stdout")
	public ResponseEntity<byte[]> stdoutProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID) {
		return null;		
	}

	@GetMapping("/progresses/{student}/projects/{projectID}/stderr")
	public ResponseEntity<byte[]> stderrProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID) {
		return null;		
	}

	@PutMapping("/progresses/{student}/projects/{projectID}/stdin")
	public ResponseEntity<byte[]> writeStdinProgressProject(Principal principal, @PathVariable("student") String student, @PathVariable("projectID") UUID projectID, InputStream stream) throws IOException {
		//Get stream content
		byte[] content = IOUtils.toByteArray(stream);
		
		return null;		
	}	
}
