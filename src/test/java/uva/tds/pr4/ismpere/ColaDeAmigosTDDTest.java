package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaDeAmigosTDDTest {

	@Test
	public void testInicializaColaDeAmigosSinNadieValido() {
		ColaDeAmigos cola = new ColaDeAmigos();
		
		assertNotNull(cola);
	}
	
	@Test
	public void testInicializaColaDeAmigosConAmigosValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		Persona[] p = {a,b,c};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetPersonasColaDeAmigosValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		Persona[] p = {a,b,c};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		Persona[] p2 = cola.getPersonas();
		
		assertNotNull(cola);
		assertNotNull(p2);
		assertArrayEquals(p2, p);
	}
	
	@Test
	public void testIsInColaDeAmigosTrueValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		Persona[] p = {a,b,c};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean is = cola.isInCola(a);
		
		assertNotNull(cola);
		assertTrue(is);
	}
	
	@Test
	public void testPedirVezSinReservarColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 0);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testPuedeColarseColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.isConocido(b);
		b.isConocido(a);
		a.isAmigo(b);
		b.isAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertTrue(c1);
	}
	
	@Test
	public void testColarseColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.isConocido(b);
		b.isConocido(a);
		a.isAmigo(b);
		b.isAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasColaDeDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(1, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		int r = cola.getReservasRestantes(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(1, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetPersonasColadasColaDeDeAmigosValidoUnaPersonaColada(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.isConocido(b);
		b.isConocido(a);
		a.isAmigo(b);
		b.isAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p1 = cola.getPersonasColadasPor(a);
		
		Persona[] p2 = {b,a};
		Persona[] p3 = {b};
		
		assertNotNull(cola);
		assertEquals(1, cola.getReservas(a));
		assertEquals(0, cola.getReservasRestantes(a));
		assertArrayEquals(p1, p3);
		assertArrayEquals(p2, cola.getPersonas());
	}
	
	@Test
	public void testGetPersonaAAtenderColaDeAmigosUnaPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		Persona p1 = cola.getPersonaParaAtender();
		
		assertNotNull(cola);
		assertEquals(p1, a);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testAtenderPersonaColaDeAmigosUnaPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		Persona p1 = cola.atender();
		
		Persona[] p2 = {};
		
		assertNotNull(cola);
		assertEquals(p1, a);
		assertArrayEquals(p2, cola.getPersonas());
	}
}
