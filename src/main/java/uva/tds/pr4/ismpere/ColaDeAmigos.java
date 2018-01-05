package uva.tds.pr4.ismpere;

/**
 * Implementacion de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigos{
	/**
	 * Constructor por defecto sin argumentos de la clase ColaDeAmigos
	 */
	public ColaDeAmigos() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Cosntructor con argumentos de la clase ColaDeAmigos
	 * @param p lista de Persona
	 * @assert.pre p!=null
	 * @assert.pre No contiene ningun null TODO hacer este metodo en Persona
	 * @assert.pre p.length>0
	 * @assert.pre No hay personas repetidas TODO hacer este metodo en Persona
	 */
	public ColaDeAmigos(Persona[] p) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Devuelve una lista de Persona de la ColaDeAmigos
	 * Esta lista estará vacia si la ColaDeAmigos no tiene ninguna Persona
	 * @return personasDeLaCola
	 */
	public Persona[] getPersonas() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve si una persona puede colarse
	 * @param p Persona a colarse
	 * @return puedeColarse
	 * @assert.pre p!=null
	 * @assert.pre !isInCola(p)
	 */
	public boolean puedeColarse(Persona p) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Cuela a una Persona en la ColaDeAmigos
	 * @param p Persona a colar en la ColaDeAmigos
	 * @assert.pre p!=null
	 * @assert.pre !cola.isInCola(p)
	 * @assert.pre puedeColarse(p)
	 */
	public void colar(Persona p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve si una persona esta en la ColaDeAmigos
	 * @param p Persona
	 * @return isInCola
	 */
	public boolean isInCola(Persona a) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Devuelve el numero de amigos para el que reservo una Persona
	 * al entrar en la cola
	 * @param p Persona
	 * @return reservas
	 * @assert.pre isInCola(p)
	 */
	public int getReservas(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Devuelve el numero de reservas que le quedan a una Persona de la cola
	 * @param p Persona
	 * @return reservasRestantes
	 * @assert.pre isInCola(p)
	 */
	public int getReservasRestantes(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Devuelve una lista de Persona coladas por p
	 * La lista estara vacia si p no ha colado a ninguna Persona
	 * @param p Persona
	 * @return lista de Personas coladas por p
	 * @assert.pre isInCola(p)
	 */
	public Persona[] getPersonasColadasPor(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}
	public Persona getPersonaParaAtender() {
		// TODO Auto-generated method stub
		return null;
	}
	public void atender() {
		// TODO Auto-generated method stub
		
	}
	
}