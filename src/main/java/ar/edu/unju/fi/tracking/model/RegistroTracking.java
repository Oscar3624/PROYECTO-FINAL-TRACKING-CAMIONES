package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "registros")
public class RegistroTracking implements Serializable {

	/*
	 * -----------
	 * ATRIBUTOS
	 * ----------
	 */
	
	
	/**
	 * CLAVE PRIMARIA DE REGISTRO TRACKING
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	/**
	 * FECHA Y HORA EN QUE SE REALIZA EL REGISTRO
	 */
	@Column(name = "FECHA_HORA")
	private LocalDateTime fechaHora;
	
	/**
	 * VEHICULO QUE VA A REALIZAR EL REGISTRO.UN VEHICULO PUEDE TENER MUCHOS REGISTROS
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICULO_ID")
	private Vehiculo vehiculo;

	/**
	 * TRIPULANTES DEL VEHICULO QUE SE ESTA REGISTRANDO.LOS TRIPULANTES PUEDEN TENER MUCHOS REGSITROS
	 */
	//nombre de la tabla registros-tripulantes
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "registros_tripulantes", joinColumns = @JoinColumn(name = "registro_id"), inverseJoinColumns = @JoinColumn(name = "tripulante_id"))
	private List<Tripulante> tripulante;

	/**
	 * LOCALIDAD DONDE SE REALIZA EL REGISTRO.UNA LOCALIDAD PUEDE TENER VARIOS REGISTROS
	 */
	//foreign key o clave foranea  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCALIDAD_ID")
	private Localidad localidad;
	
	/**
	 * DETALLES SOBRE EL LUGAR DONDE SE REALIZA EL REGISTRO
	 */
	
	@Column(name = "DETALLE_LUGAR_REGISTRO")
	private String detalleLugarRegistro;

	
	/*
	 * --------------
	 * CONSTRUCTORES
	 * --------------
	 */
	
	
	
	/**
	 * CONTRUCTOR POR DEFECTO
	 */
	public RegistroTracking() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param id
	 * @param fechaHora
	 * @param vehiculo
	 * @param tripulante
	 * @param localidad
	 * @param detalleLugarRegistro
	 * 
	 *
	 */
	public RegistroTracking(long id, LocalDateTime fechaHora, Vehiculo vehiculo, List<Tripulante> tripulante,
			Localidad localidad, String detalleLugarRegistro) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.vehiculo = vehiculo;
		this.tripulante = tripulante;
		this.localidad = localidad;
		this.detalleLugarRegistro = detalleLugarRegistro;
	}


	/*
	 * ----------------
	 * METODOS ACCESORES
	 * ----------------
	 */
	
	/**
	 * DEVEUELVE EL ID DE UN REGISTRO
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * ASIGNA UN ID A UN REGISTRO
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * DEVUELVE LA FECHA Y HORA DE UN REGISTRO
	 * @return
	 */

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	/**
	 * ASIGNA UNA FECHA Y HORA DE REGISTRO
	 * @param fechaHora
	 */

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	/**
	 * DEVUELVE UN OBJETO DE TIPO VEHICULO
	 * @return
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	/**
	 * ASIGNA UN OBJETO VEHICULO A VEHICULO
	 * @param vehiculo
	 */
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * DEVEUELVE UNA LISTA DE TIPO TRIPULANTES
	 * @return
	 */
	public List<Tripulante> getTripulante() {
		return tripulante;
	}
	
	/*
	 * ASIGNA UN OBJETTO DE TIPO TRIPULANTE A LA LISTA DE TIPO TRIPULANTE
	 */
	public void setTripulante(List<Tripulante> tripulante) {
		this.tripulante = tripulante;
	}
	
	/**
	 * DEVEULEVE UNA LOCALIDAD
	 * @return
	 */
	public Localidad getLocalidad() {
		return localidad;
	}

	/**
	 * ASIGNA UNA LOCALIDAD
	 * @param localidad
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	
	/**
	 * DEVUELVE UNA DESCRIPIION DEL LUGAR DEL REGISTRO
	 * @return
	 */
	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	
	/**
	 * ASIGNA UNA DESCRIPCION DEL LIGAR DEL REGISTRO
	 * @param detalleLugarRegistro
	 */
	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	/**
	 * MUESTRA LOS ATRIBUTOS DEL OBJETO REGISTROTRACKING
	 */
	@Override
	public String toString() {
		return "RegistroTracking [fechaHora=" + fechaHora + ", vehiculo=" + vehiculo + ", localidad=" + localidad
				+ ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
	}

}
