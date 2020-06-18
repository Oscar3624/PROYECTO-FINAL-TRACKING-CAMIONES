package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;

public class Localidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	public Localidad() {
		// TODO Auto-generated constructor stub
	}

	public Localidad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + "]";
	}
	
	

}
