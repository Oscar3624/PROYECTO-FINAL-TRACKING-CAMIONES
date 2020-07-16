package ar.edu.unju.fi.tracking.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;

@Controller
@RequestMapping

public class usuarioConsultor {

	@Autowired
	IRegistroTrackingService iRegistroTrackingService;
	
	@Autowired
	RegistroTracking unRegistroTracking;
	
	
	@GetMapping("/consultor")
	public String agregar1(Model model) {
		model.addAttribute("registro", unRegistroTracking);

		
		
		return "consultor";
	}
	
	
	
	
	
	@PostMapping("/consultor")
	public String mostrar( @RequestParam(value = "desde" , defaultValue = "2000-01-01")String desde,
	        @RequestParam (value ="hasta" , defaultValue = "2030-01-01")String hasta, Model model) throws ParseException {
	    //Paso fechas a servicio
	   //mp.addObject("registros", iRegistroTrackingService.buscarFecha(desde, hasta));
	    
		
	    
	      List<RegistroTracking> registros = iRegistroTrackingService.buscarFecha(desde, hasta); 
	      
	      model.addAttribute("registros", registros);
	     
	    //System.out.println(desde+"    "+hasta);
	    return agregar1(model);

	}
	
	
	
	
}
