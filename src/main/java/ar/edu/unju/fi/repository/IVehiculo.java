package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.tracking.model.Vehiculo;

public interface IVehiculo {
	public void guardar();
	public Vehiculo mostrar();
	public void eliminar();
	public Vehiculo modificar();
}
