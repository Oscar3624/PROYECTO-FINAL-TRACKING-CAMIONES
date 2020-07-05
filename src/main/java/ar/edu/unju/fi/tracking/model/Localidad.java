package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name = "localidades")
public class Localidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "NOMBRE")
	private String nombre;

	// RELACION DE MAPEO
	//@OneToMany(cascade = CascadeType.ALL, 
		//	   fetch = FetchType.LAZY)	
	//private List<RegistroTracking> registro;

	public Localidad() {
		// TODO Auto-generated constructor stub
	}

	public Localidad(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	

	/**
	 * @param id
	 * @param nombre
	 * @param registro
	 */
	public Localidad(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		//this.registro = registro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	/**
	public List<RegistroTracking> getRegistro() {
		return registro;
	}

	
	public void setRegistro(List<RegistroTracking> registro) {
		this.registro = registro;
	}*/

	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + "]";
	}

}
