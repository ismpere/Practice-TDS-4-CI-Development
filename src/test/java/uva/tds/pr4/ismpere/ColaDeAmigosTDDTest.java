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
		Persona b = new Persona("1", "b");
		Persona c = new Persona("3", "c");
		Persona[] p = {a,b,c};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		assertNotNull(cola);
	}
	
	@Test
	public void testGetPersonasColaDeAmigosValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("1", "b");
		Persona c = new Persona("3", "c");
		Persona[] p = {a,b,c};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		Persona[] p2 = cola.getPersonas();
		
		assertNotNull(cola);
		assertNotNull(p2);
		assertArrayEquals(p2, p);
	}
}
