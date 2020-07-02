package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import ar.edu.unju.fi.tracking.model.Vehiculo;

public interface IVehiculoDAO extends JpaRepository<Vehiculo, Long>{

	
	public Optional<Vehiculo> findByPatente(String patente);
}
