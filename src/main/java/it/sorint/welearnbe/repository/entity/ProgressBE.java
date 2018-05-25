package it.sorint.welearnbe.repository.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="progresses")
public class ProgressBE {
	
	@Id
	String student;
	List<ProgressCourseBE> courses;
	List<ProgressProjectBE> projects;
	
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public List<ProgressCourseBE> getCourses() {
		return courses;
	}
	public void setCourses(List<ProgressCourseBE> courses) {
		this.courses = courses;
	}
	public List<ProgressProjectBE> getProjects() {
		return projects;
	}
	public void setProjects(List<ProgressProjectBE> projects) {
		this.projects = projects;
	}
	
}
