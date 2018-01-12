package uva.tds.pr4.ismpere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Implementacion de la clase Persona
 * @author ismpere
 */
public class Persona{
	
	private String id;
	private String nombre;
	private ArrayList<Persona> conocidos;
	private ArrayList<Persona> amigos;
	private boolean colado;
	private boolean inCola;
	private int reservas;
	private int reservasUsadas;

	/**
	 * Constructor por defecto de la clase Persona
	 * @param id
	 * @param nombre
	 * @assert.pre id!=null
	 * @assert.pre nombre!=null
	 * @assert.pre id.length>0
	 * @assert.pre id.length<10
	 * @assert.pre nombre.length>0
	 * @assert.pre nombre.length<51
	 */
	public Persona(String id, String nombre) {
		assert(id!=null);
		assert(nombre!=null);
		assert(id.length()>0);
		assert(id.length()<10);
		assert(nombre.length()>0);
		assert(nombre.length()<51);
		
		this.id = id;
		this.nombre = nombre;
		
		conocidos = new ArrayList<>();
		amigos = new ArrayList<>();
		colado = false;
		inCola = false;
		reservas = 0;
		reservasUsadas = 0;
	}
	/**
	 * Devuelve el id de la Persona
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * Devuelve el nombre de la Persona
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Cambia el id de la Persona
	 * @param id
	 * @assert.pre id!=null
	 * @assert.pre id.length>0
	 * @assert.pre id.length<10
	 */
	public void setId(String id) {
		assert(id!=null);
		assert(id.length()>0);
		assert(id.length()<10);
		
		this.id = id;
		
	}
	/**
	 * Cambia el nombre de la persona
	 * @param nombre
	 * @assert.pre nombre!=null
	 * @assert.pre nombre.length>0
	 * @assert.pre nombre.length<50
	 */
	public void setNombre(String nombre) {
		assert(nombre!=null);
		assert(nombre.length()>0);
		assert(nombre.length()<51);
		
		this.nombre = nombre;
	}
	/**
	 * Aniade un conocido de la Persona
	 * @param p Persona conocida
	 * @assert.pre p!=null
	 * @assert.pre !isConocido(p)
	 */
	public void addConocido(Persona p) {
		assert(p!=null);
		assert(!isConocido(p));
		
		conocidos.add(p);
	}
	/**
	 * Devuelve una lista de Persona conocidas por la Persona
	 * Esta lista estara vacia si no tiene ningun conocido
	 * @return conocidos
	 */
	public Persona[] getConocidos() {
		ArrayList<Persona> aux = new ArrayList<>(amigos.size()+conocidos.size());
		aux.addAll(amigos);
		aux.addAll(conocidos);
		
		Persona[] c = new Persona[amigos.size()+conocidos.size()];
		
		return aux.toArray(c);
	}
	/**
	 * Aniade un amigo de la Persona
	 * @param p Persona amiga
	 * @assert.pre p!=null
	 * @assert.pre isConocido(p)
	 * @assert.pre !isAmigo(p)
	 */
	public void addAmigo(Persona p) {
		assert(p!=null);
		assert(isConocido(p));
		assert(!isAmigo(p));
		
		conocidos.remove(conocidos.indexOf(p));
		amigos.add(p);
	}
	/**
	 * Devuelve una lista de Persona amigos de nuestra Persona
	 * Esta lista estara vacia si no tiene ningun amigo
	 * @return amigos
	 */
	public Persona[] getAmigos() {
		Persona[] a = new Persona[amigos.size()];
		
		return amigos.toArray(a);
	}
	/**
	 * Devuelve si una persona es conocido
	 * @param p Persona a evaluar si es conocido
	 * @return esConocido
	 * @assert.pre p!=null
	 */
	public boolean isConocido(Persona p) {
		assert(p!=null);
		
		if(p==this || this.equals(p))
			return true;
		
		return (conocidos.indexOf(p)!=-1 || amigos.indexOf(p)!=-1);
	}
	/**
	 * Devuelve si una Persona es amigo
	 * @param p Persona a evaluar si es amigo
	 * @return isAmigo
	 * @assert.pre p!=null
	 */
	public boolean isAmigo(Persona p) {
		assert(p!=null);
		
		if(p==this || this.equals(p))
			return true;
		
		return amigos.indexOf(p)!=-1;
	}
	/**
	 * Elimina un amigo de la Persona
	 * @param p Persona amigo a eliminar
	 * @assert.pre p!=null
	 * @assert.pre p!=this
	 * @assert.pre !p.equals(this)
	 * @assert.pre isAmigo(p)
	 */
	public void removeAmigo(Persona p) {
		assert(p!=null);
		assert(p!=this);
		assert(!p.equals(this));
		assert(isAmigo(p));
		
		amigos.remove(amigos.indexOf(p));
		conocidos.add(p);
	}
	/**
	 * Pone a una Persona como colada o como no colada por otra Persona
	 * @param colado
	 * @assert.pre isInColaDeAmigos()
	 */
	public void setColado(boolean colado) {
		assert(isInColaDeAmigos());
		
		this.colado = colado;
	}
	/**
	 * Devuelve si una Persona ha sido colada por otra Persona o no
	 * @return colada
	 * @assert.pre isInColaDeAmigos()
	 */
	public boolean colado() {
		assert(isInColaDeAmigos());
		
		return colado;
	}
	/**
	 * Identifica si una Persona está o no en una ColaDeAmigos
	 * @param inCola está en una ColaDeAmigos
	 */
	public void setInColaDeAmigos(boolean inCola) {
		this.inCola = inCola;
		
		if(!inCola){
			reservas=0;
			reservasUsadas=0;
			colado=false;	
		}
	}
	/**
	 * Devuelve si una Persona esta en una ColaDeAmigos
	 * @return estaEnColaDeAmigos
	 */
	public boolean isInColaDeAmigos() {
		return inCola;
	}
	/**
	 * Añade las reservas de sitio que hace una Persona para la cola
	 * @param n Numero de reservas
	 * @assert.pre isInColaDeAmigos()
	 * @assert.pre !colado()
	 * @assert.pre reservas>0
	 * @assert.pre reservas<11
	 */
	public void setReservas(int reservas) {
		assert(isInColaDeAmigos());
		assert(!colado());
		assert(reservas>=0);
		assert(reservas<11);
		
		this.reservas = reservas;
	}
	/**
	 * Devuelve el numero de reservas de sitio que ha hecho una Persona en la cola
	 * @return reservas
	 * @assert.pre isInColaDeAmigos()
	 */
	public int getReservas() {
		assert(isInColaDeAmigos());
		
		if(colado())
			return 0;
		
		return reservas;
	}
	/**
	 * Incrementa en uno el numero de personas coladas por Persona en la cola
	 * @assert.pre isInColaDeAmigos()
	 * @assert.pre !colado()
	 * @assert.pre tieneReservas()
	 */
	public void addPersonaColada() {
		assert(isInColaDeAmigos());
		assert(!colado());
		assert(tieneReservas());
		
		reservasUsadas++;
	}
	/**
	 * Devuelve el numero de reservas restantes para la cola que tiene una Persona
	 * @return reservasRestantes
	 * @assert.pre isInColaDeAmigos()
	 */
	public int getReservasRestantes() {
		assert(isInColaDeAmigos());
		
		if(colado())
			return 0;
		
		return reservas-reservasUsadas;
	}
	/**
	 * Devuelve si una Persona tiene reservas de sitio en la cola
	 * @return tieneReservas
	 * @assert.pre isInColaDeAmigos()
	 */
	public boolean tieneReservas() {
		assert(isInColaDeAmigos());
		
		return getReservasRestantes()!=0;
	}
	/**
	 * Devuelve si hay alguna Persona repetida en una lista de Personas
	 * Si la lista esta vacia devolvera false
	 * @param p lista de Persona
	 * @return hayRepetidas
	 * @assert.pre p!=null
	 * @assert.pre !hayPersonasNulo(p)
	 */
	public static boolean hayPersonasRepetidas(Persona[] p) {
		assert(p!=null);
		assert(!hayPersonasNulo(p));
		
		if(p.length<2)
			return false;
		
		boolean repetida = false;
		ArrayList<Persona> conjuntoAux = new ArrayList<>();
		
		for(int i=0; i<p.length; i++){
			if(conjuntoAux.contains(p[i])){
				repetida = true;
				break;
			}
			else
				conjuntoAux.add(p[i]);
		}
		return repetida;
	}
	/**
	 * Devuelve si hay alguna Persona nulo en una lista de Persona
	 * Si la lista esta vacia devolvera false
	 * @param p lista de Personas
	 * @return hayPersonasNulo
	 * @assert.pre p!=null
	 */
	public static boolean hayPersonasNulo(Persona[] p) {
		assert(p!=null);
		
		if(p.length==0)
			return false;
		
		return Arrays.asList(p).indexOf(null)!=-1;
	}
	
	@Override
	/**
	 * @see 
	 */
	public boolean equals(Object other){
	    if (other == null) 
	    	return false;
	    if (other == this) 
	    	return true;
	    if (!(other instanceof Persona))
	    	return false;
	    
	    return getId().equals(((Persona)other).getId());
	}
	
	@Override
	/**
	 * @see
	 */
    public int hashCode() {
        return Objects.hash(id,nombre);
    }
}