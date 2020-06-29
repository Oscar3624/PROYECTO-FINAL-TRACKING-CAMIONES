package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulanteDAO extends JpaRepository<Tripulante, Long>{
	
	@Query("from Tripulante T order by T.id")
	public List<Tripulante> obtenerTripulante();
	
}
