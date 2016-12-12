package swapi.test;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import swapi.model.People;
import swapi.service.ClientWS;

public class TestPeople  extends TestCase{

	private ClientWS ws = new  ClientWS();
	
	public void testeListaPeople(){
		List<People> peoples = new ArrayList<>();
		peoples = ws.getPeoples();
		
		assertNotNull(peoples);
		
		assertTrue(peoples.size() > 0);
		
		People st = new People();
		
		st = peoples.get(0);
		
		assertNotNull(st);
	}
	

}
