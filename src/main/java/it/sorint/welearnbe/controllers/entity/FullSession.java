package it.sorint.welearnbe.controllers.entity;

public class FullSession extends SessionFE {
	private CourseWithUnitsFE course;
	private Float progressPercentual;
	
	public CourseWithUnitsFE getCourse() {
		return course;
	}
	public void setCourse(CourseWithUnitsFE course) {
		this.course = course;
	}
	public Float getProgressPercentual() {
		return progressPercentual;
	}
	public void setProgressPercentual(Float progressPercentual) {
		this.progressPercentual = progressPercentual;
	}
}
