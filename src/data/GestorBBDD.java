package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
<<<<<<< HEAD
<<<<<<< HEAD
import model.Pelicula;
=======
=======
import java.io.BufferedReader;
>>>>>>> 5b5984cd4b3b885f05e04974cc9a6cc83af369b4
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

>>>>>>> b093385f1ce913df746c9da8b867b972ab316c5d

public class GestorBBDD {
	/*@author Jorge
	 * 
	 * Clase encargada de interactuar con la base de datos
	 */
	public GestorBBDD() {
		
	}
	
	public static Connection estableceConexion() {
		/*@author Jorge
		 * 
		 * Método diseñado para devolver una conexion abierta con la BBDD
		 */
		Connection con = null;
		String url = "jdbc:mysql://10.90.36.112:3306/proyecto1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
	
<<<<<<< HEAD
<<<<<<< HEAD
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
			ps.setInt(2, p.getAngnoEstreno());
			ps.setObject(3, p.getCategoria());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
=======
=======
	public static void cierraConexion(Connection con) {
		/*@author Jorge
		 * 
		 * Este método cierra una conexión abierta existente
		 */
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
>>>>>>> 5b5984cd4b3b885f05e04974cc9a6cc83af369b4
	public static void rellenaBBDD() {
		BufferedReader archivo=null;
		try {
			archivo=new BufferedReader(new FileReader("peliculas_cat.txt"));
			String lineaActual=archivo.readLine();
			StringBuffer nombrePelicula=new StringBuffer();
			int agnoPelicula;
			StringBuffer categoriaPelicula=new StringBuffer();
					
			while(lineaActual!=null) {
				String[] listaValores=lineaActual.split(",");
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
>>>>>>> b093385f1ce913df746c9da8b867b972ab316c5d
