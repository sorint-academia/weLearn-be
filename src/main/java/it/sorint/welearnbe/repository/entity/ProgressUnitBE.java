package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

public class ProgressUnitBE {
	UUID id;
	List<ProgressWidgetBE> widgets;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public List<ProgressWidgetBE> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<ProgressWidgetBE> widgets) {
		this.widgets = widgets;
	}
}
