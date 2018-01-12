package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Integration.class})
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
		
		Persona[] p2 = {d,b};
				
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
	public void testGetNextAtendidoValido() {
		Persona p1 = cola.getNextAtendido();
		
		assertNotNull(p1);
		assertEquals(c, p1);
	}
}
