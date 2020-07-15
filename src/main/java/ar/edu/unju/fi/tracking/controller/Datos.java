package ar.edu.unju.fi.tracking.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.ILocalidadService;
import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.service.IVehiculoService;
import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.model.Vehiculo;

@Controller
@RequestMapping
public class Datos {

	@Autowired
	IRegistroTrackingService iRegistroTrackingService;
	
	@Autowired
	ILocalidadService localidadService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IVehiculoService vehiculoService;
	
	@Autowired
	ITripulanteService tripulanteService;
		
	@RequestMapping("/datos")
	public String localidad(Model model) {
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("localidades", localidades);
		
		List<Usuario> usuarios = usuarioService.obtenerUsuarios();
		model.addAttribute("usuarios", usuarios);
		
		List<Vehiculo> vehiculos = vehiculoService.obtenerTodosVehiculos();
		model.addAttribute("vehiculos", vehiculos);
		
		List<Tripulante> tripulantes = tripulanteService.buscarTodosTripulanteAux();
		model.addAttribute("tripulantes", tripulantes);
		
		return "datos";
	}
	
	@GetMapping("/datos")
	public String listaLocalidades(Model model) {
		model.addAttribute("localidadDelForm", new Localidad());
		model.addAttribute("localidades",localidadService.obtenerLocalidades());
		model.addAttribute("formTab","active");
		
		model.addAttribute("usuarioDelForm", new Usuario());
		model.addAttribute("usuarios",usuarioService.obtenerUsuarios());
		model.addAttribute("formTab","active");
		
		model.addAttribute("vehiculoDelForm", new Vehiculo());
		model.addAttribute("vehiculos",vehiculoService.obtenerTodosVehiculos());
		model.addAttribute("formTab","active");
		
		model.addAttribute("tripulanteDelForm", new Tripulante());
		model.addAttribute("tripulantes",tripulanteService.buscarTodosTripulanteAux());
		model.addAttribute("formTab","active");
		
		
		return "datos";
		
		
	}
	
	
	 @GetMapping("/cancelar1")
	public String cancelar1(ModelMap model) {
		return "redirect:/nuevoRegistro";
	}
	 
	 
	 
}
