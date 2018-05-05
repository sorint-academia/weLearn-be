package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projects")
public class ProjectBE {
	UUID id;
	String name;
	String mainFile;
	List<ProjectFileBE> files;
	
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
	public String getMainFile() {
		return mainFile;
	}
	public void setMainFile(String mainFile) {
		this.mainFile = mainFile;
	}
	public List<ProjectFileBE> getFiles() {
		return files;
	}
	public void setFiles(List<ProjectFileBE> files) {
		this.files = files;
	}
}
