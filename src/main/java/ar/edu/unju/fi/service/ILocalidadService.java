package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.tracking.model.Localidad;



public interface ILocalidadService {
	public void guardar(Localidad localidad);
	public List<Localidad> obtenerLocalidades();
	public void eliminar(Long id);
	public Localidad modificar(Localidad localidad) throws Exception;
	public Localidad encontrarLocalidad(Long id) throws Exception;
}
