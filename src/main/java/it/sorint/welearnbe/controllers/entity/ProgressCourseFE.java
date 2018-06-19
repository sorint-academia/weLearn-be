package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class ProgressCourseFE {
	private String courseID;
	private Boolean completed;
	private List<ProgressUnitFE> units;
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public List<ProgressUnitFE> getUnits() {
		return units;
	}
	public void setUnits(List<ProgressUnitFE> units) {
		this.units = units;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
