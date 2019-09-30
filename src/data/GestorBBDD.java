package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBBDD {
	/*@author Jorge
	 * 
	 * Clase encargada de interactuar con la base de datos
	 */
	public GestorBBDD() {
		
	}
	
	public static Connection estableceConexion() {
		
		Connection con = null;
		String url = "jdbc:mysql://80.65.12.133:3306/nombre_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
}
