package ar.edu.unju.fi.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.service.ILocalidadService;
import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
import ar.edu.unju.fi.service.IVehiculoService;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

@Controller
@RequestMapping

public class RegistroController {

	@Autowired
	IRegistroTrackingService iRegistroTrackingService;
	
	@Autowired
	RegistroTracking unRegistroTracking;
		
	@Autowired
	ITripulanteService iTripulanteService;
	
	@Autowired
	Tripulante unTripulante;
	
	@Autowired
	IVehiculoService vehiculoService;
	
	@Autowired
	Vehiculo unVehiculo;
	
	@Autowired
	ILocalidadService localidadService;
	
	Vehiculo vehiculoEncontrado;
	Vehiculo vehiculoNuevo;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/nuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("registro", unRegistroTracking);
		model.addAttribute("localidades", localidadService.obtenerLocalidades());
		model.addAttribute("tripulantes", iTripulanteService.buscarTodosTripulante());
		model.addAttribute("tripulanteDelForm", unTripulante);
		model.addAttribute("vehiculos", vehiculoService.obtenerVehiculo());
		model.addAttribute("vehiculoDelForm", unVehiculo);
		
		
		return "registroForm";
	}

	
	/**
	 * 
	 * @param tripulante
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/agregarTripulante") // agrega un nuevo tripulante con datos nuevos
	public String crearTripulante(@ModelAttribute("tripulanteDelForm") Tripulante tripulante, Model model)
			throws Exception {
		try{
			iTripulanteService.guardarTripulante(tripulante);
		} catch (Exception f) {
			// TODO Auto-generated catch block
			model.addAttribute("formAutorErrorMessage", f.getMessage());
		}
		return agregar(model);
	}

	/**
	 * 
	 * @param tripulante
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/buscarTripulante") // busca a algun tripulante dependiendo si se encuentra en la bd
	public String buscarTripulante(@ModelAttribute("tripulanteDelForm") Tripulante tripulante, Model model)
			throws Exception {
		try {
			Tripulante tripulanteEncontrado = iTripulanteService.buscarTripulante(tripulante.getDocumento());
			try {
				iTripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("formAutorErrorMessage", e.getMessage());
			}
		} catch (Exception e) {
			model.addAttribute("formAutorErrorMessage", e.getMessage());
		}
		
		return agregar(model);
	}

	
	// Vehiculo 
	
	/**
	 * 
	 * @param vehiculo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/buscarVehiculo")
	public String buscarVehiculo(@ModelAttribute("vehiculoDelForm") Vehiculo vehiculo, Model model) throws Exception {
		try {
			Vehiculo vehiculoEncontrado = vehiculoService.buscarVehiculo(vehiculo.getPatente());
			try {
				vehiculoService.guardarVehiculo(vehiculoEncontrado);
			}catch(Exception e) {
				
				model.addAttribute("formVehiculoErrorMessage", e.getMessage());
			}
			//model.addAttribute("vehiculoEncontrado", vehiculoEncontrado);
			
		} catch (Exception e) {
			model.addAttribute("formVehiculoErrorMessage", e.getMessage());
		}
		return agregar(model);

	}

	
	
	
	@PostMapping("/agregarVehiculo")
	public String crearVehiculo(@ModelAttribute("vehiculoDelForm") Vehiculo vehiculo, Model model) throws Exception {
		try {
			vehiculoService.guardarVehiculo(vehiculo);
			vehiculoNuevo = vehiculo;
			model.addAttribute("vehiculoNuevo", vehiculo);
			
		} catch (Exception f) {
			// TODO: handle exception
			model.addAttribute("vehiculoNuevo", f.getMessage());
		}
		return agregar(model);

	}
	


	@PostMapping("/saveRegistro")
	public String guardar(@ModelAttribute("registro") RegistroTracking registro, Model model) {

		if (vehiculoEncontrado != null) {
			registro.setVehiculo(vehiculoEncontrado);
		} else {

			if (vehiculoNuevo!= null) {
				registro.setVehiculo(vehiculoNuevo);
			}
		}
		
		registro.setTripulante(iTripulanteService.buscarTodosTripulante());
		
		try {
			iRegistroTrackingService.guardarRegistro(registro);

		} catch (Exception e) {
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		iTripulanteService.borrarTodosTripulante();
		vehiculoService.borrartodosV();
		return "redirect:/nuevoRegistro";
	}
	
	
	@GetMapping("/cancelarRegistro")
	public String cancelarRegistro(ModelMap model) {
		return "redirect:/registros";
	}

	

}
