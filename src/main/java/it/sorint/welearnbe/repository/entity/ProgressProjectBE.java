package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;

public class ProgressProjectBE {
	UUID id;
	int version;
	List<ObjectId> files;
	
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
	public List<ObjectId> getFiles() {
		return files;
	}
	public void setFiles(List<ObjectId> files) {
		this.files = files;
	}
}
