package it.sorint.welearnbe.repository.entity;

import java.util.UUID;

public class ProgressWidgetBE {
	UUID id;
	Boolean completed;
	
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
}
