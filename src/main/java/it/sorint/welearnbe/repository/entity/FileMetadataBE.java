package it.sorint.welearnbe.repository.entity;


public class FileMetadataBE {
	private Boolean hidden;
	private Boolean locked;
	
	public FileMetadataBE( Boolean hidden, Boolean locked) {
		super();
		this.hidden = hidden;
		this.locked = locked;
	}
	public FileMetadataBE() {
		super();
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
}
