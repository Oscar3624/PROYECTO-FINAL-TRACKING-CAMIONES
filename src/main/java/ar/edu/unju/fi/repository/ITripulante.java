package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulante {
	public void guardar();
	public Tripulante mostrar();
	public void eliminar();
	public Tripulante modificar();
	
	@Query("from Tripulante T order by T.nombre")
	public List<Tripulante> obtenerTripulante();
}
