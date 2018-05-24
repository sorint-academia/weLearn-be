package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class ProgressWithProgressCourseFE extends ProgressFE {
	private List<ProgressCourseFE> courses;

	public List<ProgressCourseFE> getCourses() {
		return courses;
	}

	public void setCourses(List<ProgressCourseFE> courses) {
		this.courses = courses;
	}
	
}
