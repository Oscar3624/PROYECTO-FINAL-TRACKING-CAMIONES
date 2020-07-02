package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Usuario;

public interface IRegistroTrackingService {
	public void guardarRegistro(RegistroTracking registro);
	public List<RegistroTracking> obtenerRegistro();
	public RegistroTracking mostrar();
	public void eliminar(Long id);
	public RegistroTracking modificar(RegistroTracking registro) throws Exception;
	public RegistroTracking encontrarRegistro(Long id) throws Exception;
	 //---
	
	public void guardarNoticia(RegistroTracking unaRegistro);
	public RegistroTracking buscarNoticia(String titulo);
	public Iterable<RegistroTracking> buscarTodasNoticias();
	public void borrarNoticia(RegistroTracking unaRegistro);
	public Iterable<RegistroTracking> buscarNoticiasDelAutor(Tripulante tripulante);
	
}
