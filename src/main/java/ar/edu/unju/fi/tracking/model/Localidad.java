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
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name = "localidades")
public class Localidad implements Serializable {
	
	/*
	 * -------------
	 * ATRIBUTOS
	 * -----------
	 */
	
	
	/**
	 * CLAVE PRIMARIA DE LOCALIDAD
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	(name = "ID")
	private long id;

	/**
	 * NOMBRE DE UNA LOCALIDAD
	 * NO PUEDE ESTAR EN BLANCO
	 */
	
	@Column
	(name = "NOMBRE")
	@NotBlank(message="El nombre de localidad no puede quedar en blanco")
	private String nombre;

	// RELACION DE MAPEO
	//@OneToMany(cascade = CascadeType.ALL, 
		//	   fetch = FetchType.LAZY)	
	//private List<RegistroTracking> registro;

	/*
	 * ---------------
	 * CONSTRUCTORES
	 * ------------- 
	 */
	
	/**
	 * CONSTRUCTOR SIN  PARAMETROS
	 */
		
	public Localidad() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param nombre
	 */
	
	public Localidad(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	

	/**
	 * CONTRUCTOR PARAMETRIZADO
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

	/*
	 * ------------------
	 * METODOS ACCESORES
	 * ------------------
	 */	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * DEVUELVE EL NOMBRE DE UNA LOCALIDAD
	 * @return
	 */
	
	public String getNombre() {
		return nombre;
	}

	
	/**
	 * ASIGNA UN VALOR AL NOMBRE DE UNA LOCALIDAD
	 * @param nombre
	 */
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

	/**
	 * MUESTRA LOS ATRIBUTOS DE LOCALIDAD
	 */
	
	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + "]";
	}

}
