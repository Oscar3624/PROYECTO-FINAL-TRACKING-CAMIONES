package ar.edu.unju.fi.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String index() {
		
		return "index";
	}

	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "login";
	}
}
