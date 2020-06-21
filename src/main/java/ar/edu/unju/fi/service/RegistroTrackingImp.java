package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IRegistroTrackingDAO;
import ar.edu.unju.fi.tracking.model.RegistroTracking;

@Service
public class RegistroTrackingImp implements IRegistroTrackingService{
	@Autowired
	private IRegistroTrackingDAO registroTrackingDAOImp;

	@Override
	public void guardarRegistro(RegistroTracking registro) {
		registroTrackingDAOImp.save(registro);
		
	};
	
}