package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Unit.class})
/**
 * Fixture de test de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosConAmigosYColadosTest {
	
	private Persona a,b,c,d,e;
	private ColaDeAmigos cola;
	
	@Before
	public void setUp(){
		a = new Persona("1", "a");
		b = new Persona("2", "b");
		c = new Persona("3", "c");
		d = new Persona("4", "d");
		e = new Persona("5", "e");
		a.isConocido(b);
		b.isConocido(a);
		a.isAmigo(b);
		b.isAmigo(a);
		
		a.isConocido(d);
		d.isConocido(a);
		a.isAmigo(d);
		d.isAmigo(a);
		
		a.isConocido(e);
		e.isConocido(a);
		a.isAmigo(e);
		e.isAmigo(a);
		
		cola = new ColaDeAmigos();
		
		cola.pedirVez(c, 1);
		cola.pedirVez(a, 2);
		
		cola.colar(b);
		cola.colar(d);
	}
	
	@After
	public void tearDown(){
		a = null;
		b = null;
		c = null;
		d = null;
		e = null;
		cola = null;
	}
	
	@Test
	public void testGetPersonasColaValido() {
		Persona[] p1 = cola.getPersonas();
		
		Persona[] p2 = {c,b,d,a};
				
		assertNotNull(p1);
		assertArrayEquals(p2, p1);
	}

	@Test
	public void testGetReservasYReservasRestantesAValido() {
		int r1 = cola.getReservas(a);
		int r2 = cola.getReservasRestantes(a);
				
		assertEquals(2, r1);
		assertEquals(0, r2);
	}

	@Test
	public void testGetPersonasColadasPorAValido() {
		Persona[] p1 = cola.getPersonasColadasPor(a);
		
		Persona[] p2 = {b,d};
				
		assertNotNull(p1);
		assertArrayEquals(p2, p1);
	}
	
	@Test
	public void testGetPersonasColadasPorBColadoValido() {
		Persona[] p = cola.getPersonasColadasPor(b);
				
		assertNotNull(p);
		assertEquals(0, p.length);
	}
	
	@Test
	public void testGetPersonaParaAtenderValido() {
		Persona p1 = cola.getPersonaParaAtender();
		
		assertNotNull(p1);
		assertEquals(c, p1);
	}
}
