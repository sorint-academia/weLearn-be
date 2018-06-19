package it.sorint.welearnbe.controllers.entity;

import java.util.List;

public class CourseWithUnitsFE extends CourseFE {
	private List<UnitFE> units;
	
	public List<UnitFE> getUnits() {
		return units;
	}
	public void setUnits(List<UnitFE> units) {
		this.units = units;
	}	
}
