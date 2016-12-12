package swapi.model;

import java.io.Serializable;

public class Starship implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String model;

	private String passengers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Starship [name=" + name + ", model=" + model + ", passengers=" + passengers + "]";
	}

}
