package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.tracking.model.Localidad;

public interface ILocalidad {
	public void guardar();
	public Localidad mostrar();
	public void eliminar();
	public Localidad modificar();
}
