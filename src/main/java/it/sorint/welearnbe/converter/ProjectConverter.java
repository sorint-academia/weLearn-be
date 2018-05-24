package it.sorint.welearnbe.converter;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;

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
		frontend.setPreviousProjectID("/api/projects/" + backend.getPreviousProjectID());
		frontend.setProjectID("/api/projects" + backend.getId());
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
	
	public static ProjectWithFilesFE convertToProjectWithFilesFE(ProjectBE backend, HashMap<ObjectId, FileMetadataBE> filesMetadata) {
		ProjectWithFilesFE frontend = new ProjectWithFilesFE();
		frontend.setName(backend.getName());
		frontend.setPreviousProjectID("/api/projects/" + backend.getPreviousProjectID());
		frontend.setProjectID("/api/projects" + backend.getId());
		frontend.setVersion(backend.getVersion());
		frontend.setExecutionConfigs(backend.getExecutionConfigs().stream().map(be -> convertToExecutionConfigFE(be)).collect(Collectors.toSet()));
		frontend.setFiles(backend.getFiles().stream()
				.map(id -> convertToFileFE(filesMetadata.get(id)))
				.collect(Collectors.toSet()));
		return frontend;
	}
	
	public static FileFE convertToFileFE(FileMetadataBE backend) {
		FileFE frontend = new FileFE();
		frontend.setFilename(backend.getFilename());
		frontend.setHidden(backend.getHidden());
		frontend.setLocked(backend.getLocked());
		return frontend;
	}
}
