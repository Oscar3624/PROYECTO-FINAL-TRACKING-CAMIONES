package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;

public class Tripulante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String documento;
	private String apellido;
	private String nombres;
	private String nacionalidad;
	
	public Tripulante() {
		// TODO Auto-generated constructor stub
	}

	public Tripulante(String documento, String apellido, String nombres, String nacionalidad) {
		super();
		this.documento = documento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.nacionalidad = nacionalidad;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Tripulante [documento=" + documento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
	
}
