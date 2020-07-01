package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IRegistroTrackingDAO;
import ar.edu.unju.fi.tracking.model.RegistroTracking;

@Service
public class RegistroTrackingImp implements IRegistroTrackingService{
	
	@Autowired
	IRegistroTrackingDAO registroTrackingDAOImp;

	@Override
	public void guardarRegistro(RegistroTracking registro) {
		registroTrackingDAOImp.save(registro);
		
	}

	@Override
	public List<RegistroTracking> obtenerRegistro() {
		// TODO Auto-generated method stub
		return registroTrackingDAOImp.findAll();
	}

	@Override
	public RegistroTracking mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegistroTracking modificar(RegistroTracking registro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistroTracking encontrarRegistro(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}