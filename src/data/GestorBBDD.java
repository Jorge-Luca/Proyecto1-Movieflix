package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
<<<<<<< HEAD

=======
>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
import model.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

<<<<<<< HEAD
=======

>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
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
<<<<<<< HEAD

	/*
	 * Con este método añadimos películas, estableciendo antes la conexion a BBDD.
	 */
=======
	

	/*Con este método añadimos películas, estableciendo antes la conexion a BBDD.*/
>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
	public static void insertarPelicula(Pelicula p) {
		/*
		 * @author Iván Mantecón
		 */
		Connection con = estableceConexion();
		PreparedStatement ps;
		String query = "INSERT INTO peliculas (nombre, agnoEstreno, categoria) VALUE (?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, p.getNombre());
<<<<<<< HEAD
			ps.setInt(2, p.getAngnoEstreno());
			ps.setString(3, p.getCategoria().getNombre());
=======
			ps.setInt(2, p.getAgnoEstreno());
			ps.setObject(3, p.getCategoria());
>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


<<<<<<< HEAD

=======
>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
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
	
>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29

	public static void rellenaBBDD() {
		BufferedReader archivo = null;
		try {
			archivo = new BufferedReader(new FileReader("peliculas_cat.txt"));
			String lineaActual = archivo.readLine();
			StringBuffer nombrePelicula = new StringBuffer();
			int agnoPelicula;
<<<<<<< HEAD
			StringBuffer categoriaPelicula = new StringBuffer();

			while (lineaActual != null) {
				for (int i = 0; i < lineaActual.length(); i++) {
					if (i != ',') {

					}
				}
=======
			StringBuffer categoriaPelicula=new StringBuffer();
					
			while(lineaActual!=null) {
				String[] listaValores=lineaActual.split(",");
				
<<<<<<< HEAD
>>>>>>> fb5728c169b70ca4a9d14617c7f3be887e07f3a8
=======
				insertarPelicula(new Pelicula(listaValores[0],lista));
>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
<<<<<<< HEAD
=======

>>>>>>> 7eee7a3bd8060a4f4e5cf38b25175daac10e7d29
