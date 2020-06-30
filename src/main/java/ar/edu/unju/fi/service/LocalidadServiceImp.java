package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.ILocalidadDAO;
import ar.edu.unju.fi.tracking.model.Localidad;

@Service
public class LocalidadServiceImp implements ILocalidadService{
	
	@Autowired
	 ILocalidadDAO localidadDAO;
	
	

	@Override
	public void eliminar() {
		//ilocalidad.eliminar();
		
	}

	@Override
	public Localidad modificar() {
		//Localidad localidad= ilocalidad.modificar();
		return null;
	}

	@Override
	public void guardar(Localidad localidad) {
		// TODO Auto-generated method stub
		localidadDAO.save(localidad);
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		// TODO Auto-generated method stub
		return localidadDAO.findAll();
	}

	@Override
	public Localidad mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

}
