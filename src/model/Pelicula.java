package model;
/* Esta es la clase Pelicula. 
 * Incluye los atributos, constructores, getters, setters, y toString, necesarios.
 * 
 * @author IVAN MANTECON DIAZ.
 */
public class Pelicula {
	private String nombre;
	private int angnoEstreno;
	private Categoria categoria;
	
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pelicula(String nombre, int angnoEstreno, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.angnoEstreno = angnoEstreno;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAngnoEstreno() {
		return angnoEstreno;
	}


	public void setAngnoEstreno(int angnoEstreno) {
		this.angnoEstreno = angnoEstreno;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", angnoEstreno=" + angnoEstreno + "]";
	}

	
}
