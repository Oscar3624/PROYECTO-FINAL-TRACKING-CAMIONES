package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repository.ITripulante;
import ar.edu.unju.fi.tracking.model.Tripulante;

@Repository
public class TripulanteServiceImp implements ITripulanteService{
	@Autowired
	private ITripulante itripulante;
	
	@Override
	public void guardar() {
		itripulante.guardar();
	}

	@Override
	public Tripulante mostrar() {
		Tripulante tripulante= itripulante.mostrar();
		return tripulante;
	}

	@Override
	public void eliminar() {
		itripulante.eliminar();
		
	}

	@Override
	public Tripulante modificar() {
		Tripulante tripulante= itripulante.modificar();
		return tripulante;
	}

}
