package it.sorint.welearnbe.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.BuildResultFE;

@RestController
@RequestMapping("/api")
public class BuildAndExecController {

	@PostMapping("/progresses/{progressID}/projects/{projectID}/build")
	public BuildResultFE buildProgressProject(@PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID) {
		return null;		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/progresses/{progressID}/projects/{projectID}/exec")
	public ResponseEntity execProgressProject(@PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID) {
		return null;		
	}

	@GetMapping("/progresses/{progressID}/projects/{projectID}/stdout")
	public Byte[] stdoutProgressProject(@PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID) {
		return null;		
	}

	@GetMapping("/progresses/{progressID}/projects/{projectID}/stderr")
	public Byte[] stderrProgressProject(@PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID) {
		return null;		
	}

	@PutMapping("/progresses/{progressID}/projects/{projectID}/stdin")
	public Byte[] writeStdinProgressProject(@PathVariable("progressID") UUID progressID, @PathVariable("projectID") UUID projectID, InputStream stream) throws IOException {
		//Get stream content
		byte[] content = IOUtils.toByteArray(stream);
		
		return null;		
	}	
}
