package uva.tds.pr4.ismpere;

/**
 * Implementacion de la clase Persona
 * @author ismpere
 */
public class Persona{

	/**
	 * Constructor por defecto de la clase Persona
	 * @param id
	 * @param nombre
	 * @assert.pre id!=null
	 * @assert.pre nombre!=null
	 */
	public Persona(String id, String nombre) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Devuelve el id de la Persona
	 * @return id
	 */
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve el nombre de la Persona
	 * @return nombre
	 */
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Cambia el id de la Persona
	 * @param id
	 * @assert.pre id!=null
	 * @assert.pre id.length>0
	 * @assert.pre id.length<10
	 */
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Cambia el nombre de la persona
	 * @param nombre
	 * @assert.pre nombre!=null
	 * @assert.pre nombre.length>0
	 * @assert.pre nombre.length<50
	 */
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Aniade un conocido de la Persona
	 * @param p Persona conocida
	 * @assert.pre p!=null
	 * @assert.pre !isConocido(p)
	 */
	public void addConocido(Persona p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve una lista de Persona conocidas por la Persona
	 * Esta lista estara vacia si no tiene ningun conocido
	 * @return conocidos
	 */
	public Persona[] getConocidos() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Aniade un amigo de la Persona
	 * @param p Persona amiga
	 * @assert.pre p!=null
	 * @assert.pre isConocido(p)
	 * @assert.pre !isAmigo(p)
	 */
	public void addAmigo(Persona p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve una lista de Persona amigos de nuestra Persona
	 * Esta lista estara vacia si no tiene ningun amigo
	 * @return amigos
	 */
	public Persona[] getAmigos() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve si una persona es conocido
	 * @param p Persona a evaluar si es conocido
	 * @return esConocido
	 * @assert.pre p!=null
	 */
	public boolean isConocido(Persona p) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Devuelve si una Persona es amigo
	 * @param p Persona a evaluar si es amigo
	 * @return isAmigo
	 * @assert.pre p!=null
	 */
	public boolean isAmigo(Persona p) {
		// TODO Auto-generated method stub
		return false;
	}
}