package services;

import java.util.ArrayList;

import data.GestorBBDD;
import model.Pelicula;
import model.Usuario;

/*@author Yolanda
 * 
 * Creamos la clase ServicioListados para crear los metodos que unen  packages
 * data gestor BBDD con el package control.
 */

/**
 * @author Iv�n
 * 
 * El siguiente m�todo se encarga de recibir el m�todo devuelveListaAccesibles() para 
 * almacenarlo en un array list y devolverlo para modularizar.
 */
public class ServicioListados {
	
	public static ArrayList<Pelicula> devuelveListaAccesibles(Usuario u) {
		return GestorBBDD.devuelveListaAccesibles(u);
	}

}
