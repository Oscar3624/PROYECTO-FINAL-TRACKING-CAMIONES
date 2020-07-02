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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ILocalidadService;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Usuario;



@Controller
@RequestMapping
public class LocalidadController {

	@Autowired
	ILocalidadService localidadService;
	@Autowired
	private Localidad localidad;
	
	@RequestMapping("/localidad")
	public String localidad(Model model) {
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("localidades", localidades);
		return "localidad";
	}
	
	@GetMapping("/localidad")
	public String listaLocalidades(Model model) {
		model.addAttribute("localidadDelForm", new Localidad());
		model.addAttribute("localidades",localidadService.obtenerLocalidades());
		model.addAttribute("formTab","active");
		return "localidad";
		
		
	}

	
	//----
		@GetMapping("/LocalidadCancelar")
		public String cancelarEditarLocalidad(ModelMap model) {
			return "redirect:/localidad";
		}
		
	//---
		
		@GetMapping("/eliminarLocalidad/{id}")
		public String eliminarLocalidad(Model model, @PathVariable(name="id") Long id) {
			try {
				localidadService.eliminar(id);
			}
			catch(Exception e){
				model.addAttribute("listErrorMessage",e.getMessage());
			}			
			return "redirect:/localidad";
		}
	
		
		//--------
		
		@GetMapping("/editarLocalidad/{id}")
		public String obtenerFormularioEditarLocalidad(Model model, @PathVariable(name="id") Long id) throws Exception {		
			try {
				Localidad localidadEncontrada = localidadService.encontrarLocalidad(id);
				model.addAttribute("localidadDelForm", localidadEncontrada);
				model.addAttribute("editMode", "true");
			}
			catch (Exception e) {
				model.addAttribute("formLocalidadErrorMessage",e.getMessage());
				model.addAttribute("localidadDelForm", localidad);
				model.addAttribute("editMode", "false");
			}				
			model.addAttribute("localidades", localidadService.obtenerLocalidades());		
			model.addAttribute("formTab", "active");		
			return "localidad";
		}
		
		
		//----------
		
		@PostMapping("/editarLocalidad")
		public String postEditarLocalidad(@Valid @ModelAttribute("localidadDelForm") Localidad localidadd, BindingResult result, ModelMap model) {
			if(result.hasErrors()) {
				//si da error el objeto recibido se vuelve a enviar a la vista
				model.addAttribute("localidadDelForm", localidadd);			
				model.addAttribute("formTab", "active");
				model.addAttribute("editMode", "true");
			} else {
				try {
					localidadService.modificar(localidad);
					model.addAttribute("localidadDelForm", localidad);
					model.addAttribute("listTab", "active");
					model.addAttribute("editMode", "false");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// pasar las excepciones al html
					model.addAttribute("formLocalidadErrorMessage",e.getMessage());
					model.addAttribute("localidadDelForm", localidadd);			
					model.addAttribute("formTab", "active");	
					model.addAttribute("localidades", localidadService.obtenerLocalidades());				
					model.addAttribute("editMode", "true");
				}
			}
			model.addAttribute("localidades", localidadService.obtenerLocalidades());		
			return "localidad";
		}
		
		
	
	@PostMapping("/formulario")
	public String guardar(@Valid @ModelAttribute("localidadDelForm") Localidad localidad2, BindingResult result,
			ModelMap model) {
		// agregado Valid (en el modelo tambien) y BindingResult
		if (result.hasErrors()) {
			// si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("localidadDelForm", localidad2);
			model.addAttribute("formTab", "active");
		} else {
			try {
				localidadService.guardar(localidad2);
				model.addAttribute("localidadDelForm", localidad);
				model.addAttribute("listTab", "active");
				model.addAttribute("localidades", localidadService.obtenerLocalidades());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formLocalidadErrorMessage", e.getMessage());
				model.addAttribute("localidadDelForm", localidad2);
				model.addAttribute("localidades", localidadService.obtenerLocalidades());
				model.addAttribute("formTab", "active");
			}
			
		}
		model.addAttribute("localidades", localidadService.obtenerLocalidades());	
		return "localidad";
	}
	
	
	
	
	
	/**@PostMapping("/formulario")
	public String guardar(@Valid Localidad localidad, Model model) {
		localidadService.guardar(localidad);
		return "redirect:/localidad";
		
	}**/
	
	
}
