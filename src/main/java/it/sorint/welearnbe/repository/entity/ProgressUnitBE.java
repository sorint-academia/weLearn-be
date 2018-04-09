package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

public class ProgressUnitBE {
	UUID courseId;
	UUID id;
	Boolean completed;
	List<ProgressWidgetBE> widgets;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public List<ProgressWidgetBE> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<ProgressWidgetBE> widgets) {
		this.widgets = widgets;
	}
	public UUID getCourseId() {
		return courseId;
	}
	public void setCourseId(UUID courseId) {
		this.courseId = courseId;
	}
}
