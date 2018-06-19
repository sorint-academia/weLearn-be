package it.sorint.welearnbe.controllers.entity;

public class FullSessionFE extends SessionFE {
	private CourseWithUnitsFE course;

	public CourseWithUnitsFE getCourse() {
		return course;
	}
	public void setCourse(CourseWithUnitsFE course) {
		this.course = course;
	}
}
