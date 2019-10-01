package control;



import data.GestorBBDD;
import model.Categoria;
import model.Pelicula;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pelicula p = new Pelicula();
		p.setNombre("prueba");
		p.setAgnoEstreno(1122);
		p.setCategoria(Categoria.POLICIACA);
		
		System.out.println(p.toString() + p.getCategoria().getNombre());
		GestorBBDD.insertarPelicula(p);
		
		Usuario u= new Usuario ();
		u.setNombreCompleto("Maria del Carmen");
		u.setFechaNacimiento("18/12/2001");
		u.setCiudadResidencia("Barcelona");
		
		
		System.out.println(u.toString() + u.getNombreCompleto());
		GestorBBDD.insertarUsuario(u);
		
		
		
	}
		
		
		
	}
