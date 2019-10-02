package control;

import model.Usuario;
import services.ServicioListados;

/*@ Yolanda
 * Creo la clase Mostrar
 */


public class Mostrar {
	
	public void listaAccesibles(Usuario u) {
		System.out.println(ServicioListados.devuelveListaAccesibles(u));
	}
}
