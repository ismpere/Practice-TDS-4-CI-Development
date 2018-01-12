package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Unit.class})
/**
 * Clase de test de caja negra de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosBlackBoxTest {

	@Test
	public void testInicializaColaDeAmigosConAmigosUnAmigoValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test
	public void testIsEmptyColaDeAmigosFalseValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean c = cola.isEmpty();
		
		assertNotNull(cola);
		assertFalse(c);
	}
	
	@Test
	public void testGetPersonasColaDeAmigosSinAmigosValido() {
		ColaDeAmigos cola = new ColaDeAmigos();
		
		Persona[] p2 = cola.getPersonas();
		
		assertNotNull(cola);
		assertNotNull(p2);
		assertEquals(0, p2.length);
	}
	
	@Test
	public void testIsInColaDeAmigosSinAmigosFalseValido() {
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		boolean is = cola.isInCola(a);
		
		assertNotNull(cola);
		assertFalse(is);
	}
	
	@Test
	public void testIsInColaDeAmigosConAmigosFalseValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona c = new Persona("3", "c");
		Persona[] p = {a,b};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		boolean is = cola.isInCola(c);
		
		assertNotNull(cola);
		assertFalse(is);
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
		Persona b = new Persona("2", "b");
		ColaDeAmigos cola = new ColaDeAmigos();
		
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
	
	@Test
	public void testGetPersonaParaAtenderColaDeAmigosVariosAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona p1 = cola.getPersonaParaAtender();
		cola.atender();
		
		Persona p2 = cola.getPersonaParaAtender();
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertNotNull(p1);
		assertNotNull(p2);
		assertEquals(b, p1);
		assertEquals(a, p2);
		assertArrayEquals(p, cola.getPersonas());
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoPersonasNulo() {	
		ColaDeAmigos cola = new ColaDeAmigos(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoUnaPersonaNulo() {
		Persona[] p = {null};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoVariasPersonasNulo() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a, null};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
	}
	
	@Test (expected = AssertionError.class)
	public void testInicializaColaDeAmigosConAmigosNoValidoPersonasRepetidasNulo() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a, a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
	}
	
	@Test (expected = AssertionError.class)
	public void testIsInColaDeAmigosPersonaNuloNoValido() {
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.isInCola(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezReservasNegativoColaDeAmigosNoValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, -1);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezReservasGrandeColaDeAmigosNoValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 11);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezPersonaNuloColaDeAmigosNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(null, 11);
	}
	
	@Test (expected = AssertionError.class)
	public void testPedirVezPersonaEstaEnLaColaColaDeAmigosNoValido(){
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.pedirVez(a, 1);
	}
	
	@Test (expected = AssertionError.class)
	public void testPuedeColarsePersonaNuloColaDeAmigosNoValido(){
		Persona b = new Persona("2", "b");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.puedeColarse(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testColarseColaDeAmigosPersonaNuloNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.colar(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testColarseColaDeAmigosSinPersonasNoValido(){
		Persona a = new Persona("a", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.colar(a);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetReservasColaDeDeAmigosPersonaNuloNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getReservas(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetReservasColaDeDeAmigosNotInColaNoValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getReservas(a);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetReservasRestantesColaDeDeAmigosPersonaNuloNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getReservasRestantes(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetReservasRestantesColaDeDeAmigosNotInColaNoValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getReservasRestantes(a);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetPersonasColadasColaDeDeAmigosPersonaNuloNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getPersonasColadasPor(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetPersonasColadasColaDeDeAmigosNotInColaNoValido(){
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getPersonasColadasPor(a);
	}
	
	@Test (expected = AssertionError.class)
	public void testgetPersonaParaAtenderColaDeDeAmigosIsEmptyNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getPersonaParaAtender();
	}
	
	@Test (expected = AssertionError.class)
	public void testAtenderColaDeDeAmigosIsEmptyNoValido(){
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.atender();
	}
	
	@Test (expected = AssertionError.class)
	public void testGetPosicionPersonaNuloNoValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.getPosicion(null);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetPosicionPersonaNotInColaVaciaNoValido() {
		Persona a = new Persona("1", "a");
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.getPosicion(a);
	}
	
	@Test (expected = AssertionError.class)
	public void testGetPosicionPersonaNotInColaNoValido() {
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.getPosicion(b);
	}
}
