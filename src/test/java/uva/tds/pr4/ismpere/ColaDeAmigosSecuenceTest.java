package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaDeAmigosSecuenceTest {

	@Test
	public void testSecuenciaValidaAtiendeColaDeAmigos() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.isConocido(b);
		b.isConocido(a);
		a.isAmigo(b);
		b.isAmigo(a);
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.atender();
		
		boolean e1 = cola.isEmpty();
		
		cola.pedirVez(a, 2);
		
		cola.colar(b);
		int r1 = cola.getReservasRestantes(a);
		
		Persona p1 = cola.getPersonaParaAtender();
		cola.atender();
		cola.atender();
		
		boolean e2 = cola.isEmpty();
		
		assertNotNull(cola);
		assertTrue(e1);
		assertTrue(e2);
		assertEquals(b, p1);
		assertEquals(1, r1);
	}

}
