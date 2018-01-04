package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTDDTest {

	@Test
	public void testInicializaPersonaValido() {
		Persona a = new Persona("12509165V", "Ismael Perez");
		
		assertNotNull(a);
	}
	
	@Test
	public void testGetIdPersonaValido() {
		Persona a = new Persona("12509165V", "Ismael Perez");
		
		String id = a.getId();
		
		assertNotNull(a);
		assertEquals("12509165V", id);
	}
	
	@Test
	public void testGetNombrePersonaValido() {
		Persona a = new Persona("12509165V", "Ismael Perez");
		
		String name = a.getNombre();
		
		assertNotNull(a);
		assertEquals("Ismael Perez", name);
	}
}
