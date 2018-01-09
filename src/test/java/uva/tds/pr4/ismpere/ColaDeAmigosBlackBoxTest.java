package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaDeAmigosBlackBoxTest {

	@Test
	public void testInicializaColaDeAmigosConAmigosUnAmigoValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testIsEmptyColaDeAmigosFalseValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean c = cola.isEmpty();
		
		assertNotNull(cola);
		assertFalse(c);
	}
	
	@Test
	public void testGetPersonasColaDeAmigosSinAmigosValido() {
		ColaDeAmigos cola = new ColaDeAmigos();
		
		Persona[] p2 = cola.getPersonas();
		
		assertNotNull(cola);
		assertNotNull(p2);
		assertEquals(0, p2.length);
	}
	
	@Test
	public void testIsInColaDeAmigosSinAmigosFalseValido() {
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		boolean is = cola.isInCola(a);
		
		assertNotNull(cola);
		assertFalse(is);
	}
	
	@Test
	public void testIsInColaDeAmigosConAmigosFalseValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		Persona[] p = {a,b};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean is = cola.isInCola(c);
		
		assertNotNull(cola);
		assertFalse(is);
	}
	
	@Test
	public void testPedirVezConUnaReservaColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(1, cola.getReservas(a));
	}
	
	@Test
	public void testPedirVezConDiezReservasColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 10);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(10, cola.getReservas(a));
	}
	
	@Test
	public void testPuedeColarseFalseSinAmigosColaDeAmigosValido(){
		Persona b = new Persona("2", "b");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testPuedeColarseFalseConAmigosSinReservasColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		a.isConocido(b);
		b.isConocido(a);
		a.isAmigo(b);
		b.isAmigo(a);
		
		c.isConocido(a);
		a.isConocido(c);
		c.isAmigo(a);
		a.isAmigo(c);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		cola.colar(c);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testPuedeColarseFalseEstaEnLaColaColaDeAmigosValido(){
		Persona a = new Persona("2", "b");
		Persona[] p = {a};
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean c1 = cola.puedeColarse(a);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testColarseColaDeAmigosVariosAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		a.isConocido(b);
		b.isConocido(a);
		a.isAmigo(b);
		b.isAmigo(a);
		
		c.isConocido(b);
		b.isConocido(c);
		c.isAmigo(b);
		b.isAmigo(c);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		cola.pedirVez(b, 1);
		
		cola.colar(b);
		
		Persona[] p = {c,a,b};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoPersonasNulo() {	
		ColaDeAmigos cola = new ColaDeAmigos(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoUnaPersonaNulo() {
		Persona[] p = {null};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoVariasPersonasNulo() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a, null};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoPersonasRepetidasNulo() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a, a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
	}
	
	@Test
	public void testIsInColaDeAmigosPersonaNuloValido() {
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.isInCola(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezReservasNegativoColaDeAmigosNoValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, -1);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezReservasGrandeColaDeAmigosNoValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 11);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezPersonaNuloColaDeAmigosNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(null, 11);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezPersonaEstaEnLaColaColaDeAmigosNoValido(){
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.pedirVez(a, 1);
	}
	
	@Test (expected = AssertionError.class)
	public void testPuedeColarsePersonaNuloColaDeAmigosNoValido(){
		Persona b = new Persona("2", "b");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.puedeColarse(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testColarseColaDeAmigosPersonaNuloValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.colar(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testColarseColaDeAmigosSinPersonasValido(){
		Persona a = new Persona("a", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.colar(a);
	}
}
