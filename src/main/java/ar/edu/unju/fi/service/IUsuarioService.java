package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioService {
	public void guardar(Usuario usuario);
	public List<Usuario> obtenerUsuarios();
	public Usuario mostrar();
	public void eliminar(Long id);
	public Usuario modificar(Usuario usuario) throws Exception;
	public Usuario encontrarUsuario(Long id) throws Exception;
}


