package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@Category({Isolation.class})
/**
 * Clase de test de caja negra de aislamiento de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosBlackBoxIsolationTest {

	@Test
	public void testInicializaColaDeAmigosConAmigosUnAmigoIsolationValido() {
		Persona a = createMock(Persona.class);
		
		a.setInColaDeAmigos(true);
		expectLastCall();
		
		replay(a);
		
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
	}

	@Test
	public void testPedirVezConUnaReservaColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservas()).andReturn((int)1).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(1, cola.getReservas(a));
		
		verify(a);
	}
	
	@Test
	public void testPedirVezConDiezReservasColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservas()).andReturn((int)10).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(10);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 10);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(10, cola.getReservas(a));
		
		verify(a);
	}
	
	@Test
	public void testPuedeColarseFalseSinAmigosColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		
		a.setInColaDeAmigos(true);
		expectLastCall();
		
		replay(a);
		replay(b);
		
		Persona[] p2 = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p2);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testPuedeColarseFalseConAmigosSinReservasColaDeAmigosValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		Persona c = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(c.getAmigos()).andReturn((Persona[])p1).once();
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(c)).andReturn(true).times(2);
		expect(a.isAmigo(b)).andReturn(true).once();
		expect(c.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		expect(a.tieneReservas()).andReturn(false).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		a.addPersonaColada();
		c.setInColaDeAmigos(true);
		c.setColada(true);
		expectLastCall();
		
		replay(a);
		replay(b);
		replay(c);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		cola.colar(c);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
		
		verify(a);
		verify(b);
		verify(c);
	}
	
	@Test
	public void testPuedeColarseFalseConAmigosNoReciprocosColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(false).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		replay(b);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testPuedeColarseFalseConAmigosColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		Persona c = createMock(Persona.class);
		
		Persona[] p1 = {c};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		replay(b);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertFalse(c1);
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testPuedeColarseFalseEstaEnLaColaColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		boolean c1 = cola.puedeColarse(a);
		
		assertNotNull(cola);
		assertFalse(c1);
		
		verify(a);
	}
	
	@Test
	public void testColarseColaDeAmigosVariosAmigosValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		Persona c = createMock(Persona.class);
		
		Persona[] p1 = {a,c};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		
		a.setInColaDeAmigos(true);
		c.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		a.setReservas(1);
		c.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		cola.pedirVez(c, 1);
		
		cola.colar(b);
		
		Persona[] p = {b,a,c};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testColarseColaDeAmigosUnoNoReciprocoVariosAmigosIsolationValido(){	
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		Persona c = createMock(Persona.class);
		
		Persona[] p1 = {c,a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		expect(c.tieneReservas()).andReturn(true).once();
		expect(b.isAmigo(c)).andReturn(true).once();
		expect(c.isAmigo(b)).andReturn(false).times(2);
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		c.setInColaDeAmigos(true);
		a.setReservas(1);
		c.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		expectLastCall();
		
		replay(a);
		replay(b);
		replay(c);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(c, 1);
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p = {c,b,a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
		verify(c);
	}
	
	@Test
	public void testColarseColaDeAmigosUnoNoInColaVariosAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		Persona c = createMock(Persona.class);
		
		Persona[] p1 = {c,a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		b.setInColaDeAmigos(true);
		expectLastCall();
		
		replay(a);
		replay(b);
	
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testGetReservasColaDeDeAmigosSinReservasIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservas()).andReturn((int)0).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(0);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 0);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
	}
	
	@Test
	public void testGetReservasColaDeDeAmigos10ReservasIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservas()).andReturn((int)10).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(10);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 10);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(10, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
	}
	
	@Test
	public void testGetReservasColaDeDeAmigosUnaPersonaColadaIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		expect(a.getReservas()).andReturn((int)1).once();
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		a.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(1, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testGetReservasColaDeDeAmigosPersonaColadaIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		expect(b.getReservas()).andReturn((int)0).once();
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		a.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservas(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosSinReservasIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservasRestantes()).andReturn((int)0).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(0);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 0);
		
		int r = cola.getReservasRestantes(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosPersonaColadaIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		expect(b.getReservasRestantes()).andReturn((int)0).once();
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		a.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservasRestantes(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosUnaPersonaColadaIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		expect(a.getReservasRestantes()).andReturn((int)0).once();
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		a.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		int r = cola.getReservasRestantes(a);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(0, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testGetPersonasColadasColaDeDeAmigosNingunaPersonaIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getColada()).andReturn(false).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		Persona[] p = cola.getPersonasColadasPor(a);
		
		assertNotNull(cola);
		assertNotNull(p);
		assertEquals(0, p.length);
		
		verify(a);
	}
	
	@Test
	public void testGetPersonasColadasColaDeDeAmigosPersonaColadaIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		expect(b.getColada()).andReturn(true).once();
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		a.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		Persona[] p2 = cola.getPersonasColadasPor(b);
		
		Persona[] p = {b,a};
		
		assertNotNull(cola);
		assertEquals(0, p2.length);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testGetPersonasColadasColaDeDeAmigosPersonasAtendidasValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		Persona c = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.getColada()).andReturn(false).once();
		expect(a.getReservas()).andReturn((int)2).once();
		expect(a.getReservasRestantes()).andReturn((int)1).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		c.setInColaDeAmigos(true);
		c.setReservas(0);
		a.setReservas(2);
		b.setColada(true);
		a.addPersonaColada();
		b.setInColaDeAmigos(false);
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 2);
		cola.pedirVez(c, 0);
		
		cola.colar(b);
		
		cola.atender();
		
		Persona[] p2 = cola.getPersonasColadasPor(a);
		
		Persona[] p = {a,c};
		
		assertNotNull(cola);
		assertNotNull(p2);
		assertEquals(0, p2.length);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testAtenderColaDeAmigosVariosAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p1 = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p1).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		
		a.setInColaDeAmigos(true);
		b.setInColaDeAmigos(true);
		a.setReservas(1);
		b.setColada(true);
		a.addPersonaColada();
		a.setInColaDeAmigos(false);
		b.setInColaDeAmigos(false);
		expectLastCall();
		
		replay(a);
		replay(b);

		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		cola.colar(b);
		
		cola.atender();
		cola.atender();
		
		
		assertNotNull(cola);
		assertTrue(cola.isEmpty());
		
		verify(a);
		verify(b);
	}
}
