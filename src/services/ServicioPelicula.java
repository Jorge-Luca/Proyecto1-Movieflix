package services;

import data.GestorBBDD;
import model.Pelicula;

/*@author Yolanda
 * 
 * Creamos la clase ServicioPelicula
 */
 public class ServicioPelicula {
	
	 /*@utor Yolanda
		 * Creamos método insertaPelicula que muestra los datos insertatPelicula del GestorBBDD
		 */
		
	public static void insertarPelicula (Pelicula p) {
		
		GestorBBDD.insertarPelicula (p);
		
	

}
}