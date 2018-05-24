package it.sorint.welearnbe.repository.entity;

import java.util.List;
import java.util.UUID;

public class ProgressCourseBE {
	private UUID id;
	private List<ProgressUnitBE> units;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public List<ProgressUnitBE> getUnits() {
		return units;
	}
	public void setUnits(List<ProgressUnitBE> units) {
		this.units = units;
	}
}
