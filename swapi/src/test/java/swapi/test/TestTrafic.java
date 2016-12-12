package swapi.test;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import swapi.model.People;
import swapi.model.Planet;
import swapi.model.Starship;
import swapi.model.Trafic;

public class TestTrafic extends TestCase {

	public void testeListaTrafic() {

		Starship starship = new Starship();
		Planet planet = new Planet();
		People people1 = new People();
		People people2 = new People();

		List<People> peopleList = new ArrayList<>();

		starship.setName("Nave 1");
		starship.setModel("Nave");
		starship.setPassengers("10");

		planet.setName("Terra");
		planet.setDiameter("100000");
		planet.setPopulation("1564653214");
		planet.setTerrain("Floresta");
		planet.setClimate("Úmido");

		people1.setGender("Male");
		people1.setName("Leandro Rezende");
		peopleList.add(people1);

		people2.setGender("Female");
		people2.setName("Pammela Anderson");
		peopleList.add(people2);

		Trafic trafic = new Trafic(starship, planet, peopleList);

		assertNotNull(trafic);

		List<Trafic> trafics = new ArrayList<>();

		trafics.add(trafic);

		assertTrue(trafics.size() > 0);

		assertNotNull(trafics.get(0));

	}

}
