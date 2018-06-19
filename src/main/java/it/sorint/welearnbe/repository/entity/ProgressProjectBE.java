package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;


public class ProgressProjectBE {
	UUID id;
	int version;
	List<String> files;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
}
