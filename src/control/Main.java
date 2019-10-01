package control;

import data.GestorBBDD;
import model.Categoria;
import model.Pelicula;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pelicula p = new Pelicula();
		p.setNombre("prueba");
		p.setAgnoEstreno(1234242);

		p.setAgnoEstreno(1122);
		p.setCategoria(Categoria.POLICIACA);
		
		System.out.println(p.toString() + p.getCategoria().getNombre());
		GestorBBDD.insertarPelicula(p);
		
	}
}
