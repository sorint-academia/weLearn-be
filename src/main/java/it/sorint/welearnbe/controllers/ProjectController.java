package it.sorint.welearnbe.controllers;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sorint.welearnbe.controllers.entity.ProjectFE;
import it.sorint.welearnbe.converter.ProjectConverter;
import it.sorint.welearnbe.services.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/projects")
	public List<ProjectFE> getProjects(Principal principal) {
		return projectService.getProjects(principal.getName()).stream()
				.map(be -> ProjectConverter.convertToProjectFE(be))
				.collect(Collectors.toList());
	}
}
