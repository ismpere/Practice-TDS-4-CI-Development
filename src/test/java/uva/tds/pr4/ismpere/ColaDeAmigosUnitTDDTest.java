package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Unit.class})
/**
 * Clase de test TDD de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosUnitTDDTest {

	@Test
	public void testInicializaColaDeAmigosSinNadieValido() {
		ColaDeAmigos cola = new ColaDeAmigos();
		
		Persona[] p = {};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testIsEmptyColaDeAmigosTrueValido() {
		ColaDeAmigos cola = new ColaDeAmigos();
		
		boolean c = cola.isEmpty();
		
		assertNotNull(cola);
		assertTrue(c);
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
	public void testGetPersonaParaAtenderColaDeAmigosUnaPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		Persona p1 = cola.getPersonaParaAtender();
		
		assertNotNull(cola);
		assertNotNull(p1);
		assertEquals(p1, a);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetPosicionPersonaValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		int pos = cola.getPosicion(a);
		
		assertNotNull(a);
		assertEquals(1, pos);
	}
}
