package it.sorint.welearnbe.repository.entity;

public class ProjectFileBE {
	String path;
	Boolean hidden;
	Boolean locked;
	Byte[] content;

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public Byte[] getContent() {
		return content;
	}
	public void setContent(Byte[] content) {
		this.content = content;
	}
}
