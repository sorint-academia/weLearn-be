package it.sorint.welearnbe.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.services.ProgressAndProgressProject;
import it.sorint.welearnbe.services.ProgressService;

@RestController
@RequestMapping("/api")
public class PingController {

	@GetMapping("/ping")
	public String ping() {
		return "Pong!";
	}
	
	@Autowired
	private ProgressService progressService;
	@GetMapping("/rogna")
	public Optional<ProgressAndProgressProject> rogna() {
		return progressService.getOrCreateProgressProject("studente1", UUID.fromString("bd61e898-7b85-49f7-88ce-571e90e84315"));
	}
}
