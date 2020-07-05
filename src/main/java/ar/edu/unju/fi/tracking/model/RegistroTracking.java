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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "FECHA_HORA")
	private LocalDateTime fechaHora;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICULO_ID")
	private Vehiculo vehiculo;

	//nombre de la tabla registros-tripulantes
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "registros_tripulantes", joinColumns = @JoinColumn(name = "registro_id"), inverseJoinColumns = @JoinColumn(name = "tripulante_id"))
	private List<Tripulante> tripulante;

	//foreign key o clave foranea  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCALIDAD_ID")
	private Localidad localidad;

	@Column(name = "DETALLE_LUGAR_REGISTRO")
	private String detalleLugarRegistro;

	public RegistroTracking() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * public RegistroTracking(LocalDateTime fechaHora, Vehiculo vehiculo,
	 * List<Tripulante> tripulantes, Localidad localidad, String
	 * detalleLugarRegistro) { super(); this.fechaHora = fechaHora; this.vehiculo =
	 * vehiculo; this.tripulantes = tripulantes; this.localidad = localidad;
	 * this.detalleLugarRegistro = detalleLugarRegistro; }
	 */

	public RegistroTracking(long id, LocalDateTime fechaHora, Vehiculo vehiculo, Localidad localidad,
			String detalleLugarRegistro) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.vehiculo = vehiculo;
		// this.tripulante = tripulante;
		this.localidad = localidad;
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Tripulante> getTripulante() {
		return tripulante;
	}

	public void setTripulante(List<Tripulante> tripulante) {
		this.tripulante = tripulante;
	}

	/**
	 * public List<Tripulante> getTripulantes() { return tripulantes; }
	 * 
	 * public void setTripulantes(List<Tripulante> tripulantes) { this.tripulantes =
	 * tripulantes; }
	 **/

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	@Override
	public String toString() {
		return "RegistroTracking [fechaHora=" + fechaHora + ", vehiculo=" + vehiculo + ", localidad=" + localidad
				+ ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
	}

}
