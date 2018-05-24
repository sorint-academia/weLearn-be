package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.ProjectFE;
import it.sorint.welearnbe.controllers.entity.ProjectWithFilesFE;
import it.sorint.welearnbe.converter.ProjectConverter;
import it.sorint.welearnbe.repository.entity.ProjectBE;
import it.sorint.welearnbe.services.FileService;
import it.sorint.welearnbe.services.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	@Autowired
	FileService fileService;
	
	@GetMapping("/projects")
	public List<ProjectFE> getProjects(Principal principal) {
		return projectService.getProjects(principal.getName()).stream()
				.map(be -> ProjectConverter.convertToProjectFE(be))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/projects/{projectID}")
	public ResponseEntity<ProjectWithFilesFE> getProject(Principal principal, @PathVariable("projectID") UUID projectID) {
		Optional<ProjectBE> backend = projectService.getProject(principal.getName(), projectID);
		if (backend.isPresent())
			return ResponseEntity.ok(ProjectConverter.convertToProjectWithFilesFE(backend.get(), fileService.getFileMetadatas()));
		else
			return ResponseEntity.notFound().build();
	}
	
	
}
