package control;

import data.GestorBBDD;
import model.Categoria;
import model.Pelicula;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pelicula p = new Pelicula();
		p.setNombre("prueba");
<<<<<<< HEAD
		p.setAgnoEstreno(1129992);
=======
		p.setAgnoEstreno(1122);
>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
		p.setCategoria(Categoria.POLICIACA);
		
		System.out.println(p.toString() + p.getCategoria().getNombre());
		GestorBBDD.insertarPelicula(p);
		
	}
}
