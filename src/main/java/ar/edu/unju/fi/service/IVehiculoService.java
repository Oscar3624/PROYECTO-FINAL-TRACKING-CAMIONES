package ar.edu.unju.fi.service;

import ar.edu.unju.fi.tracking.model.Vehiculo;

public interface IVehiculoService {
	public void guardar();
	public Vehiculo mostrar();
	public void eliminar();
	public Vehiculo modificar();
}
