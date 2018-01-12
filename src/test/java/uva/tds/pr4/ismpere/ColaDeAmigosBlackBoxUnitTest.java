package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Unit.class})
/**
 * Clase de test de caja negra de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosBlackBoxUnitTest {
	
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
	public void testGetPersonaParaAtenderColaDeAmigosVariosAmigosValido(){
		Persona a = new Persona("1", "a");
		Persona b = new Persona("2", "b");
		a.addConocido(b);
		b.addConocido(a);
		a.addAmigo(b);
		b.addAmigo(a);
		
		Persona[] p = {b,a};

		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		Persona p1 = cola.getPersonaParaAtender();
		cola.atender();
		
		Persona p2 = cola.getPersonaParaAtender();
		
		Persona[] p3 = {a};
		
		assertNotNull(cola);
		assertNotNull(p1);
		assertNotNull(p2);
		assertEquals(b, p1);
		assertEquals(a, p2);
		assertArrayEquals(p3, cola.getPersonas());
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
	public void testInicializaColaDeAmigosConListaVaciaNoValido() {
		Persona a = new Persona("1", "a");
		Persona[] p = {};
		
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
		
		cola.pedirVez(null, 1);
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
		Persona a = new Persona("1", "a");
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.colar(a);
	}
	
	@Test (expected = AssertionError.class)
	public void testColarseColaDeAmigosIsInColaNoValido(){
		Persona a = new Persona("1", "a");
		Persona[] p = {a};
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
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
