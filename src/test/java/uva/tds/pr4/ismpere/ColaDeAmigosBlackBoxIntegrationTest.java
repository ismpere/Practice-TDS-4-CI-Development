package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Integration.class})
/**
 * Clase de test caja negra de integracion de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosBlackBoxIntegrationTest {

	@Test
	public void testInicializaColaDeAmigosConAmigosUnAmigoValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testPedirVezConUnaReservaColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(1, cola.getReservas(a));
	}
	
	@Test
	public void testPedirVezConDiezReservasColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 10);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(10, cola.getReservas(a));
	}
	
	@Test
	public void testPuedeColarseFalseSinAmigosColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		
		Persona[] p = {a};
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testPuedeColarseFalseConAmigosSinReservasColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		
		a.addConocido(c);
		c.addConocido(a);
		a.addAmigo(c);
		c.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		cola.colar(c);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testPuedeColarseFalseConAmigosNoReciprocosColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		a.addConocido(b);
		b.addConocido(a);
		b.addAmigo(a);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testPuedeColarseFalseConAmigosColaDeAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		c.addConocido(b);
		b.addConocido(c);
		c.addAmigo(b);
		b.addAmigo(c);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testPuedeColarseFalseEstaEnLaColaColaDeAmigosValido(){
		Persona a = new Persona("2", "b");
		Persona[] p = {a};
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean c1 = cola.puedeColarse(a);
		
		assertNotNull(cola);
		assertFalse(c1);
	}
	
	@Test
	public void testColarseColaDeAmigosVariosAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		
		c.addConocido(b);
		b.addConocido(c);
		c.addAmigo(b);
		b.addAmigo(c);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		cola.pedirVez(b, 1);
		
		cola.colar(c);
		
		Persona[] p = {a,c,b};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testColarseColaDeAmigosUnoNoReciprocoVariosAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		a.addConocido(b);
		b.addConocido(a);
		b.addAmigo(a);
		
		c.addConocido(b);
		b.addConocido(c);
		c.addAmigo(b);
		b.addAmigo(c);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		cola.pedirVez(c, 1);
		
		cola.colar(b);
		
		Persona[] p = {a,b,c};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testColarseColaDeAmigosUnoNoInColaVariosAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		c.addConocido(b);
		b.addConocido(c);
		c.addAmigo(b);
		b.addAmigo(c);
		
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
	public void testGetReservasColaDeDeAmigosSinReservasValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 0);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasColaDeDeAmigos10ReservasValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 10);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(10, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasColaDeDeAmigosUnaPersonaColadaValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(1, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasColaDeDeAmigosPersonaColadaValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservas(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosSinReservasValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 0);
		
		int r = cola.getReservasRestantes(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosPersonaColadaValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservas(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosUnaPersonaColadaValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservasRestantes(a);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testGetPersonasColadasColaDeDeAmigosNingunaPersonaValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		Persona[] p = cola.getPersonasColadasPor(a);
		
		assertNotNull(cola);
		assertNotNull(p);
		assertEquals(0, p.length);
	}
	
	@Test
	public void testGetPersonasColadasColaDeDeAmigosPersonaColadaValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p = cola.getPersonasColadasPor(b);
		
		assertNotNull(cola);
		assertNotNull(p);
		assertEquals(0, p.length);
	}
	
	@Test
	public void testAtenderColaDeAmigosVariosAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		cola.atender();
		cola.atender();
		
		assertNotNull(cola);
		assertTrue(cola.isEmpty());
	}
}
