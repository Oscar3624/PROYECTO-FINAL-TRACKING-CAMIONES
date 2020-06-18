package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repository.IUsuario;
import ar.edu.unju.fi.tracking.model.Usuario;

@Repository
public class UsuarioServiceImp implements IUsuarioService{
	@Autowired
	private IUsuario iusuario;
	
	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		iusuario.guardar();
	}

	@Override
	public Usuario mostrar() {
		Usuario usuario= iusuario.mostrar();
		return usuario;
	}

	@Override
	public void eliminar() {
		iusuario.eliminar();
		
	}

	@Override
	public Usuario modificar() {
		Usuario usuario= iusuario.modificar();
		return usuario;
	}

}
