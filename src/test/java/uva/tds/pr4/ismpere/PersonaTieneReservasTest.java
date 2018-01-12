package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Unit.class})
/**
 * Fixture de test de la clase Persona
 * @author ismpere
 */
public class PersonaTieneReservasTest {
	
	private Persona a, b, c;
	
	@Before
	public void setUp(){
		a = new Persona("1", "a");
		b = new Persona("2", "b");
		c = new Persona("3", "c");
		
		a.addConocido(b);
		a.addConocido(c);
		a.addAmigo(b);
		a.addAmigo(c);
		
		a.setInColaDeAmigos(true);
		
		a.setReservas(2);
		
		a.addPersonaColada();
	}
	
	@After
	public void tearDown(){
		a = null;
		b = null;
		c = null;
	}

	@Test
	public void testFixturePersonaTienePersonasColadas() {
		int r1 = a.getReservas();
		int r2 = a.getReservasRestantes();
		
		boolean r3 = a.tieneReservas();
		
		boolean c1 = a.getColado();
		
		boolean c2 = a.isInColaDeAmigos();
		
		assertNotNull(a);
		assertEquals(2, r1);
		assertEquals(1, r2);
		assertTrue(r3);
		assertFalse(c1);
		assertTrue(c2);
	}
}
