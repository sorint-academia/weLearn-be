package it.sorint.welearnbe.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sorint.welearnbe.repository.ProjectRepository;
import it.sorint.welearnbe.repository.entity.ProjectBE;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	public List<ProjectBE> getProjects(String username) {
		//FIXME: limit visibility to only viewable projects
		return projectRepository.findAll();
	}

	public Optional<ProjectBE> getProject(String username, UUID projectID) {
		//FIXME: limit visiblity
		return Optional.ofNullable(projectRepository.findOne(projectID));
	}
	
	public Optional<ProjectBE> getProject(UUID projectID) {
		//FIXME: limit visiblity
		return Optional.ofNullable(projectRepository.findOne(projectID));
	}
}
