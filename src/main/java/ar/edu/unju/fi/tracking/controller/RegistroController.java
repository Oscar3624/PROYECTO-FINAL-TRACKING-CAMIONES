package ar.edu.unju.fi.tracking.controller;



import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.repository.IUsuarioDAO;
import ar.edu.unju.fi.repository.IVehiculoDAO;
import ar.edu.unju.fi.service.ILocalidadService;
import ar.edu.unju.fi.service.IRegistroTrackingService;
//import ar.edu.unju.fi.repository.ITripulanteDAO;
//import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
import ar.edu.unju.fi.service.IVehiculoService;
import ar.edu.unju.fi.tracking.model.Localidad;
//import ar.edu.unju.fi.service.RegistroTrackingImp;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
//import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.model.Vehiculo;

@Controller
@RequestMapping

public class RegistroController {
	
	@Autowired
	IRegistroTrackingService iRegistroTrackingService;
	@Autowired
	ITripulanteService iTripulanteService;
	@Autowired
	RegistroTracking unRegistroTracking;
	@Autowired
	Tripulante unTripulante;
	@Autowired
	IVehiculoDAO ivehiculoDAO;
	@Autowired
	RegistroTracking unRegistroTrackingIntermedio;
	@Autowired
	Localidad unaLocalidad;
	@Autowired
	ILocalidadService localidadService;
	@Autowired
	Vehiculo unVehiculo;
	@Autowired
	IVehiculoService vehiculoService;
	
	
	
	@GetMapping("/agregarNoticia")  // aca creo que crearia los tripulantes y los va almacenando en la lista
	public String crearNoticia(Model model) {	
		
						
		model.addAttribute("localidades",localidadService.obtenerLocalidades());
		model.addAttribute("vehiculos",vehiculoService.obtenerVehiculo());
		model.addAttribute("vehiculoDelForm", unVehiculo);
		model.addAttribute("noticiaDelForm",unRegistroTracking);				
		model.addAttribute("tripulantes",iTripulanteService.buscarTodosTripulante());
		model.addAttribute("tripulanteDelForm", unTripulante);
		model.addAttribute("localidadDelForm", unaLocalidad);
		model.addAttribute("noticiaDelForm",unRegistroTracking);
		model.addAttribute("noticiaDelForm",unRegistroTracking);
		return "registroForm";
	}
		
	@PostMapping("/agregarNoticia") // aca dependiendo de los tripulantes y el registro los guarda y despues limpia la lista al final
	public String crearNoticiaFinal(@ModelAttribute("localidadDelForm") Localidad localidad , @ModelAttribute("vehiculoDelForm") Vehiculo vehiculo, @ModelAttribute("noticiaDelForm") RegistroTracking registro,  Model model) {
		
			registro.setTripulante(iTripulanteService.buscarTodosTripulante());
			try {				
				
				
				vehiculoService.guardarVehiculo(vehiculo);
				iRegistroTrackingService.guardarNoticia(registro);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block			
				model.addAttribute("formAutorErrorMessage", e.getMessage());				
			}	
		iTripulanteService.borrarTodosTripulante();
		return "redirect:/agregarNoticia";
	}
	
	@PostMapping("/agregarAutor") // agrega un nuevo tripulante con datos nuevos
	public String crearAutor(@ModelAttribute("tripulanteDelForm") Tripulante tripulante,  Model model) throws Exception {			
			try {			
				iTripulanteService.guardarTripulante(tripulante);
			} catch (Exception f) {
				// TODO Auto-generated catch block				 
				model.addAttribute("formAutorErrorMessage", f.getMessage());				
			}
					
	return "redirect:/agregarNoticia";
}
	
	@PostMapping("/buscarAutor") // busca a algun tripulante dependiendo si se encuentra en la bd
	public String buscarAutor(@ModelAttribute("tripulanteDelForm") Tripulante tripulante,  Model model) throws Exception {	
		try {
			Tripulante tripulanteEncontrado = iTripulanteService.buscarTripulante(tripulante.getApellido());
			try {			
				iTripulanteService.guardarTripulanteEncontrado(tripulanteEncontrado);
			} catch (Exception e) {
				// TODO Auto-generated catch block				 
				model.addAttribute("formAutorErrorMessage", e.getMessage());				
			}
		}catch(Exception e) {			
			model.addAttribute("formAutorErrorMessage", e.getMessage());
		}			
	return crearNoticia(model);
}
	
	@PostMapping("/buscarNoticiasAutor")  // creo que busca los vehiculos de algun tripulante ya ingresado
	public String buscarNoticiasAutor(@ModelAttribute("tripulanteDelForm") Tripulante tripulante,  Model model) throws Exception {	
		try {
			Tripulante tripulanteEncontrado = iTripulanteService.buscarTripulante(tripulante.getApellido());
			try {			
				model.addAttribute("registros",iRegistroTrackingService.buscarNoticiasDelAutor(tripulanteEncontrado));
			} catch (Exception e) {
				// TODO Auto-generated catch block				 
				model.addAttribute("formAutorErrorMessage", e.getMessage());				
			}
		}catch(Exception e) {			
			model.addAttribute("formAutorErrorMessage", e.getMessage());
		}			
	return crearNoticia(model);
}

	 
	
	 @GetMapping({"/","/login"})
		public String ingresar(Model model) {
			return "login";
		}
	
	
	
	/**@RequestMapping ("/login")
	public String login(Model model) {
		
		return "login";
	}*/
	
	//@PostMapping("/save")
	//public String guardar(@Valid RegistroTracking registro, Model model  ) {
		//iRegistroTrackingImp.guardarRegistro(registro);
		//return "redirect:/Datos";
		
//	}
}
