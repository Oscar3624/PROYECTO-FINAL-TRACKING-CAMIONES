package ar.edu.unju.fi.tracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ILocalidadService;

import ar.edu.unju.fi.tracking.model.Localidad;



@Controller
@RequestMapping
public class LocalidadController {

//	@Autowired
//	ILocalidadService localidadService;
//	@Autowired
//	private Localidad localidad;
//	
//	@RequestMapping("/localidad")
//	public String localidad(Model model) {
//		List<Localidad> localidades = localidadService.obtenerLocalidades();
//		model.addAttribute("localidades", localidades);
//		return "localidad";
//	}
//	
//	@GetMapping("/localidad")
//	public String listaLocalidades(Model model) {
//		model.addAttribute("localidad", new Localidad());
//		model.addAttribute("localidades",localidadService.obtenerLocalidades());
//		model.addAttribute("formTab","active");
//		return "localidad";
//		
//		
//	}
//	
////	@PostMapping("/save")
////	public String guardar(@Valid @ModelAttribute("localidad") Localidad localidad, BindingResult result,
////			ModelMap model) {
////		// agregado Valid (en el modelo tambien) y BindingResult
////		if (result.hasErrors()) {
////			// si da error el objeto recibido se vuelve a enviar a la vista
////			model.addAttribute("localidad", localidad);
////			model.addAttribute("formTab", "active");
////		} else {
////			try {
////				localidadService.guardar(localidad);
////				model.addAttribute("localidad", localidad);
////				model.addAttribute("listTab", "active");
////				model.addAttribute("localidad", localidadService.obtenerLocalidades());
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				// pasar las excepciones al html
////				model.addAttribute("formLocalidadErrorMessage", e.getMessage());
////				model.addAttribute("localidad", localidad);
////				model.addAttribute("localidad", localidadService.obtenerLocalidades());
////				model.addAttribute("formTab", "active");
////			}
////			
////		}
////		
////		return "redirect:/localidad";
////	}
//	
//	@PostMapping("/save")
//	public String guardar(@Valid Localidad localidad, Model model) {
//		localidadService.guardar(localidad);
//		return "redirect:/localidad";
//		
//	}
//	
//	
}
