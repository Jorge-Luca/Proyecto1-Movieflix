package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.Date;
import java.util.Set;
import model.Categoria;
import model.Pelicula;
import model.Usuario;

=======
import model.Pelicula;
>>>>>>> f5288051764dc0bad749f013cbb66d3aaa64dfa5
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GestorBBDD {
<<<<<<< HEAD
	private static String nombreCompleto;

=======
>>>>>>> f5288051764dc0bad749f013cbb66d3aaa64dfa5
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
		 * M�todo dise�ado para devolver una conexion abierta con la BBDD
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

	/*
<<<<<<< HEAD
	 * Con este m�todo a�adimos pel�culas, estableciendo antes la conexion a BBDD.
=======
	 * Con el siguiente m�todo a�adimos pel�culas, estableciendo antes la conexi�n a BBDD.
>>>>>>> f5288051764dc0bad749f013cbb66d3aaa64dfa5
	 */
	public static void insertarPelicula(Pelicula p) {
		/*
		 * @author Iv�n Mantec�n
		 */
		Connection con = estableceConexion();
		PreparedStatement ps;
		String query = "INSERT INTO peliculas (nombre, agnoEstreno, categoria) VALUE (?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getAgnoEstreno());
			ps.setString(3, p.getCategoria().getNombre());
			ps.setInt(2, p.getAgnoEstreno());
			ps.setString(3, p.getCategoria().getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void cierraConexion(Connection con) {
		/*
		 * @author Jorge
		 * 
		 * Este m�todo cierra una conexi�n abierta existente
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
	
>>>>>>> f5288051764dc0bad749f013cbb66d3aaa64dfa5
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
			StringBuffer categoriaPelicula=new StringBuffer();
					
			while(lineaActual!=null) {
				String[] listaValores=lineaActual.split(",");

				insertarPelicula(new Pelicula(listaValores[0],lista));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
	}

	/*
	 * @author Yolanda
	 * 
	 * M�todo para a�adir usuario en la BBDD
	 */
	public static void insertarUsuario(Usuario u) {
		
		Connection con = estableceConexion ();
		PreparedStatement ps;
		
		String query = "INSERT INTO usuarios (nombreCompleto, fechaNacimiento, ciudadResidencia) VALUE (?,?,?)";
		try {
			 
			ps = con.prepareStatement(query);
			ps.setString(1, u.getNombreCompleto());
			ps.setDate(2, (java.sql.Date) u.getFechaNacimiento());
			ps.setString(3,u.getCiudadResidencia());
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	}
	
				
	
	
	



=======

	}
}
>>>>>>> f5288051764dc0bad749f013cbb66d3aaa64dfa5

