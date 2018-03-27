package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class CourseWithUnitsFE {
	private String courseID;
	private String title;
	private String description;
	private String author;
	private List<UnitFE> units;
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<UnitFE> getUnits() {
		return units;
	}
	public void setUnits(List<UnitFE> units) {
		this.units = units;
	}	
}
