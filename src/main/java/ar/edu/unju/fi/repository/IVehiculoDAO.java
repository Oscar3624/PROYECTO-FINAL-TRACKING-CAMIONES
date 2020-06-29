package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tracking.model.Vehiculo;

public interface IVehiculoDAO extends JpaRepository<Vehiculo, Long>{

}
