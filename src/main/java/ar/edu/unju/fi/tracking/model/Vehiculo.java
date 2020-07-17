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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="vehiculos")
public class Vehiculo implements Serializable{
	
	/*
	 * ---------------------
	 * ATRIBUTOS
	 * --------------------
	 */
	
	/**
	 * CALVE PRIMARIA DE VEHICULOS
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	/**
	 * PATENTE DE IDENTIFICACION DEL VEHICULO
	 */
	@Column(name = "PATENTE")
	private String patente;
	/**
	 * COLOR DEL VEHICULO
	 */
	@Column(name = "COLOR")
	private String color;
	/**
	 * TITULAR DEL VEHICULO
	 */
	@Column(name = "TITULAR")
	private String titular;
	/**
	 * MARCA DEL VEHICULO
	 */
	@Column(name = "MARCA")
	private String marca;
	/**
	 * MODELO DEL VEHICULO
	 */
	@Column(name = "MODELO")
	private String modelo;
	/**
	 * TIPO DE VEHICULO:AUTO,CAMION.CAMIONETA
	 */
	@Column(name = "TIPO")
	private String tipo;
	/**
	 * NUMERO DE CAHSIS DEL VEHICULO
	 */
	@Column(name = "NUMERO_CHASIS")
	private String numeroChasis;
	/**
	 * NUMERO DE MOTOR DEL VEHICULO
	 */
	@Column(name = "NUMERO_MOTOR")
	private String numeroMotor;
	
	// RELACION DE MAPEO
	
	//@OneToMany(cascade = CascadeType.ALL, 
		//	   fetch = FetchType.EAGER)	
	//private List<RegistroTracking> registro;
	 
	/*----------------
	 * CONSTRUCTORES
	 * -------------
	 */
	
	/**
	 *CONSTRUCTORES SIN PARAMETRIZAR 	
	 */
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param patente
	 * @param color
	 * @param titular
	 * @param marca
	 * @param modelo
	 * @param tipo
	 * @param numeroChasis
	 * @param numeroMotor
	 */
	public Vehiculo(String patente, String color, String titular, String marca, String modelo, String tipo,
			String numeroChasis, String numeroMotor) {
		super();
		this.patente = patente;
		this.color = color;
		this.titular = titular;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.numeroChasis = numeroChasis;
		this.numeroMotor = numeroMotor;
	}
	
	/*
	 * -----------------
	 * METODOS ACCESORES
	 * -----------------
	 */
	
	/**
	 * DEVEUELVE EL ID DE VEHICULO
	 * @return
	 */
	public long getId() {
		return id;
	}
	/**
	 * ASIGNA UN VALOR DE ID DE VEHICULO
	 * @param id
	 */

	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * DEVUELVE LA PATENTE DEL VEHICULO
	 * @return
	 */
	public String getPatente() {
		return patente;
	}
	
	/**
	 * ASIGNA UNA PATENTE AL VEHICULO
	 * @param patente
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	/**
	 * DEVEUELVE EL COLOR DEL VEHICULO
	 * @return
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * ASIGNA UN COLOR DE VEHICULO
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	
	/**public List<RegistroTracking> getRegistro() {
		return registro;
	}

	
	public void setRegistro(List<RegistroTracking> registro) {
		this.registro = registro;
	}**/

	/**
	 * DEVEULVE UN NOMBRE DEL TITULAR DEL VEHICULO
	 * @return
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * ASIGNA UN NOMBRE DE TITULAR DEL VEHICULO
	 * @param titular
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	/**
	 * DEVEULVE LA MARCA DEL VEHICULO
	 * @return
	 */

	public String getMarca() {
		return marca;
	}
	
	/**
	 * ASIGNA LA MARCA DEL VEHICULO
	 */

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * DEVUELVE EL MODELO DE UN VEHICULO
	 * @return
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * ASIGNA EL MODELO DE UN VEHICULO
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * DEVUELVE EL TIPO DE VEHICULO
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * ASIGNA EL TIPO DE VEHICULO
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * DEVUELVE EL NUMERO DE CHASIS
	 * @return
	 */
	public String getNumeroChasis() {
		return numeroChasis;
	}
	
	/**
	 *  ASIGNA EL NUMERO DE CHASIS
	 * @param numeroChasis
	 */
	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}
	
	/**
	 * DEVEUELVE EL NUMERO DE MOTOR DEL VEHICULO
	 * @return
	 */
	public String getNumeroMotor() {
		return numeroMotor;
	}
	
	/**
	 * ASIGNA EL NUMERO DE MOTOR DEL VEHICULO
	 * @param numeroMotor
	 */
	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	
	/**
	 * MUESTRA LOS ATRIBUTOS DE VEHICULO
	 */
	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", color=" + color + ", titular=" + titular + ", marca=" + marca
				+ ", modelo=" + modelo + ", tipo=" + tipo + ", numeroChasis=" + numeroChasis + ", numeroMotor="
				+ numeroMotor + "]";
	}
	
	
}
