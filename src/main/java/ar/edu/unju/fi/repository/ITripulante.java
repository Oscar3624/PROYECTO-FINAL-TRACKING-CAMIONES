package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulante {
	public void guardar();
	public Tripulante mostrar();
	public void eliminar();
	public Tripulante modificar();
}
