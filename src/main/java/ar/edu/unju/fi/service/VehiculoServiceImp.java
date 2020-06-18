package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repository.IVehiculo;
import ar.edu.unju.fi.tracking.model.Vehiculo;

@Repository
public class VehiculoServiceImp implements IVehiculoService{
	@Autowired
	private IVehiculo ivehiculo;
	
	@Override
	public void guardar() {
		ivehiculo.guardar();		
	}

	@Override
	public Vehiculo mostrar() {
		Vehiculo vehiculo = ivehiculo.mostrar();
		return vehiculo;
	}

	@Override
	public void eliminar() {
		ivehiculo.eliminar();	
		
	}

	@Override
	public Vehiculo modificar() {
		Vehiculo vehiculo = ivehiculo.modificar();
		return vehiculo;
	}

}
