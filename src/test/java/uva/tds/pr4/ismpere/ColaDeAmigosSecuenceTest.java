package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Secuence.class})
/**
 * Clase de test de secuencia de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosSecuenceTest {

	@Test
	public void testSecuenciaValidaAtiendeColaDeAmigos() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.atender();
		
		boolean e1 = cola.isEmpty();
		
		cola.pedirVez(a, 2);
		
		cola.colar(b);
		int r1 = cola.getReservasRestantes(a);
		
		Persona p1 = cola.getNextAtendido();
		cola.atender();
		cola.atender();
		
		boolean e2 = cola.isEmpty();
		
		assertNotNull(cola);
		assertTrue(e1);
		assertTrue(e2);
		assertEquals(b, p1);
		assertEquals(1, r1);
	}
	
	@Test (expected = AssertionError.class)
	public void testSecuenciaNoValidaAtiendeSinPersonasColaDeAmigos() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.atender();
		
		cola.pedirVez(a, 2);
		
		cola.colar(b);
		
		cola.atender();
		cola.atender();
		
		cola.atender();
	}
	
	@Test
	public void testSecuenciaAleatoriaValidaColaDeAmigos() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		Persona d = new Persona("4", "d");
		Persona e = new Persona("5", "e");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		
		a.addConocido(d);
		d.addConocido(a);
		a.addAmigo(d);
		d.addAmigo(a);
		
		a.addConocido(e);
		e.addConocido(a);
		a.addAmigo(e);
		e.addAmigo(a);
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.atender();
		
		boolean e1 = cola.isEmpty();
		
		cola.pedirVez(c, 1);
		cola.pedirVez(a, 2);
		
		cola.colar(b);
		cola.colar(d);
		
		boolean c1 = cola.puedeColarse(d);
		
		int r1 = cola.getReservasRestantes(a);
		
		Persona p1 = cola.getNextAtendido();
		cola.atender();
		
		Persona p2 = cola.getNextAtendido();
		
		boolean e2 = cola.isEmpty();
		
		assertNotNull(cola);
		assertTrue(e1);
		assertFalse(e2);
		assertFalse(c1);
		assertEquals(c, p1);
		assertEquals(b, p2);
		assertEquals(0, r1);
	}
}
