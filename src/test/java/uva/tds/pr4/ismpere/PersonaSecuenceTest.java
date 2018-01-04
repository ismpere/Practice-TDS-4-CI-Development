package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaSecuenceTest {
	
private Persona a, b, c;
	
	@Before
	public void setUp(){
		a = new Persona("1", "a");
		b = new Persona("1", "b");
		c = new Persona("3", "c");
	}
	
	@After
	public void tearDown(){
		a = null;
		b = null;
		c = null;
	}

	@Test
	public void testEliminaAmigoSecuenciaValidaPersona() {
		a.addConocido(b);
		a.addConocido(c);
		a.addAmigo(b);
		a.addAmigo(c);
		
		a.removeAmigo(b);
		a.removeAmigo(c);
		
		Persona[] p1 = {};
		Persona[] p2 = {b,c};
		
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(b);
		assertArrayEquals(p1, a.getAmigos());
		assertArrayEquals(p2, a.getConocidos());
	}
	
	@Test
	public void testCuelaAmigosSecuenciaValidaPersona() {
		a.addConocido(b);
		a.addConocido(c);
		a.addAmigo(b);
		a.addAmigo(c);
		
		a.setInColaDeAmigos(true);
		
		a.setReservas(3);
		
		a.addPersonaColada();
		a.addPersonaColada();
		
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(b);
		assertEquals(3, a.getReservas());
		assertEquals(1, a.getReservasRestantes());
	}
	
	@Test
	public void testSettersSecuenciaAleatoriaValida(){
		a.setId("3");
		a.setNombre("c");
		String a1 = a.getId();
		String a2 = a.getNombre();
		
		a.setId("12345");
		a.setNombre("CincoCincoCincoUno");
		String a3 = a.getId();
		String a4 = a.getNombre();
		
		a.setId("1");
		a.setNombre("a");
		String a5 = a.getId();
		String a6 = a.getNombre();
		
		assertNotNull(a);
		assertEquals("3", a1);
		assertEquals("c", a2);
		assertEquals("12345", a3);
		assertEquals("CincoCincoCincoUno", a4);
		assertEquals("1", a5);
		assertEquals("a", a6);
	}
	
	@Test (expected = AssertionError.class)
	public void testEliminaAmigoSecuenciaNoValida() {
		a.addConocido(b);
		a.addAmigo(b);
		
		a.removeAmigo(b);
		a.removeAmigo(b);
	}
	
	@Test (expected = AssertionError.class)
	public void testCuelaAmigosSecuenciaNoValidaPersona() {
		a.addConocido(b);
		a.addConocido(c);
		a.addAmigo(b);
		a.addAmigo(c);
		
		a.setInColaDeAmigos(true);
		
		a.setReservas(2);
		
		a.addPersonaColada();
		a.addPersonaColada();
		a.addPersonaColada();
	}
}
