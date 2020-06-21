package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tracking.model.RegistroTracking;

//import ar.edu.unju.fi.tracking.model.RegistroTracking;

public interface IRegistroTrackingDAO extends JpaRepository<RegistroTracking, Long>{
	/**public void guardar();
	public RegistroTracking mostrar();
	public void eliminar();
	public RegistroTracking modificar();
	*/
}
