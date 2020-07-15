package ar.edu.unju.fi.service;

import java.time.LocalDateTime;
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
		registro.setFechaHora(LocalDateTime.now());
		registroTrackingDAOImp.save(registro);
	}

	@Override
	public List<RegistroTracking> obtenerRegistros() {
		return registroTrackingDAOImp.obtenerRegistros();
	}

	@Override
	public RegistroTracking encontrarRegistro(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}