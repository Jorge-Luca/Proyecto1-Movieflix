package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

import model.Categoria;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


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
	
	public static void rellenaBBDD() {
		try {
			FileReader archivo=new FileReader("peliculas_cat.txt");
			int valor=archivo.read();
			
			
			while(valor!=-1) {
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*@author Yolanda
		 * 
		 * Método para añadir usuario en la BBDD
		 */
	public static void insertarUsuario ( Usuario u) {
		
		Connection con = estableceConexion ();
		PreparedStatement psInsertar = usuarios;
		String query=  "INSERT INTO"  usuarios (String nombreCompleto; Date fechaNacimiento; String ciudadResidencia;
		Set <Categoria> listaCategoria;
			
		 
		
				
		
	}
		
	}
}
