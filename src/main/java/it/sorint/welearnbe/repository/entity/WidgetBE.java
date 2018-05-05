package it.sorint.welearnbe.repository.entity;

import java.util.UUID;

public class WidgetBE {
	UUID id;
	String type;
	String text;
	String lang;
	UUID projectID;
	String mode;
	
	public WidgetBE() {
		super();
	}
	public WidgetBE(UUID id, String type, String text, String lang, UUID projectID, String mode) {
		super();
		this.id = id;
		this.type = type;
		this.text = text;
		this.lang = lang;
		this.projectID = projectID;
		this.mode = mode;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public UUID getProjectID() {
		return projectID;
	}
	public void setProjectID(UUID projectID) {
		this.projectID = projectID;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
}
