package services;

import java.util.ArrayList;

import data.GestorBBDD;
import model.Pelicula;
import model.Usuario;

/**
 * @author Iv�n
 * 
 * El siguiente m�todo se encarga de recibir el m�todo devuelveListaAccesibles() para 
 * almacenarlo en un array list y devolverlo para modularizar.
 */
public class ServicioListados {
	
	public static ArrayList<Pelicula>devuelveListaAccesibles(Usuario u) {
		ArrayList<Pelicula> aLDevolver = new ArrayList<Pelicula>();
		aLDevolver=GestorBBDD.devuelveListaAccesibles(u);
		return aLDevolver;
		
		/*@author Yolanda
		 * 
		 * El siguiente m�todo se encarga de recibir el m�todo devuelveListaAccesibles() para 
		 * almacenarlo en un array list y devolverlo para modularizar.
		 */
		public static ArrayList<Pelicula> devuelveListaCompletaPeliculas () {
			return GestorBBDD.devuelveListaCompletaPeliculas();
			
		
	}
}
}