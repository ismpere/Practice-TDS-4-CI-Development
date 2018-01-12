package uva.tds.pr4.ismpere;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.easymock.EasyMock;
import org.easymock.Mock;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@Category({Isolation.class})
/**
 * Clase de test TDD en aislamiento de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosIsolationTDDTest {
	
	@Test
	public void testInicializaColaDeAmigosConAmigosIsolationValido() {
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		Persona c = createMock(Persona.class);
		
		Persona[] p = {a,b,c};
		
		for(Persona pe: p)
			pe.setInColaDeAmigos(true);
		expectLastCall();
		
		replay(a);
		replay(b);
		replay(c);
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
		verify(b);
		verify(c);
	}
	
	@Test
	public void testPedirVezSinReservarColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservas()).andReturn((int)0).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(0);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 0);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertArrayEquals(p, cola.getPersonas());
		assertEquals(0, cola.getReservas(a));
		
		verify(a);
	}

	@Test
	public void testPuedeColarseColaDeAmigosIsolationValido(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] p = {a};
		
		expect(b.getAmigos()).andReturn((Persona[])p).once();
		expect(a.isAmigo(b)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		replay(b);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		boolean c1 = cola.puedeColarse(b);
		
		assertNotNull(cola);
		assertTrue(c1);
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testColarseColaDeAmigosIsolationValido(){
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
	public void testGetReservasColaDeDeAmigosUnaReservaIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservas()).andReturn((int)1).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		int r = cola.getReservas(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(1, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
	}
	
	@Test
	public void testGetReservasRestantesColaDeDeAmigosUnaReservaIsolationValido(){
		Persona a = createMock(Persona.class);
		
		expect(a.getReservasRestantes()).andReturn((int)1).once();
		
		a.setInColaDeAmigos(true);
		a.setReservas(1);
		expectLastCall();
		
		replay(a);
		
		ColaDeAmigos cola = new ColaDeAmigos();
		
		cola.pedirVez(a, 1);
		
		int r = cola.getReservasRestantes(a);
		
		Persona[] p = {a};
		
		assertNotNull(cola);
		assertEquals(1, r);
		assertArrayEquals(p, cola.getPersonas());
		
		verify(a);
	}
	
	@Test
	public void testGetPersonasColadasColaDeDeAmigosValidoUnaPersonaColadaIsolation(){
		Persona a = createMock(Persona.class);
		Persona b = createMock(Persona.class);
		
		Persona[] pa = {a};

		expect(b.getAmigos()).andReturn((Persona[])pa).once();
		expect(a.isAmigo(b)).andReturn(true).times(2);
		expect(b.isAmigo(a)).andReturn(true).once();
		expect(a.tieneReservas()).andReturn(true).times(2);
		
		expect(a.getColada()).andReturn(false).once();
		expect(a.getReservas()).andReturn((int)1).times(2);
		expect(a.getReservasRestantes()).andReturn((int)0).times(2);
		
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
		
		Persona[] p1 = cola.getPersonasColadasPor(a);
		
		Persona[] p2 = {b,a};
		Persona[] p3 = {b};
		
		assertNotNull(cola);
		assertNotNull(p1);
		assertEquals(1, cola.getReservas(a));
		assertEquals(0, cola.getReservasRestantes(a));
		assertArrayEquals(p1, p3);
		assertArrayEquals(p2, cola.getPersonas());
		
		verify(a);
		verify(b);
	}
	
	@Test
	public void testAtenderPersonaColaDeAmigosUnaPersonaIsolationValido() {
		Persona a = createMock(Persona.class);
		
		a.setInColaDeAmigos(true);
		a.setInColaDeAmigos(false);
		expectLastCall();
		
		replay(a);
		
		Persona[] p = {a};
		
		ColaDeAmigos cola = new ColaDeAmigos(p);
		
		cola.atender();
		
		assertNotNull(cola);
		assertTrue(cola.isEmpty());
		
		verify(a);
	}
}
