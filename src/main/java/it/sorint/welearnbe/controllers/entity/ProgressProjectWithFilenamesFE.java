package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class ProgressProjectWithFilenamesFE extends ProgressProjectFE {
	private List<String> filenames;

	public List<String> getFilenames() {
		return filenames;
	}
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}
}
