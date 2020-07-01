package ar.edu.unju.fi.service;

import java.util.List;

//import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulanteService {
	
	 public void guardarTripulante(Tripulante tripulante);
	public List<Tripulante> obteneTripulante();
	public Tripulante mostrar();
	public void eliminar(Long id);
	public Tripulante modificar(Tripulante tripulante) throws Exception;
	public Tripulante encontrarTripulante(Long id) throws Exception;
	 
	
	
}
