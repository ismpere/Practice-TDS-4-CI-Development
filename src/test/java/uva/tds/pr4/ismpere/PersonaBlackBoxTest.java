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
	
	@Test
	public void testSetIdPersonaIdGrandeValido() {
		Persona a = new Persona("1", "a");
		
		a.setId("123456789");
		
		assertNotNull(a);
		assertEquals("123456789", a.getId());
		assertEquals("a", a.getNombre());
	}
	
	@Test
	public void testSetNombrePersonaIdGrandeValido() {
		Persona a = new Persona("1", "a");
		
		a.setNombre("CincoCincoCincoCincoCincoCincoCincoCincoCincoCinco");
		
		assertNotNull(a);
		assertEquals("1", a.getId());
		assertEquals("CincoCincoCincoCincoCincoCincoCincoCincoCincoCinco", a.getNombre());
	}
	
	@Test
	public void testIsConocidoFalsePersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		boolean c = a.isConocido(b);
		
		assertNotNull(a);
		assertNotNull(b);
		assertFalse(c);
	}
	
	@Test
	public void testIsConocidoTruePersonaThisValido() {
		Persona a = new Persona("1", "a");
		
		boolean c = a.isConocido(a);
		
		assertNotNull(a);
		assertTrue(c);
	}
	
	@Test
	public void testIsConocidoTruePersonaIgualValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("1", "b");
		
		boolean c = a.isConocido(b);
		
		assertNotNull(a);
		assertTrue(c);
	}
	
	@Test
	public void testIsAmigoFalseIsConocidoPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.isConocido(b);
		
		boolean c = a.isAmigo(b);
		
		assertNotNull(a);
		assertNotNull(b);
		assertFalse(c);
	}
	
	@Test
	public void testIsAmigoFalsePersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		boolean c = a.isAmigo(b);
		
		assertNotNull(a);
		assertNotNull(b);
		assertFalse(c);
	}
	
	@Test
	public void testIsAmigoTruePersonaThisValido() {
		Persona a = new Persona("1", "a");
		
		boolean c = a.isAmigo(a);
		
		assertNotNull(a);
		assertTrue(c);
	}
	
	@Test
	public void testIsAmigoTruePersonaIgualValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("1", "b");
		
		boolean c = a.isAmigo(b);
		
		assertNotNull(a);
		assertTrue(c);
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
	
	@Test(expected = AssertionError.class)
	public void testSetIdPersonaIdNuloNoValido() {
		Persona a = new Persona("1", "a");
		
		a.setId(null);
	}
	
	@Test(expected = AssertionError.class)
	public void testSetIdPersonaIdGrandeNoValido() {
		Persona a = new Persona("1", "a");
		
		a.setId("1234567890");
	}
	
	@Test(expected = AssertionError.class)
	public void testSetIdPersonaIdPequenioNoValido() {
		Persona a = new Persona("1", "a");
		
		a.setId("");
	}
	
	@Test(expected = AssertionError.class)
	public void testSetNombrePersonaNombreNuloNoValido() {
		Persona a = new Persona("1", "a");
		
		a.setNombre(null);
	}
	
	@Test(expected = AssertionError.class)
	public void testSetNombrePersonaNombreGrandeNoValido() {
		Persona a = new Persona("1", "a");
		
		a.setNombre("CincoCincoCincoCincoCincoCincoCincoCincoCincoCinco+");
	}
	
	@Test(expected = AssertionError.class)
	public void testSetNombrePersonaNombrePequenioNoValido() {
		Persona a = new Persona("1", "a");
		
		a.setNombre("");
	}
	
	@Test(expected = AssertionError.class)
	public void testIsConocidoPersonaNuloNoValido() {
		Persona a = new Persona("1", "a");
		
		a.isConocido(null);
	}
	
	@Test(expected = AssertionError.class)
	public void testIsAmigoPersonaNuloNoValido() {
		Persona a = new Persona("1", "a");
		
		a.isAmigo(null);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddConocidoPersonaNuloNoValido() {
		Persona a = new Persona("1", "a");
		
		a.addConocido(null);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddConocidoPersonaConocidaNoValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		
		a.addConocido(b);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddConocidoPersonaThisNoValido() {
		Persona a = new Persona("1", "a");
		
		a.addConocido(a);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddConocidoPersonaIgualNoValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("1", "b");
		
		a.addConocido(b);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddAmigoPersonaNuloNoValido() {
		Persona a = new Persona("1", "a");
		
		a.addAmigo(null);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddAmigoPersonaNoConocidaNoValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addAmigo(b);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddAmigoPersonaAmigoNoValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		a.addAmigo(b);
		
		a.addAmigo(b);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddAmigoPersonaThisNoValido() {
		Persona a = new Persona("1", "a");
		
		a.addAmigo(a);
	}
	
	@Test(expected = AssertionError.class)
	public void testAddAmigoPersonaIgualNoValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("1", "b");
		
		a.addAmigo(b);
	}
}
