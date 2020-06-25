package ar.edu.unju.fi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	
	
	
}
