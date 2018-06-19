package it.sorint.welearnbe.converter;

import java.util.HashMap;
import java.util.stream.Collectors;

import it.sorint.welearnbe.controllers.entity.ExecutionConfigFE;
import it.sorint.welearnbe.controllers.entity.FileFE;
import it.sorint.welearnbe.controllers.entity.ProjectFE;
import it.sorint.welearnbe.controllers.entity.ProjectWithFilesFE;
import it.sorint.welearnbe.repository.entity.ExecutionConfigBE;
import it.sorint.welearnbe.repository.entity.FileMetadataBE;
import it.sorint.welearnbe.repository.entity.ProjectBE;

public class ProjectConverter {
	public static ProjectFE convertToProjectFE(ProjectBE backend) {
		ProjectFE frontend = new ProjectFE();
		frontend.setName(backend.getName());
		if (backend.getPreviousProjectID() != null)
			frontend.setPreviousProjectID("/api/projects/" + backend.getPreviousProjectID());
		else 
			frontend.setPreviousProjectID("");
		frontend.setProjectID("/api/projects/" + backend.getId());
		frontend.setVersion(backend.getVersion());
		frontend.setExecutionConfigs(backend.getExecutionConfigs().stream().map(be -> convertToExecutionConfigFE(be)).collect(Collectors.toSet()));
		return frontend;
	}
	
	public static ExecutionConfigFE convertToExecutionConfigFE(ExecutionConfigBE backend) {
		ExecutionConfigFE frontend = new ExecutionConfigFE();
		frontend.setName(backend.getName());
		frontend.setMainFile(backend.getMainFile());
		frontend.setLang(backend.getLang());
		return frontend;
	}
	
	public static ProjectWithFilesFE convertToProjectWithFilesFE(ProjectBE backend, HashMap<String, FileMetadataBE> filesMetadata, HashMap<String, String> filenames) {
		ProjectWithFilesFE frontend = new ProjectWithFilesFE();
		frontend.setName(backend.getName());
		if (backend.getPreviousProjectID() != null)
			frontend.setPreviousProjectID("/api/projects/" + backend.getPreviousProjectID());
		else 
			frontend.setPreviousProjectID("");
		frontend.setProjectID("/api/projects/" + backend.getId());
		frontend.setVersion(backend.getVersion());
		frontend.setExecutionConfigs(backend.getExecutionConfigs().stream().map(be -> convertToExecutionConfigFE(be)).collect(Collectors.toSet()));
		frontend.setFiles(backend.getFiles().stream()
				.map(id -> convertToFileFE(filenames.get(id), filesMetadata.get(id)))
				.collect(Collectors.toSet()));
		return frontend;
	}
	
	public static FileFE convertToFileFE(String filename, FileMetadataBE backend) {
		FileFE frontend = new FileFE();
		frontend.setFilename(filename);
		frontend.setHidden(backend.getHidden());
		frontend.setLocked(backend.getLocked());
		return frontend;
	}
}
