package swapi.model;

import java.io.Serializable;
import java.util.List;

public class Trafic implements Serializable {

	private static final long serialVersionUID = 1L;

	private Starship starship;

	private Planet planet;

	private List<People> passengers;

	public Starship getStarship() {
		return starship;
	}

	public void setStarship(Starship starship) {
		this.starship = starship;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public List<People> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<People> passengers) {
		this.passengers = passengers;
	}
	
	public String getSize(){
		return String.valueOf(getPassengers().size());
	}

	public Trafic(Starship starship, Planet planet, List<People> passengers) {
		super();
		this.starship = starship;
		this.planet = planet;
		this.passengers = passengers;
	}

}
