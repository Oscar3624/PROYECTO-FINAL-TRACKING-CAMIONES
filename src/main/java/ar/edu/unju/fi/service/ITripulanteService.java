package ar.edu.unju.fi.service;

import java.util.List;

//import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulanteService {
	
	public void guardarTripulanteEncontrado(Tripulante unTripulante);
	public void guardarTripulante(Tripulante unTripulante);
	public Tripulante buscarTripulante(String documento) throws Exception;
	public List<Tripulante> buscarTodosTripulante();
	public void borrarTodosTripulante();
	 
	
	
}
