package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projects")
public class ProjectBE {
	private UUID id;
	private String name;
	private UUID previousProjectID;
	private int version;
	List<String> files;
	List<ExecutionConfigBE> executionConfigs;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UUID getPreviousProjectID() {
		return previousProjectID;
	}
	public void setPreviousProjectID(UUID previousProjectID) {
		this.previousProjectID = previousProjectID;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	public List<ExecutionConfigBE> getExecutionConfigs() {
		return executionConfigs;
	}
	public void setExecutionConfigs(List<ExecutionConfigBE> executionConfigs) {
		this.executionConfigs = executionConfigs;
	}
	
}
