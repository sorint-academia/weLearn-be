package it.sorint.welearnbe.services;

import it.sorint.welearnbe.repository.entity.ProgressBE;
import it.sorint.welearnbe.repository.entity.ProgressProjectBE;

public class ProgressAndProgressProject {
	private final ProgressBE progress;
	private final ProgressProjectBE progressProject;
	public ProgressAndProgressProject(ProgressBE progress, ProgressProjectBE progressProject) {
		super();
		this.progress = progress;
		this.progressProject = progressProject;
	}
	
	public ProgressBE getProgress() {
		return progress;
	}
	public ProgressProjectBE getProgressProject() {
		return progressProject;
	}
	
	
}
