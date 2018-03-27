package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class ProgressProjectWithFilenamesFE {
	private String progressProjectID;
	private String projectID;
	private int version;
	private List<String> filenames;
	
	public String getProgressProjectID() {
		return progressProjectID;
	}
	public void setProgressProjectID(String progressProjectID) {
		this.progressProjectID = progressProjectID;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public List<String> getFilenames() {
		return filenames;
	}
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}
}
