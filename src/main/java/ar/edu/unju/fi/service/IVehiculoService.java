package ar.edu.unju.fi.service;

import java.util.List;

//import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Vehiculo;

public interface IVehiculoService {
	

	public void guardarVehiculo(Vehiculo vehiculo);
	public List<Vehiculo> obtenerVehiculo();
	public Vehiculo buscarVehiculo(String patente);
	public void eliminar(Long id);
	public Vehiculo modificar(Vehiculo vehiculo) throws Exception;
	public Vehiculo encontrarVehiculo(Long id) throws Exception;
	 

	
	
}
