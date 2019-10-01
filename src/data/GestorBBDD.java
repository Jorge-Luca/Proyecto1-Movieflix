package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pelicula;

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
		String url = "jdbc:mysql://80.65.12.133:3306/proyecto1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
			
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
			ps.setInt(2, p.getAngnoEstreno());
			ps.setObject(3, p.getCategoria());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}