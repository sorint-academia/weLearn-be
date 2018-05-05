package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="progresses")
public class ProgressBE {
	UUID id;
	String student;
	UUID courseID;
	List<ProgressUnitBE> units;
	List<ProgressProjectBE> projects;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public UUID getCourseID() {
		return courseID;
	}
	public void setCourseID(UUID courseID) {
		this.courseID = courseID;
	}
	public List<ProgressUnitBE> getUnits() {
		return units;
	}
	public void setUnits(List<ProgressUnitBE> units) {
		this.units = units;
	}
	public List<ProgressProjectBE> getProjects() {
		return projects;
	}
	public void setProjects(List<ProgressProjectBE> projects) {
		this.projects = projects;
	}
}
