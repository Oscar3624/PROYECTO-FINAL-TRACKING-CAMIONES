package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repository.IRegistroTracking;
import ar.edu.unju.fi.tracking.model.RegistroTracking;

@Repository
public class RegistroTrackingImp implements IRegistroTrackingService{
	@Autowired
	private IRegistroTracking iregistrotracking;
	
	@Override
	public void guardar() {
		iregistrotracking.guardar();		
	}

	@Override
	public RegistroTracking mostrar() {
		RegistroTracking registrotracking= iregistrotracking.mostrar();
		return registrotracking;
	}

	@Override
	public void eliminar() {
		iregistrotracking.eliminar();		
	}

	@Override
	public RegistroTracking modificar() {
		RegistroTracking registrotracking= iregistrotracking.modificar();
		return registrotracking;
	}

}