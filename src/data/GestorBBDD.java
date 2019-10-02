package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Set;
=======
>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff

import model.Categoria;
import model.Pelicula;
import model.Usuario;
<<<<<<< HEAD
import utilities.GenerarPeliculaUtility;
=======
>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestorBBDD {
	/*
	 * @author Jorge
	 * 
	 * Clase encargada de interactuar con la base de datos
	 */
	public GestorBBDD() {

	}

	public static Connection estableceConexion() {
		/*
		 * @author Jorge
		 * 
		 * Método diseñado para devolver una conexion abierta con la BBDD
		 */
		Connection con = null;
		String url = "jdbc:mysql://10.90.36.112:3306/proyecto1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
<<<<<<< HEAD
		String user = "root";
		String password = "password";

		try {
			con = DriverManager.getConnection(url, user, password);

=======
        String user = "root";
        String password = "password";
			
        try { 
            con = DriverManager.getConnection(url, user, password);
            
        }catch(SQLException e) {
        	e.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return con;
	}
	

	/*Con este método añadimos películas, estableciendo antes la conexion a BBDD.*/
	public static void insertarPelicula(Pelicula p) {
		/*
		 * @author Iván Mantecón
		 * */
		Connection con=estableceConexion();
		PreparedStatement ps;
		String query = "INSERT INTO peliculas (nombre, agnoEstreno, categoria) VALUE (?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getAgnoEstreno());
			ps.setString(3, p.getCategoria().getNombre());
			ps.executeUpdate();
>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}


	public static void cierraConexion(Connection con) {
		/*
		 * @author Jorge
		 * 
		 * Este método cierra una conexión abierta existente
		 */
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
=======
	/*
	 * @author Yolanda Gutiérrez
	 * Creamos un método para insertar usuarios conectado con BBDD.
	 * */
	public static void insertarUsuario(Usuario u) {
        Connection con = estableceConexion();
        PreparedStatement ps;
        String query = "INSERT INTO usuarios (nombreCompleto, fechaNacimiento, ciudadResidencia) VALUE (?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, u.getNombreCompleto());
            ps.setString(2, u.getFechaNacimiento());
            ps.setString(3, u.getCiudadResidencia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
	
>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff

	public static void rellenaBBDD() {
		BufferedReader archivo = null;
		try {
<<<<<<< HEAD
			archivo = new BufferedReader(new FileReader("peliculas_cat.txt"));
			String lineaActual = archivo.readLine();
			StringBuffer nombrePelicula = new StringBuffer();
			int agnoPelicula;
			StringBuffer categoriaPelicula = new StringBuffer();

			while (lineaActual != null) {
				for (int i = 0; i < lineaActual.length(); i++) {
					if (i != ',') {

					}
=======
			archivo=new BufferedReader(new FileReader("peliculas_cat.txt"));
			String lineaActual=archivo.readLine();
					
			while(lineaActual!=null) {
				
				try {
				String[] listaValores=lineaActual.split(",");
				Categoria cat=null;
				
				if (listaValores[2].equalsIgnoreCase(Categoria.ANIMACION.getNombre())) {
					cat=Categoria.ANIMACION;
				}
				else if(listaValores[2].equalsIgnoreCase(Categoria.AVENTURA.getNombre())) {
					cat=Categoria.AVENTURA;
				}
				else if(listaValores[2].equalsIgnoreCase(Categoria.COMEDIA.getNombre())) {
					cat=Categoria.COMEDIA;
				}
				else if(listaValores[2].equalsIgnoreCase(Categoria.POLICIACA.getNombre())) {
					cat=Categoria.POLICIACA;
				}
				else if(listaValores[2].equalsIgnoreCase(Categoria.ROMANTICA.getNombre())) {
					cat=Categoria.ROMANTICA;
				}
				else if(listaValores[2].equalsIgnoreCase(Categoria.THRILLER.getNombre())) {
					cat=Categoria.THRILLER;
				}else {}
				
				
				insertarPelicula(new Pelicula(listaValores[0],Integer.parseInt(listaValores[1]),cat));
				lineaActual=archivo.readLine();
				
				}catch(Exception e) {
					e.printStackTrace();
					lineaActual=archivo.readLine();
>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
<<<<<<< HEAD
		}

	}

	/**
	 * 
	 * @param u Usuario
	 * @return ArrayList con las peliculas accesibles por el usuario
	 */
	public static ArrayList<Pelicula> devuelveListaAccesibles(Usuario u) {
		ArrayList<Pelicula> alAccesibles = new ArrayList();
		Pelicula p=null;
		
		PreparedStatement ps;
		Connection c = estableceConexion();
		
		StringBuilder where=new StringBuilder();
=======
		}		
>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff
		
		for (Categoria cat:u.getListaCategoria()) {
			where.append("'"+cat.getNombre()+"'"+",");
		}
		where.replace(where.length()-1, where.length(), "");
		String sql = "SELECT nombre,agnoEstreno,categoria FROM peliculas WHERE categoria IN ("+where+ ");";
		System.out.println(sql);
		try {
			ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				alAccesibles.add(GenerarPeliculaUtility.generarPelicula(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alAccesibles;
	}

<<<<<<< HEAD
}
=======

>>>>>>> 3bf30ce558a2378f6e395f6b65e9fbbdd8606bff
