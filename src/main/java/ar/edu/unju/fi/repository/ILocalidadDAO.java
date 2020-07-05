package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tracking.model.Localidad;

public interface ILocalidadDAO extends JpaRepository<Localidad, Long>{
	
	
	
}
