package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.RegistroTracking;



public interface IRegistroTrackingDAO extends JpaRepository<RegistroTracking, Long>{
	/**public void guardar();
	public RegistroTracking mostrar();
	public void eliminar();
	public RegistroTracking modificar();
	*/

}
