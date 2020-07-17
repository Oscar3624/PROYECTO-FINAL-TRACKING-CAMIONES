package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	
	/*
	 * ---------------
	 * ATRIBUTOS
	 * --------------
	 */
	
	/**
	 *CLAVE PRIMARIA DEL USUARIO 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	/**
	 * NOMBRE DE USUARIO.NO PUEDE ESTAR EN BLANCO.
	 */
	@Column
	(name = "NOMBRE_USUARIO")
	@NotBlank(message="El nombre de usuario no puede quedar en blanco")
	private String nombreUsuario;
	
	/**
	 * PASSWORD DE USUARIO, NO PUEDE ESTAR EN BLANCO Y TIENE QUE SER MAYOR A 8 CARACTERES.
	 */
	@Column(name = "PASSWORD")
	@NotBlank
	@Size(min=8, message="Su contraseña debe tener como mínimo 8 caracteres")
	private String password;
	
	/**
	 * NOMBRE REAL DEL USUARIO,NO PUEDE ESTAR EN BLANCO
	 */
	@Column(name = "NOMBRE")
	@NotBlank(message="El nombre Real no puede quedar en blanco")
	private String nombreReal;
	
	/**
	 * APELLIDO REAL DEL USUARIO,NO PUEDE ESTAR EN BLANCO
	 */
	@Column(name = "APELLIDO")
	@NotBlank(message="El Apellido real no puede quedar en blanco")
	private String apellidoReal;
	
	/**
	 * ROL DEL USUARIO. PUEDE SER: CONSULTOR, REGISTRADOR,BD.
	 */
	@Column(name = "TIPO")
	@NotBlank(message="El tipo no puede quedar en blanco")
	private String tipoUsuario;//consultor, registrador, bd
	
	/*
	 * --------------
	 * CONSTRUCTORES
	 * --------------
	 */
	
	/**
	 *CONSTRUCTOR SIN PARAMETROS 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param nombreUsuario
	 * @param password
	 * @param nombreReal
	 * @param apellidoReal
	 * @param tipoUsuario
	 */
	public Usuario( @NotBlank String nombreUsuario,  String password,  String nombreReal,  String apellidoReal, String tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreReal = nombreReal;
		this.apellidoReal = apellidoReal;
		this.tipoUsuario = tipoUsuario;
	}

	
	
	/*
	 * METODOS ACCESORES
	 */
	
	/**
	 * DEVEUELVE EL ID DEUN USUARIO
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * ASIGNA UN ID A UN USUARIO
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * DEVUELVE EL NOMBRE DE USUARIO
	 * @return
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * ASIGNA UN NOMBRE DE USUARIO
	 * @param nombreUsuario
	 */

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * DEVUELVE EL PASSWORD DE UN USUARIO
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ASIGNA EL PASSWORD A UN USUARIO
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * DEVEULEVE EL NOMBRE REAL DEL USUARIO
	 * @return
	 */

	public String getNombreReal() {
		return nombreReal;
	}

	/**
	 * ASIGNA EL NOMBRE REAL DE UN USUARIO
	 * @param nombreReal
	 */
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	
	/**
	 * DEVUELVE EL APELLIDO REAL DE UN USUARIO
	 * @return
	 */
	public String getApellidoReal() {
		return apellidoReal;
	}
	
	/**
	 * ASIGNA EL APELLIDO REAL DE UN USUARIO
	 * @param apellidoReal
	 */

	public void setApellidoReal(String apellidoReal) {
		this.apellidoReal = apellidoReal;
	}

	/**
	 * DEVUELVE EL ROL DEL USUARIO
	 * @return
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * ASIGNA EL ROL DE UN USUARIO
	 * @param tipoUsuario
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	
	/**
	 * MUESTRA LOS ATRIBUTOS DEL OBJETO USUARIO
	 */
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal=" + nombreReal
				+ ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
}
