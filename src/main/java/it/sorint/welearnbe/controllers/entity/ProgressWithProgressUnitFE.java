package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class ProgressWithProgressUnitFE {
	private String progressID;
	private String studentID;
	private String courseID;
	private List<ProgressUnitFE> units;
	
	public String getProgressID() {
		return progressID;
	}
	public void setProgressID(String progressID) {
		this.progressID = progressID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
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
}
