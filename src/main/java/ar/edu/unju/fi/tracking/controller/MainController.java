package ar.edu.unju.fi.tracking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.tracking.model.RegistroTracking;



@Controller
@RequestMapping

public class MainController {
	
	@Autowired
	private IRegistroTrackingService iRegistroTrackingImp;
	
	@Autowired
	private RegistroTracking registro;

	@GetMapping("/nuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("registroForm", registro);
		return "prueba";
	}
	
	
	@PostMapping("/save")
	public String guardar(@Valid RegistroTracking registro, Model model  ) {
		iRegistroTrackingImp.guardarRegistro(registro);
		return "redirect:/prueba";
		
	}
}
