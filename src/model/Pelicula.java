package model;
/* Esta es la clase Pelicula. 
 * Incluye los atributos, constructores, getters, setters, y toString, necesarios.
 * 
 * @author IVAN MANTECON DIAZ.
 */
public class Pelicula {
	private String nombre;
	private int agnoEstreno;
	private Categoria categoria;
	
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pelicula(String nombre, int angnoEstreno, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.agnoEstreno = angnoEstreno;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAgnoEstreno() {
		return agnoEstreno;
	}


	public void setAgnoEstreno(int angnoEstreno) {
		this.agnoEstreno = angnoEstreno;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", angnoEstreno=" + agnoEstreno + "]";
	}

	
}
