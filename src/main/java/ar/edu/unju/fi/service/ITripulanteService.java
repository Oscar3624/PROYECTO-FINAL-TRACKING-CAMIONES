package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulanteService {
	public void guardar();
	public Tripulante mostrar();
	public void eliminar();
	public Tripulante modificar();
	
	public List<Tripulante> obtenerTripulante();
}
