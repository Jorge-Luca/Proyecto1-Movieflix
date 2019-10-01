package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Categoria;
import model.Pelicula;
import java.io.BufferedReader;
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


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
	

	public static void rellenaBBDD() {
		BufferedReader archivo=null;
		try {
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
				}
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	
}

