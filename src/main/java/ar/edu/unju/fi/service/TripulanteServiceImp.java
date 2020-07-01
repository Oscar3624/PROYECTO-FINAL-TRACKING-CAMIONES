package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.ITripulanteDAO;
import ar.edu.unju.fi.tracking.model.Tripulante;

@Service
public class TripulanteServiceImp implements ITripulanteService{

	@Autowired
	ITripulanteDAO tripulanteDAOImp;
	
	@Override
	public void guardarTripulante(Tripulante tripulante) {
		// TODO Auto-generated method stub
		tripulanteDAOImp.save(tripulante);
		
	}

	@Override
	public List<Tripulante> obteneTripulante() {
		// TODO Auto-generated method stub
		return tripulanteDAOImp.findAll();
	}

	@Override
	public Tripulante mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tripulante modificar(Tripulante tripulante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tripulante encontrarTripulante(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
