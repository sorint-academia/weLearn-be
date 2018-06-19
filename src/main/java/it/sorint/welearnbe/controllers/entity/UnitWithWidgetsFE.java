package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class UnitWithWidgetsFE {
	private String unitID;
	private String title;
	private String description;
	private List<WidgetFE> widgets;
	
	public String getUnitID() {
		return unitID;
	}
	public void setUnitID(String unitID) {
		this.unitID = unitID;
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
	public List<WidgetFE> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<WidgetFE> widgets) {
		this.widgets = widgets;
	}
}
