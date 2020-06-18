package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.tracking.model.RegistroTracking;

public interface IRegistroTracking {
	public void guardar();
	public RegistroTracking mostrar();
	public void eliminar();
	public RegistroTracking modificar();
}
