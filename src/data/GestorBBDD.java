package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import model.Categoria;
import model.Pelicula;
import model.Usuario;
import utilities.GenerarPeliculaUtility;

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
		String user = "root";
		String password = "password";

		try {
			con = DriverManager.getConnection(url, user, password);

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

	public static void rellenaBBDD() {
		BufferedReader archivo = null;
		try {
			archivo = new BufferedReader(new FileReader("peliculas_cat.txt"));
			String lineaActual = archivo.readLine();
			StringBuffer nombrePelicula = new StringBuffer();
			int agnoPelicula;
			StringBuffer categoriaPelicula = new StringBuffer();

			while (lineaActual != null) {
				for (int i = 0; i < lineaActual.length(); i++) {
					if (i != ',') {

					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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

}
