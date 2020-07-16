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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column
	(name = "NOMBRE_USUARIO")
	@NotBlank(message="El nombre de usuario no puede quedar en blanco")
	private String nombreUsuario;
	
	@Column(name = "PASSWORD")
	@NotBlank
	@Size(min=8, message="Su contraseña debe tener como mínimo 8 caracteres")
	private String password;
	
	@Column(name = "NOMBRE")
	@NotBlank(message="El nombre Real no puede quedar en blanco")
	private String nombreReal;
	
	@Column(name = "APELLIDO")
	@NotBlank(message="El Apellido real no puede quedar en blanco")
	private String apellidoReal;
	
	
	@Column(name = "TIPO")
	@NotBlank(message="El tipo no puede quedar en blanco")
	private String tipoUsuario;//consultor, registrador, bd
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario( @NotBlank String nombreUsuario,  String password,  String nombreReal,  String apellidoReal, String tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreReal = nombreReal;
		this.apellidoReal = apellidoReal;
		this.tipoUsuario = tipoUsuario;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getApellidoReal() {
		return apellidoReal;
	}

	public void setApellidoReal(String apellidoReal) {
		this.apellidoReal = apellidoReal;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal=" + nombreReal
				+ ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
}
