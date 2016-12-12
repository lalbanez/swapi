package swapi.test;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import swapi.model.Starship;
import swapi.service.ClientWS;

public class TestStarship extends TestCase{
	
	private ClientWS ws = new  ClientWS();
	
	public void testeListaStarship(){
		List<Starship> starships = new ArrayList<>();
		starships = ws.getStarships();
		
		assertNotNull(starships);
		
		assertTrue(starships.size() > 0);
		
		Starship st = new Starship();
		
		st = starships.get(0);
		
		assertNotNull(st);
		
	}

}
