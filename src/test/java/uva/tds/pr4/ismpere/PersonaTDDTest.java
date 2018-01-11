package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Unit.class, TDD.class})
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
	
	@Test
	public void testSetIdPequenioPersonaValido() {
		Persona a = new Persona("1", "a");
		
		a.setId("2");
		
		assertNotNull(a);
		assertEquals("2", a.getId());
	}
	
	@Test
	public void testSetNombrePequenioPersonaValido() {
		Persona a = new Persona("1", "a");
		
		a.setNombre("b");
		
		assertNotNull(a);
		assertEquals("b", a.getNombre());
	}
	
	@Test
	public void testIsConocidoPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		
		boolean c = a.isConocido(b);
		
		assertNotNull(a);
		assertNotNull(b);
		assertTrue(c);
	}
	
	@Test
	public void testIsAmigoPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		a.addAmigo(b);
		
		boolean c = a.isAmigo(b);
		
		assertNotNull(a);
		assertNotNull(b);
		assertTrue(a.isConocido(b));
		assertTrue(c);
	}
	
	@Test
	public void testAddConocidoPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		
		Persona[] p = {b};
		
		assertNotNull(a);
		assertNotNull(b);
		assertTrue(a.isConocido(b));
		assertArrayEquals(p, a.getConocidos());
	}
	
	@Test
	public void testGetConocidosPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		
		Persona[] p = a.getConocidos();
		
		Persona[] pAux = {b};
		
		assertNotNull(a);
		assertNotNull(b);
		assertArrayEquals(pAux, p);
	}
	
	@Test
	public void testAddAmigoPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		a.addAmigo(b);
		
		Persona[] p = {b};
		
		assertNotNull(a);
		assertNotNull(b);
		assertTrue(a.isAmigo(b));
		assertTrue(a.isConocido(b));
		assertArrayEquals(p, a.getConocidos());
		assertArrayEquals(p, a.getAmigos());
	}
	
	@Test
	public void testGetAmigosPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		a.addAmigo(b);
		
		Persona[] p = a.getAmigos();
		
		Persona[] pAux = {b};
		
		assertNotNull(a);
		assertNotNull(b);
		assertArrayEquals(pAux, p);
	}
	
	@Test
	public void testRemoveAmigoPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		a.addConocido(b);
		a.addAmigo(b);
		
		a.removeAmigo(b);
		
		Persona[] p1 = {};
		Persona[] p2 = {b};
		
		assertNotNull(a);
		assertNotNull(b);
		assertArrayEquals(p1, a.getAmigos());
		assertArrayEquals(p2, a.getConocidos());
	}
	
	@Test
	public void testSetInColaDeAmigosTruePersonaValido(){
		
		Persona a = new Persona("1", "a");
		
		a.setInColaDeAmigos(true);
		
		assertNotNull(a);
		assertTrue(a.isInColaDeAmigos());
	}
	
	@Test
	public void testIsInColaDeAmigosTruePersonaValido(){
		
		Persona a = new Persona("1", "a");
		
		a.setInColaDeAmigos(true);
		boolean i = a.isInColaDeAmigos();
		
		assertNotNull(a);
		assertTrue(i);
		
		fail("Hago que el test falle ya que su fake implementacion hace que pase en verde");
	}
	
	@Test
	public void testSetColadoTruePersonaValido() {
		Persona a = new Persona("1", "a");
		
		a.setInColaDeAmigos(true);
		a.setColado(true);
		
		assertNotNull(a);
		assertTrue(a.colado());
	}
	
	@Test
	public void testGetColadoPersonaValido() {
		Persona a = new Persona("1", "a");
		
		a.setInColaDeAmigos(true);
		a.setColado(true);
		boolean c = a.colado();
		
		assertNotNull(a);
		assertTrue(c);
	}
	
	@Test
	public void testGetNumeroDeReservasNingunaReservaPersonaValido() {
		Persona a = new Persona("1", "a");
		a.setInColaDeAmigos(true);
		
		int r = a.getReservas();
		
		assertNotNull(a);
		assertEquals(0, r);
		
		fail("Hago que el test falle ya que su fake implementacion hace que pase en verde");
	}
	
	@Test
	public void testSetNumeroDeReservasUnaReservaPersonaValido() {
		Persona a = new Persona("1", "a");
		a.setInColaDeAmigos(true);
		
		a.setReservas(1);
		
		assertNotNull(a);
		assertEquals(1, a.getReservas());
	}
	
	@Test
	public void testAddPersonaColadaPersonaValido() {
		Persona a = new Persona("1", "a");
		a.setInColaDeAmigos(true);
		
		a.setReservas(1);
		
		a.addPersonaColada();
		
		assertNotNull(a);
		
		fail("Hago que el test falle ya que su fake implementacion hace que pase en verde");
	}
	
	@Test
	public void testGetReservasRestantesNingunaReservaPersonaValido() {
		Persona a = new Persona("1", "a");
		a.setInColaDeAmigos(true);
		
		int r = a.getReservasRestantes();
		
		assertNotNull(a);
		assertEquals(0, r);
		
		fail("Hago que el test falle ya que su fake implementacion hace que pase en verde");
	}
	
	@Test
	public void testTieneReservasNingunaReservaPersonaValido() {
		Persona a = new Persona("1", "a");
		a.setInColaDeAmigos(true);
		
		boolean t = a.tieneReservas();
		
		assertNotNull(a);
		assertFalse(t);
		
		fail("Hago que el test falle ya que su fake implementacion hace que pase en verde");
	}
	
	@Test
	public void testPersonasRepetidasDosIgualesTrueValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a,a};
		
		boolean t = Persona.hayPersonasRepetidas(p);
		
		assertNotNull(a);
		assertTrue(t);
	}
}
