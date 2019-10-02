package model;

import java.util.Set;

public class Usuario {
	private String nombreCompleto;
	private String  fechaNacimiento;
	private String ciudadResidencia;
	private Set <Categoria> listaCategoria;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombreCompleto, String fechaNacimiento, String ciudadResidencia,
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
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
	
	public void asignarCategoria() {
		listaCategoria.add(Categoria.ANIMACION);
		listaCategoria.add(Categoria.AVENTURA);
		listaCategoria.add(Categoria.COMEDIA);
		listaCategoria.add(Categoria.POLICIACA);
		listaCategoria.add(Categoria.ROMANTICA);
		listaCategoria.add(Categoria.THRILLER);
	}
	
}
