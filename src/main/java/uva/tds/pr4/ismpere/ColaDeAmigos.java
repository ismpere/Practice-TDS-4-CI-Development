package uva.tds.pr4.ismpere;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementacion de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigos{
	
	ArrayList<Persona> personas;
	
	/**
	 * Constructor por defecto sin argumentos de la clase ColaDeAmigos
	 */
	public ColaDeAmigos() {
		personas = new ArrayList<>();
	}
	/**
	 * Cosntructor con argumentos de la clase ColaDeAmigos
	 * @param p lista de Persona
	 * @assert.pre personas!=null
	 * @assert.pre !Persona.hayPersonasNulo(personas)
	 * @assert.pre personas.length>0
	 * @assert.pre !Persona.hayPersonasRepetidas(personas)
	 */
	public ColaDeAmigos(Persona[] personas) {
		assert(personas!=null);
		assert(!Persona.hayPersonasNulo(personas));
		assert(personas.length>0);
		assert(!Persona.hayPersonasRepetidas(personas));
		
		this.personas = new ArrayList<>(Arrays.asList(personas));
	}
	/**
	 * Devuelve una lista de Persona de la ColaDeAmigos
	 * Esta lista estará vacia si la ColaDeAmigos no tiene ninguna Persona
	 * @return personasDeLaCola
	 */
	public Persona[] getPersonas() {
		Persona[] a = new Persona[personas.size()];
		
		return personas.toArray(a);
	}
	/**
	 * Pide la vez para entrar en la cola de amigos con n reservas de sitio
	 * @param p Persona a entrar en la ColaDeAmigos
	 * @param n Numero de sitios que reserva
	 * @assert.pre p!=null
	 * @assert.pre !isInCola(p)
	 * @assert.pre n>0
	 * @assert.pre n<11
	 */
	public void pedirVez(Persona p, int n) {
		assert(p!=null);
		assert(isInCola(p));
		assert(n>0);
		assert(n<11);
		
		p.setInColaDeAmigos(true);
		p.setReservas(n);
		personas.add(p);
	}
	/**
	 * Devuelve si una persona puede colarse
	 * @param p Persona a colarse
	 * @return puedeColarse
	 * @assert.pre p!=null
	 */
	public boolean puedeColarse(Persona p) {
		assert(p!=null);
		
		if(isInCola(p) || isEmpty())
			return false;
		
		boolean puede = false;
		Persona[] a = p.getAmigos();
		
		for(int i=0; i<a.length; i++){
			Persona pa = a[i];
			if(isInCola(pa) && pa.isAmigo(p) && pa.tieneReservas()){
				puede = true;
				break;
			}
		}
		
		return puede;
	}
	/**
	 * Cuela a una Persona en la ColaDeAmigos
	 * @param p Persona a colar en la ColaDeAmigos
	 * @assert.pre p!=null
	 * @assert.pre !isInCola(p)
	 * @assert.pre puedeColarse(p)
	 */
	public void colar(Persona p) {
		assert(p!=null);
		assert(!isInCola(p));
		assert(puedeColarse(p));
		
		for(int i=0; i<personas.size(); i++){
			Persona pa = personas.get(i);
			if(pa.tieneReservas() && p.isAmigo(pa) && pa.isAmigo(p)){
				personas.add(i, p);
			}
		}
	}
	/**
	 * Devuelve si una persona esta en la ColaDeAmigos
	 * @param p Persona
	 * @return isInCola
	 * @assert.pre p!=null
	 */
	public boolean isInCola(Persona p) {
		assert(p!=null);
		
		if(isEmpty())
			return false;
		
		return personas.contains(p);
	}
	/**
	 * Devuelve el numero de amigos para el que reservo una Persona
	 * al entrar en la cola
	 * @param p Persona
	 * @return reservas
	 * @assert.pre p!=null
	 * @assert.pre isInCola(p)
	 */
	public int getReservas(Persona p) {
		assert(p!=null);
		assert(isInCola(p));
		
		return p.getReservas();
	}
	/**
	 * Devuelve el numero de reservas que le quedan a una Persona de la cola
	 * @param p Persona
	 * @return reservasRestantes
	 * @assert.pre p!=null
	 * @assert.pre isInCola(p)
	 */
	public int getReservasRestantes(Persona p) {
		assert(p!=null);
		assert(isInCola(p));
		
		return p.getReservasRestantes();
	}
	/**
	 * Devuelve una lista de Persona coladas por p
	 * La lista estara vacia si p no ha colado a ninguna Persona
	 * @param p Persona
	 * @return lista de Personas coladas por p
	 * @assert.pre p!=null
	 * @assert.pre isInCola(p)
	 */
	public Persona[] getPersonasColadasPor(Persona p) {
		assert(p!=null);
		assert(isInCola(p));
		
		ArrayList<Persona> coladas = new ArrayList<>();
		
		Persona[] c = {};
		if(p.colado() || personas.size()==1){
			return c;
		}
		
		int posIni = getPosicion(p)-2;
		int r = getReservas(p)-getReservasRestantes(p);
		
		for(int i=posIni; i>=0 && r>0; i--, r--){
			coladas.add(personas.get(i));
		}
		
		c = new Persona[coladas.size()];
		
		return coladas.toArray(c);
	}
	/**
	 * Devuelve la Persona a la que le toca ser atendida segun el orden de la cola
	 * @return personaParaAtender
	 * @assert.pre !isEmpty()
	 */
	public Persona getPersonaParaAtender() {
		assert(!isEmpty());
		
		return personas.get(0);
	}
	/**
	 * Atiende a la persona que esta en la primera posicion de la ColaDeAmigos
	 * @assert.pre !isEmpty()
	 */
	public void atender() {
		assert(!isEmpty());
		
		personas.remove(0);
	}
	/**
	 * Devuelve si la ColaDeAmigos esta vacia
	 * @return isEmpty
	 */
	public boolean isEmpty() {
		return personas.isEmpty();
	}
	/**
	 * Devuelve la posicion en la que esta una Persona en la ColaDeAmigos 
	 * @param p Persona
	 * @return posicion
	 * @assert.pre p!=null
	 * @assert.pre isInCola(p)
	 */
	public int getPosicion(Persona p) {
		assert(p!=null);
		assert(isInCola(p));
		
		int pos = 0;
		
		for(int i=0; i<personas.size(); i++){
			Persona pAux = personas.get(i);
			if(p.equals(pAux)){
				pos = i;
				break;
			}
		}
		
		return pos+1;
	}
	
}