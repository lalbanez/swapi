package swapi.test;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import swapi.model.Planet;
import swapi.service.ClientWS;

public class TestPlanet extends TestCase {

	ClientWS ws = new ClientWS();
	
	public void testeListaPlanet(){
		List<Planet> planets = new ArrayList<>();
		planets = ws.getPlanets();
		
		assertNotNull(planets);
		
		assertTrue(planets.size() > 0);
		
		Planet st = new Planet();
		
		st = planets.get(0);
		
		assertNotNull(st);
	}
}
