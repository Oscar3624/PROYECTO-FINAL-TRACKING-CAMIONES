package ar.edu.unju.fi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IVehiculoDAO;
import ar.edu.unju.fi.tracking.model.Vehiculo;

@Service
public class VehiculoServiceImp implements IVehiculoService{

	
	@Autowired
	IVehiculoDAO vehiculoDAOImp;
	private List<Vehiculo> listadoAuxiliar = new ArrayList<>();
	
	@Override
	public void guardarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		vehiculoDAOImp.save(vehiculo);
		listadoAuxiliar.add(vehiculo);
	}

	@Override
	public List<Vehiculo> obtenerVehiculo() {
		// TODO Auto-generated method stub
		return listadoAuxiliar;
	}


	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehiculo modificar(Vehiculo vehiculo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo encontrarVehiculo(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo buscarVehiculo(String patente) throws Exception {
		return vehiculoDAOImp.findByPatente(patente).orElseThrow(()-> new Exception("El vehiculo no Existe"));
	}

	@Override
	public void guardarVehiculoEncontrado(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		listadoAuxiliar.add(vehiculo);
	}

	@Override
	public void borrartodosV() {
		// TODO Auto-generated method stub
		listadoAuxiliar = new ArrayList<>();
		
	}
	

}
