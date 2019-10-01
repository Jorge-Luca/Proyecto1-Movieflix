package com.david.practica3T.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.david.practica3T.modelo.CalificacionEnergetica;
import com.david.practica3T.modelo.Marca;
import com.david.practica3T.modelo.Modelo;

/**
 * Clase que controla la bbdd
 * @author david.avalos
 *
 */
public class GestorBBDD {
	private final static String DRIVER = "com.mysql.jdbc.Driver"; //ruta al driver
	private final static String BBDD="jdbc:mysql://localhost/bbdd_gestmotor";//direccion de la bbdd
	private final static String USER="dam2018";//usuario
	private final static String PASSWORD="dam2018";//contraseña de usuario
	private Connection conexion;
	ArrayList<Marca> marcas = new ArrayList();
	ArrayList<Modelo> modelos =new ArrayList();
	ArrayList<Modelo> modelosBorrar =new ArrayList();
	ArrayList<CalificacionEnergetica> cEnergeticas = new ArrayList();
	
	/**
	 * método cargar el driver
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public GestorBBDD() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		cargarConexion();
	}
	
	/**
	 * Accede a la bbdd
	 * @throws SQLException
	 */
	private void cargarConexion() throws SQLException {
		conexion = DriverManager.getConnection(BBDD, USER, PASSWORD);
	}
	
	/**
	 * Cierra la conexión con la bbdd
	 * @throws SQLException
	 */
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}
	
	/**
	 * Este método accede a la bbdd y devuelve las marcas
	 * @return ArrayList marcas
	 * @throws SQLException
	 */
	public ArrayList<Marca> obtenerMarcas() throws SQLException{
		Marca m;
		String sql="SELECT marca FROM marcas";
		Statement st = conexion.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			m=new Marca(
					rs.getString("marca"));
			marcas.add(m);
		}
		return marcas;
	}
	
	/**
	 * Este método accede a la bbdd y devuelve las clasificaciones energéticas
	 * @return ArrayList cEnergeticas
	 * @throws SQLException
	 */
	public ArrayList<CalificacionEnergetica> obtenercEnergeticas() throws SQLException{
		CalificacionEnergetica ce;
		String sql="SELECT c_energetica FROM eficiencias";
		Statement st = conexion.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			ce=new CalificacionEnergetica(
					rs.getString("c_energetica"));
			cEnergeticas.add(ce);
		}
		return cEnergeticas;
	}
	
	/**
	 * Método que inserta un coche en la bbdd
	 * @param marca
	 * @param modelo
	 * @param consumo
	 * @param emision
	 * @param cEner calificación energética
	 */
	public void insertarCoche(int marca,String modelo,int consumo,int emision,String cEner) {
		String sql="INSERT INTO modelos (id_marca,modelo,consumo,emisiones,c_energetica)VALUES(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setInt(1,marca);
			ps.setString(2,modelo);
			ps.setInt(3,consumo);
			ps.setInt(4,emision);
			ps.setString(5,cEner);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que devuelve la clasificacion energética seleccionada
	 * @param cEnerSel
	 * @return c_enerSel 
	 */
	public String cEnergetica(int cEnerSel){
		String c_EnerSel="";
		try {
			cEnergeticas=obtenercEnergeticas();
			c_EnerSel=cEnergeticas.get(cEnerSel).getC_energetica();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c_EnerSel;
	}
	
	/**
	 * Metodo que devuelve la marca
	 * @param id
	 * @return marca seleccionada
	 */
	public int marca(int id) {
		int marca=-3;
		try {
			marcas=obtenerMarcas();
			marca=marcas.get(id).getId();
			marca=marca+1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marca;
	}
	
	/**
	 * Metodo que obtiene los modelos
	 * @return arrayList de modelos
	 */
	public ArrayList<Modelo> obtenerModelos(){
		Modelo m;
		String sql="SELECT modelo,consumo,emisiones,c_energetica FROM modelos ORDER BY modelo";
		try {
			Statement st = conexion.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				m=new Modelo(
						rs.getString("modelo"),
						rs.getFloat("consumo"),
						rs.getFloat("emisiones"),
						rs.getString("c_energetica"));
				modelos.add(m);
			}
		}catch(SQLException e) {
			System.out.println("Error SQL!");
		}
		return modelos;
	}
}
	
