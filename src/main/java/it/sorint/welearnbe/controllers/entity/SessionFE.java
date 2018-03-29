package it.sorint.welearnbe.controllers.entity;

import java.time.LocalDate;
import java.util.List;

public class SessionFE {
	private String sessionID;
	private String courseID;
	private String teacherID;
	private List<String> studentsID;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public List<String> getStudentsID() {
		return studentsID;
	}
	public void setStudentsID(List<String> studentsID) {
		this.studentsID = studentsID;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
