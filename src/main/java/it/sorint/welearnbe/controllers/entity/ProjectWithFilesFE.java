package it.sorint.welearnbe.controllers.entity;

import java.util.Set;

public class ProjectWithFilesFE extends ProjectFE {
	private Set<FileFE> files;

	public Set<FileFE> getFiles() {
		return files;
	}

	public void setFiles(Set<FileFE> files) {
		this.files = files;
	}
}
