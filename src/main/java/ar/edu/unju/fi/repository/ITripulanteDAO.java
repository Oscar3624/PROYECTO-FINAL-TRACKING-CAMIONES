package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulanteDAO extends JpaRepository<Tripulante, Long>{
	
	public Optional<Tripulante> findByApellido(String apellido);
	
}
