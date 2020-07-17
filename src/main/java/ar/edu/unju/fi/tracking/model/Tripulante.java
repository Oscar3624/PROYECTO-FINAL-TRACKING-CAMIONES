package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name = "tripulantes")
public class Tripulante implements Serializable {
	
	/*
	 * ----------------
	 * ATRIBUTOS
	 * ----------------
	 */
		
	
	/**
	 * CALVE PRIMARIA DE TRIPULANTE
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	/**
	 * DNI DEL TRIPULANTE
	 */
	@Column(name = "DOCUMENTO")
	private String documento;
	
	/**
	 * APELLIDO DEL TRIPULANTE
	 */
	@Column(name = "APELLIDO")
	private String apellido;
	
	/**
	 * NOMBRE DEL TRIPULANTE
	 */
	@Column(name = "NOMBRE")
	private String nombres;
	
	/**
	 * NACIONALIDAD DEL TRIPULANTE
	 */
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;

	// RELACION DE MAPEO	
	
	//@ManyToMany(mappedBy = "tripulante", fetch = FetchType.LAZY)
	//private List<RegistroTracking> registro;

	/*
	 * -------------
	 * CONSTRUCTORES
	 * -------------
	 */
	
	
	/**
	 * CONSTRUCTOR SIN PARAMETROS
	 */
	public Tripulante() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param documento
	 * @param apellido
	 * @param nombres
	 * @param nacionalidad
	 */
	public Tripulante(String documento, String apellido, String nombres, String nacionalidad) {
		super();
		this.documento = documento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.nacionalidad = nacionalidad;
	}

	/*
	 * -----------------
	 * METODOS ACCESORES
	 * -----------------
	 */
	
	/**
	 * DEVUELVE EL ID DE TRIPULANTE
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * ASIGNA VALOR AL ID DE TRIPULANTE
	 * @param id
	 */

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * DEVEULVE EL DOCUMENTO DEL TRIPULANTE
	 * @return
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * ASIGNA UN VALOR A DOCUMENTO
	 * @param documento
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * DEVEULVE EL APELLIDO DEL TRIPULANTE
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * ASIGNA UN VALOR AL APELLIDO DEL TRIPULANTE
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * DEVUELV EL NOMBRE DEL TRIPULANTE
	 * @return
	 */
	public String getNombres() {
		return nombres;
	}

	
	/**
	 * ASIGNA UN VALOR AL NOMBRE DEL TRIPULANTE
	 * @param nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * DEVUELVE LA NACIONALIDAD DEL TRIPULANTE
	 * @return
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * ASIGNA IN VALOR ALA NACIONALIDAD DEL TRIPULANTE
	 * @param nacionalidad
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * MUESTRA LOS ATRIBUTOS DE TRIPULANTE
	 */
	@Override
	public String toString() {
		return "Tripulante [documento=" + documento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", nacionalidad=" + nacionalidad + "]";
	}

}
