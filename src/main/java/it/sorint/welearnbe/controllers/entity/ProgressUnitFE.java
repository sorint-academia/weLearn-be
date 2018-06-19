package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class ProgressUnitFE {
	private String unitID;
	private Boolean completed;
	private List<ProgressWidgetFE> widgets;
	
	public String getUnitID() {
		return unitID;
	}
	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public List<ProgressWidgetFE> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<ProgressWidgetFE> widgets) {
		this.widgets = widgets;
	}
}
