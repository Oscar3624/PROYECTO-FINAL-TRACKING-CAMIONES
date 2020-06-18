package ar.edu.unju.fi.service;

import ar.edu.unju.fi.tracking.model.RegistroTracking;

public interface IRegistroTrackingService {
	public void guardar();
	public RegistroTracking mostrar();
	public void eliminar();
	public RegistroTracking modificar();
}
