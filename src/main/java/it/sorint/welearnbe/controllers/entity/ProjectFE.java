package it.sorint.welearnbe.controllers.entity;

import java.util.Set;

public class ProjectFE {
	private String projectID;
	private String name;
	private String previousProjectID;
	private int version;
	private Set<ExecutionConfigFE> executionConfigs;
	
	
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreviousProjectID() {
		return previousProjectID;
	}
	public void setPreviousProjectID(String previousProjectID) {
		this.previousProjectID = previousProjectID;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Set<ExecutionConfigFE> getExecutionConfigs() {
		return executionConfigs;
	}
	public void setExecutionConfigs(Set<ExecutionConfigFE> executionConfigs) {
		this.executionConfigs = executionConfigs;
	}
}
