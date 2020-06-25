package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IUsuarioDAO;
import ar.edu.unju.fi.tracking.model.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService{
	
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDAO.save(usuario);
	}

 	@Override
 
	public Usuario mostrar() {
		//Usuario usuario= usuarioDAO.mostrar();
		return null;
	}

	@Override
	public void eliminar() {
		//usuarioDAO.eliminar();
		
	}

	@Override
	public Usuario modificar() {
		//Usuario usuario= usuarioDAO.modificar();
		return null;
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		
		return usuarioDAO.findAll();
	}

}
