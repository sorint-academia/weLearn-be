package it.sorint.welearnbe.repository.entity;


public class FileMetadataBE {
	private String id;
	private String filename;
	private Boolean hidden;
	private Boolean locked;
	
	public FileMetadataBE(String id, String filename, Boolean hidden, Boolean locked) {
		super();
		this.id = id;
		this.filename = filename;
		this.hidden = hidden;
		this.locked = locked;
	}
	public FileMetadataBE() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getHidden() {
		return hidden;
	}
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
