package swapi.model;

import java.io.Serializable;

public class Planet implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String diameter;

	private String climate;

	private String terrain;

	private String population;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", diameter=" + diameter + ", climate=" + climate + ", terrain=" + terrain
				+ ", population=" + population + "]";
	}

}
