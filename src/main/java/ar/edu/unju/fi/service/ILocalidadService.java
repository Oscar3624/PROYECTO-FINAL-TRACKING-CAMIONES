package ar.edu.unju.fi.service;

import ar.edu.unju.fi.tracking.model.Localidad;

public interface ILocalidadService {
	public void guardar();
	public Localidad mostrar();
	public void eliminar();
	public Localidad modificar();
}
