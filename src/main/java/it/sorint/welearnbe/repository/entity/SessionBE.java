package it.sorint.welearnbe.repository.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sessions")
public class SessionBE {
	UUID id;
	UUID courseID;
	String teacher;
	List<String> students;
	LocalDate startDate;
	LocalDate endDate;
	
	public SessionBE() {
		super();
	}
	public SessionBE(UUID id, UUID courseID, String teacher, List<String> students, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.id = id;
		this.courseID = courseID;
		this.teacher = teacher;
		this.students = students;
		this.startDate = startDate;
		this.endDate = endDate;
	}
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
