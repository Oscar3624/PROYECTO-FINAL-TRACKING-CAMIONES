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

import ar.edu.unju.fi.service.IRegistroTrackingService;
//import ar.edu.unju.fi.repository.ITripulanteDAO;
//import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
import ar.edu.unju.fi.tracking.model.Localidad;
//import ar.edu.unju.fi.service.RegistroTrackingImp;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
//import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Usuario;

@Controller
@RequestMapping

public class RegistroController {
	
	//@Autowired
	//private IRegistroTrackingService iRegistroTrackingImp;
	
	@Autowired
	ITripulanteService tripulanteservice;
	
	@Autowired
	IRegistroTrackingService registroservice;
	
	@Autowired
	private RegistroTracking registro;

	/**@RequestMapping("/Datos")
	public String getDatosform(Model model)
	{
		List<Tripulante> tripulantes = tripulanteservice.obtenerTripulante();
		model.addAttribute("tripulante", tripulantes);	
		return "Datos";
	}*/
	
	
	
	
	@RequestMapping("/registroForm")
	public String agregar(Model model) {
		List<RegistroTracking> registross = registroservice.obtenerRegistro();
		model.addAttribute("registro", registross);
		return "registroForm";
	}
	
	
	
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "login";
	}
	
	//-----
	
	 @GetMapping("/registroForm")
	public String listaRegistro(Model model) {
		model.addAttribute("registroDelForm", new RegistroTracking());
		model.addAttribute("registros", registroservice.obtenerRegistro());
		model.addAttribute("formTab","active");
		return "registroForm";
		
		}
	
	 @GetMapping("/cancelar1")
		public String cancelarEditarRegistro(ModelMap model) {
			return "redirect:/registroForm";
		}
		
	
	 
	
	
	//----
	

	 @PostMapping("/Form")
	public String guardar(@Valid @ModelAttribute("registroDelForm") RegistroTracking registro2, BindingResult result,
			ModelMap model) {
		// agregado Valid (en el modelo tambien) y BindingResult
		if (result.hasErrors()) {
			// si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("registroDelForm", registro2);
			model.addAttribute("formTab", "active");
		} else {
			try {
				registroservice.guardarRegistro(registro2);
				model.addAttribute("registroDelForm", registro);
				model.addAttribute("listTab", "active");
				model.addAttribute("registros", registroservice.obtenerRegistro());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formRegistroTrackingErrorMessage", e.getMessage());
				model.addAttribute("registroDelForm", registro2);
				model.addAttribute("registros", registroservice.obtenerRegistro());
				model.addAttribute("formTab", "active");
			}
			
		}
		model.addAttribute("registros", registroservice.obtenerRegistro());	
		return "registroForm";
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
