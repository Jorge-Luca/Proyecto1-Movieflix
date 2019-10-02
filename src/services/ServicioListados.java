package services;

import java.util.ArrayList;

import data.GestorBBDD;
import model.Pelicula;
import model.Usuario;

/**
 * @author Iván
 * 
 * El siguiente método se encarga de recibir el método devuelveListaAccesibles() para 
 * almacenarlo en un array list y devolverlo para modularizar.
 */
public class ServicioListados {
	
	public static ArrayList<Pelicula>devuelveListaAccesibles(Usuario u) {
		ArrayList<Pelicula> aLDevolver = new ArrayList<Pelicula>();
		aLDevolver=GestorBBDD.devuelveListaAccesibles(u);
		return aLDevolver;
		
		/*@author Yolanda
		 * 
		 * El siguiente método se encarga de recibir el método devuelveListaAccesibles() para 
		 * almacenarlo en un array list y devolverlo para modularizar.
		 */
		public static ArrayList<Pelicula> devuelveListaCompletaPeliculas () {
			return GestorBBDD.devuelveListaCompletaPeliculas();
			
		
	}
}
}