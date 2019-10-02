package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Categoria;
import model.Pelicula;
import model.Usuario;
import utilities.Generar;

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
	

	public static void rellenaBBDD() {
		/*@author Jorge
		 * 
		 * 
		 */
		BufferedReader archivo=null;
		try {
			archivo=new BufferedReader(new FileReader("peliculas_cat.txt"));
			String lineaActual=archivo.readLine();
					
			while(lineaActual!=null) {
				
				try {
				String[] listaValores=lineaActual.split(",");
				Categoria cat=null;
				
				if (listaValores[2].replaceAll(" ","").equalsIgnoreCase(Categoria.ANIMACION.getNombre())) {
					cat=Categoria.ANIMACION;
				}
				else if(listaValores[2].replaceAll(" ","").equalsIgnoreCase(Categoria.AVENTURA.getNombre())) {
					cat=Categoria.AVENTURA;
				}
				else if(listaValores[2].replaceAll(" ","").equalsIgnoreCase(Categoria.COMEDIA.getNombre())) {
					cat=Categoria.COMEDIA;
				}
				else if(listaValores[2].replaceAll(" ","").equalsIgnoreCase(Categoria.POLICIACA.getNombre())) {
					cat=Categoria.POLICIACA;
				}
				else if(listaValores[2].replaceAll(" ","").equalsIgnoreCase(Categoria.ROMANTICA.getNombre())) {
					cat=Categoria.ROMANTICA;
				}
				else if(listaValores[2].replaceAll(" ","").equalsIgnoreCase(Categoria.THRILLER.getNombre())) {
					cat=Categoria.THRILLER;
				}else {}
				
				
				insertarPelicula(new Pelicula(listaValores[0],Integer.parseInt(listaValores[1].replaceAll(" ","")),cat));
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
	/**
	 * 
	 * @param u
	 * @author David
	 * El siguiente método devuelve las películas que puede ver un usuario.
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
                alAccesibles.add(Generar.generarPelicula(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alAccesibles;
    }

	/**
	 * 
	 * @author Iván Mantecón
	 * En el siguiente método se realiza la consulta de mostrar peliculas.
	 */
	public static ArrayList<Pelicula> devuelveListaCompletaPeliculas() {
		ArrayList<Pelicula> alPelicula = new ArrayList<Pelicula>();
		Connection con = estableceConexion();
		String query = "SELECT * FROM peliculas";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while (rs.next()) {
				Generar.generarPelicula(rs);
				alPelicula.add(Generar.generarPelicula(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alPelicula ;
	}
}


