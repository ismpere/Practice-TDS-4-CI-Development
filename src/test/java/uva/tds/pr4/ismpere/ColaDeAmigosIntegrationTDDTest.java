package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaDeAmigosIntegrationTDDTest {

	@Test
	public void testPedirVezSinReservarColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 0);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(0, cola.getReservas(a));
	}

	@Test
	public void testPuedeColarseColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
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
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasColaDeDeAmigosUnaReservaValido(){
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
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p1 = cola.getPersonasColadasPor(a);
		
		Persona[] p2 = {b,a};
		Persona[] p3 = {b};
		
		assertNotNull(cola);
		assertNotNull(p1);
		assertEquals(1, cola.getReservas(a));
		assertEquals(0, cola.getReservasRestantes(a));
		assertArrayEquals(p1, p3);
		assertArrayEquals(p2, cola.getPersonas());
	}
	
	@Test
	public void testAtenderPersonaColaDeAmigosUnaPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.atender();
		
		assertNotNull(cola);
		assertTrue(cola.isEmpty());
	}
}
