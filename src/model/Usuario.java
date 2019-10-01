package model;

import java.util.Date;
import java.util.Set;

public class Usuario {
	private String nombreCompleto;
	private Date fechaNacimiento;
	private String ciudadResidencia;
	private Set <Categoria> listaCategoria;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombreCompleto, Date fechaNacimiento, String ciudadResidencia,
			Set<Categoria> listaCategoria) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadResidencia = ciudadResidencia;
		this.listaCategoria = listaCategoria;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public Set<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(Set<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
	
}
