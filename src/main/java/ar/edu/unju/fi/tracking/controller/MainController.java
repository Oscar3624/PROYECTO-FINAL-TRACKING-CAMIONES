package ar.edu.unju.fi.tracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.repository.ITripulante;
import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
import ar.edu.unju.fi.service.RegistroTrackingImp;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;



@Controller
@RequestMapping

public class MainController {
	
	@Autowired
	IRegistroTrackingService iRegistroTrackingImp;
	//private IRegistroTrackingService iRegistroTrackingImp;
	
	@Autowired
	ITripulanteService tripulanteservice;
	
	@Autowired
	private RegistroTracking registro;

	@RequestMapping("/Datos")
	public String getDatosform(Model model)
	{
		List<Tripulante> tripulantes = tripulanteservice.obtenerTripulante();
		model.addAttribute("tripulante", tripulantes);	
		return "Datos";
	}
	
	
	@GetMapping("/nuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("registroForm", registro);
		return "prueba";
	}
	
	@RequestMapping ("/login")
	public String login(Model model) {
		
		return "login";
	}
	//@PostMapping("/save")
	//public String guardar(@Valid RegistroTracking registro, Model model  ) {
		//iRegistroTrackingImp.guardarRegistro(registro);
		//return "redirect:/Datos";
		
//	}
}
