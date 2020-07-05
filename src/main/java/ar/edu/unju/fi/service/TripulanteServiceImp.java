package ar.edu.unju.fi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.ITripulanteDAO;
import ar.edu.unju.fi.tracking.model.Tripulante;

@Service
public class TripulanteServiceImp implements ITripulanteService{

	@Autowired
	ITripulanteDAO tripulanteDAOImp;
	private List<Tripulante> listadoAuxiliar = new ArrayList<>();

	@Override
	public void guardarTripulanteEncontrado(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		listadoAuxiliar.add(unTripulante);
	}

	@Override
	public void guardarTripulante(Tripulante unTripulante) {
		// TODO Auto-generated method stub
		tripulanteDAOImp.save(unTripulante);		
		listadoAuxiliar.add(unTripulante);
	}

	@Override
	public Tripulante buscarTripulante(String apellido) throws Exception {
		// TODO Auto-generated method stub
		return tripulanteDAOImp.findByApellido(apellido).orElseThrow(()-> new Exception("El tripulante no Existe"));
	}

	@Override
	public List<Tripulante> buscarTodosTripulante() {
		// TODO Auto-generated method stub
		return listadoAuxiliar;
	}

	@Override
	public void borrarTodosTripulante() {
		// TODO Auto-generated method stub
		listadoAuxiliar = new ArrayList<>();
	}
	
	

}
