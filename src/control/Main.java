package control;

import java.util.HashSet;
import java.util.Set;

import data.GestorBBDD;
import model.Categoria;
import model.Pelicula;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		/*Pelicula p = new Pelicula();
		p.setNombre("prueba");
		p.setAngnoEstreno(1122);
		p.setCategoria(Categoria.POLICIACA);*/
		
		//Set<Categoria> listaCategoria =(Categoria.ANIMACION,Categoria.AVENTURA,Categoria.COMEDIA,Categoria.POLICIACA,Categoria.ROMANTICA,Categoria.THRILLER);
		
		Set<Categoria> categorias = new HashSet<Categoria>();
		categorias.add(Categoria.ANIMACION);
		categorias.add(Categoria.AVENTURA);
		categorias.add(Categoria.COMEDIA);
		categorias.add(Categoria.POLICIACA);
		categorias.add(Categoria.ROMANTICA);
		categorias.add(Categoria.THRILLER);
		
		//System.out.println(p.toString() + p.getCategoria().getNombre());
		Usuario u = new Usuario("David", "07/02/1998", "Fuenlabrada",categorias);	
		GestorBBDD.devuelveListaAccesibles(u);
=======
		
		
		Usuario u= new Usuario ();
		u.setNombreCompleto("Maria del Carmen");
		u.setFechaNacimiento("18/12/2001");
		u.setCiudadResidencia("Barcelona");
		
		
		System.out.println(u.toString() + u.getNombreCompleto());
		GestorBBDD.
		
		
		
	}
		
		
>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff
		
	}
