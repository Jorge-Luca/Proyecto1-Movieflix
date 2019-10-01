package model;

//@author Yolanda

public enum Categoria {
	/*@author Yolanda
	 * 
	 * valor de las constantes que recoge cada categoria y cada pelicula
	 */
	POLICIACA("Policiaca"),ROMANTICA("Romantica"), AVENTURA("Aventuras"), COMEDIA("Comedia"), ANIMACION("Animacion"),THRILLER("Thriller");
	
	private final String nombre;

	private Categoria(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
