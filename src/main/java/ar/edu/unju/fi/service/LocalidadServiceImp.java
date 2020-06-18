package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repository.ILocalidad;
import ar.edu.unju.fi.tracking.model.Localidad;

@Repository
public class LocalidadServiceImp implements ILocalidadService{
	@Autowired
	private ILocalidad ilocalidad;
	
	@Override
	public void guardar() {
		ilocalidad.guardar();
	}

	@Override
	public Localidad mostrar() {
		Localidad localidad= ilocalidad.mostrar();
		return localidad;
	}

	@Override
	public void eliminar() {
		ilocalidad.eliminar();
		
	}

	@Override
	public Localidad modificar() {
		Localidad localidad= ilocalidad.modificar();
		return localidad;
	}

}
