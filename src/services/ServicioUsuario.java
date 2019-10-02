package services;

import model.Pelicula;
import data.GestorBBDD;
import model.Usuario;

/*@author Yolanda
 * 
 * Creamos la clase ServicioUsario para crear los metodos que unen  packages
 * data gestor BBDD con el package control.
 */

public class ServicioUsuario {
	
	public ServicioUsuario () {
		
		/*@utor Yolanda
		 * Creamos método insertaPelicula que muestra los datos insertarUsuario del GestorBBDD
		 */
	}
		public static void insertarUsuario (Usuario u) {
		    			
			GestorBBDD.insertarUsuario(u);
			
			
			
		}
	

}

