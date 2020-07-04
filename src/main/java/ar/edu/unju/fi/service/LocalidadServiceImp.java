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
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		localidadDAO.deleteById(id);
	}

	@Override
	public Localidad modificar(Localidad localidad) throws Exception {
		// TODO Auto-generated method stub
		
		Localidad localidadGuardar = encontrarLocalidad(localidad.getId());
		
		mapearLocalidad(localidad, localidadGuardar);		
		
		return localidadDAO.save(localidadGuardar);
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

	public void mapearLocalidad(Localidad desde, Localidad hacia) {
		hacia.setNombre(desde.getNombre());
		
	}
	
	@Override
	public Localidad encontrarLocalidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		return localidadDAO.findById(id).orElseThrow(()-> new Exception("La Localidad no Existe"));
	}
	
}
