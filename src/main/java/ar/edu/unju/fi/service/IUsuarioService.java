package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioService {
	public void guardar(Usuario usuario);
	public List<Usuario> obtenerUsuarios();
	public Usuario mostrar();
	public void eliminar();
	public Usuario modificar();
}