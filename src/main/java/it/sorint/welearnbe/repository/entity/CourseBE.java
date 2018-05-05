package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="courses")
public class CourseBE {
	
	UUID id;
	String title;
	String description;
	String author;
	List<UnitBE> units;
	
	public CourseBE() {
		super();
	}
	public CourseBE(UUID id, String title, String description, String author, List<UnitBE> units) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.units = units;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<UnitBE> getUnits() {
		return units;
	}
	public void setUnits(List<UnitBE> units) {
		this.units = units;
	}
}
