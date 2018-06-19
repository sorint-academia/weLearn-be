package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

public class UnitBE {
	UUID id;
	String title;
	String description;
	List<WidgetBE> widgets;
	
	public UnitBE() {
		super();
	}
	public UnitBE(UUID id, String title, String description, List<WidgetBE> widgets) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.widgets = widgets;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public List<WidgetBE> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<WidgetBE> widgets) {
		this.widgets = widgets;
	}
}
