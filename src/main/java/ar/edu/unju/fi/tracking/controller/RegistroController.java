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
import ar.edu.unju.fi.service.IRegistroTrackingService;
//import ar.edu.unju.fi.repository.ITripulanteDAO;
//import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
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
	
	@GetMapping("/servicio")
	public String mostrarServicio(Model model) {
		//LocalDate fecha = LocalDate.parse("2020-06-16");
		RegistroTracking unaRegistro = new RegistroTracking ();
		//unaNoticia.setFecha(fecha);
		//unaRegistro.setVehiculo();
		//unaRegistro.setTripulante(List<> unTripulante );
		//unaRegistro.setLocalidad(localidad);
		Vehiculo unVehiculo = new Vehiculo();
		unVehiculo.setColor("rojo");
		//unVehiculo.setApellido("Sosa");
		//unVehiculo.setNoticia(unaNoticia);
		//ivehiculoDAO.save(unVehiculo);		
		//iNoticiaService.guardarNoticia(unaNoticia);	
		
		//model.addAttribute("noticiaDeLaVista", unaNoticia);
		model.addAttribute("todasLasNoticias", iRegistroTrackingService.buscarTodasNoticias());
		//model.addAttribute("formTab", "active");
		return "servicio";
	}
	
	
	@GetMapping("/agregarNoticia")
	public String crearNoticia(Model model) {	
		model.addAttribute("noticiaDelForm",unRegistroTracking);				
		model.addAttribute("tripulantes",iTripulanteService.buscarTodosTripulante());
		model.addAttribute("autorDelForm", unTripulante);
		return "registroForm";
	}
		
	@PostMapping("/agregarNoticia")
	public String crearNoticiaFinal(@ModelAttribute("noticiaDelForm") RegistroTracking registro, Model model) {
			registro.setTripulante(iTripulanteService.buscarTodosTripulante());
			try {				
				iRegistroTrackingService.guardarRegistro(registro);	
			} catch (Exception e) {
				// TODO Auto-generated catch block			
				model.addAttribute("formAutorErrorMessage", e.getMessage());				
			}	
		iTripulanteService.borrarTodosTripulante();
		return "redirect:/agregarNoticia";
	}
	
	@PostMapping("/agregarAutor")
	public String crearAutor(@ModelAttribute("autorDelForm") Tripulante tripulante,  Model model) throws Exception {			
			try {			
				iTripulanteService.guardarTripulante(tripulante);
			} catch (Exception f) {
				// TODO Auto-generated catch block				 
				model.addAttribute("formAutorErrorMessage", f.getMessage());				
			}
					
	return "redirect:/agregarNoticia";
}
	
	@PostMapping("/buscarAutor")
	public String buscarAutor(@ModelAttribute("autorDelForm") Tripulante tripulante,  Model model) throws Exception {	
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
	
	@PostMapping("/buscarNoticiasAutor")
	public String buscarNoticiasAutor(@ModelAttribute("autorDelForm") Tripulante tripulante,  Model model) throws Exception {	
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
