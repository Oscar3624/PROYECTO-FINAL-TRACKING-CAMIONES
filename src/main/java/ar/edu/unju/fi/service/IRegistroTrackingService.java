package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.tracking.model.RegistroTracking;

public interface IRegistroTrackingService {
	public void guardarRegistro(RegistroTracking registro);
	public List<RegistroTracking> obtenerRegistros();
	public RegistroTracking encontrarRegistro(Long id) throws Exception;
	
	
}
