package ar.edu.unju.fi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IRegistroTrackingDAO;
import ar.edu.unju.fi.tracking.model.RegistroTracking;

@Service
public class RegistroTrackingImp implements IRegistroTrackingService{
	
	@Autowired
	IRegistroTrackingDAO registroTrackingDAOImp;
	
	private List<RegistroTracking> listadoAuxilar = new ArrayList<>();

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
	
	public List<RegistroTracking> buscarFecha(String desde, String hasta) throws ParseException {
	    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	    Date desdee = formater.parse(desde);
	    Date hastaa = formater.parse(hasta);


	       // System.out.println("desde = "+desdee+" hastaa = "+hastaa);
	    List<RegistroTracking> vs =  registroTrackingDAOImp.findByAllDataBetween(desdee,hastaa);   
	    return vs;
	}

	@Override
	public void guardarRegistroEncontrado(RegistroTracking unRegistro) {
		// TODO Auto-generated method stub
		listadoAuxilar.add(unRegistro);
	}

}