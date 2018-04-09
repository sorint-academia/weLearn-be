package it.sorint.welearnbe.repository.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class SessionBE {
	UUID id;
	UUID courseID;
	String teacher;
	List<String> students;
	LocalDate startDate;
	LocalDate endDate;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getCourseID() {
		return courseID;
	}
	public void setCourseID(UUID courseID) {
		this.courseID = courseID;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public List<String> getStudents() {
		return students;
	}
	public void setStudents(List<String> students) {
		this.students = students;
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
