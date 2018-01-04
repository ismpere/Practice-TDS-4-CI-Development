package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaBlackBoxTest {

	@Test
	public void testInicializaPersonaIdGrandeValido() {
		Persona a = new Persona("123456789", "a");
		
		assertNotNull(a);
		assertEquals("123456789", a.getId());
		assertEquals("a", a.getNombre());
	}
	
	@Test
	public void testInicializaPersonaNombreGrandeValido() {
		Persona a = new Persona("1", "CincoCincoCincoCincoCincoCincoCincoCincoCincoCinco");
		
		assertNotNull(a);
		assertEquals("1", a.getId());
		assertEquals("CincoCincoCincoCincoCincoCincoCincoCincoCincoCinco", a.getNombre());
	}

	@Test(expected = AssertionError.class)
	public void testInicializaPersonaIdNuloNoValido() {
		Persona a = new Persona(null, "a");
	}
	
	@Test(expected = AssertionError.class)
	public void testInicializaPersonaNombreNuloNoValido() {
		Persona a = new Persona("1", null);
	}
	
	@Test(expected = AssertionError.class)
	public void testInicializaPersonaIdPequenioNoValido() {
		Persona a = new Persona("", "a");
	}
	
	@Test(expected = AssertionError.class)
	public void testInicializaPersonaIdGrandeNoValido() {
		Persona a = new Persona("1234567890", "a");
	}
	
	@Test(expected = AssertionError.class)
	public void testInicializaPersonaNombrePequenioNoValido() {
		Persona a = new Persona("1", "");
	}
	
	@Test(expected = AssertionError.class)
	public void testInicializaPersonaNombreGrandeNoValido() {
		Persona a = new Persona("1", "CincoCincoCincoCincoCincoCincoCincoCincoCincoCinco+");
	}
}
