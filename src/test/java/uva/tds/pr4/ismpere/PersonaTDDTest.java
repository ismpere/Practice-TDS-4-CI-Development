package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTDDTest {

	@Test
	public void testInicializaPersonaNombreIdPequenioValido() {
		Persona a = new Persona("1", "a");
		
		assertNotNull(a);
		assertEquals("1", a.getId());
		assertEquals("a", a.getNombre());
	}
	
	@Test
	public void testGetIdPersonaValido() {
		Persona a = new Persona("1", "a");
		
		String id = a.getId();
		
		assertNotNull(a);
		assertEquals("1", id);
	}
	
	@Test
	public void testGetNombrePersonaValido() {
		Persona a = new Persona("1", "a");
		
		String name = a.getNombre();
		
		assertNotNull(a);
		assertEquals("a", name);
	}
}
