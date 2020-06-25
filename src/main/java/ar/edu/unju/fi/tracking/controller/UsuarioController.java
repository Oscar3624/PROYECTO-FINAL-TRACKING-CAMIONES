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

import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Usuario;

@Controller
@RequestMapping
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	private Usuario usuario;
	
	@RequestMapping("/usuario")
	public String usuario(Model model) {
		List<Usuario> usuarios = usuarioService.obtenerUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "usuario";
	}
	
	@GetMapping("/usuario")
	public String listaUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios",usuarioService.obtenerUsuarios());
		model.addAttribute("formTab","active");
		return "usuario";
		
		
	}
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result,
			ModelMap model) {
		// agregado Valid (en el modelo tambien) y BindingResult
		if (result.hasErrors()) {
			// si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("usuario", usuario);
			model.addAttribute("formTab", "active");
		} else {
			try {
				usuarioService.guardar(usuario);
				model.addAttribute("usuario", usuario);
				model.addAttribute("listTab", "active");
				model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuario", usuario);
				model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
				model.addAttribute("formTab", "active");
			}
			
		}
		
		return "redirect:/usuario";
	}
	
	//@PostMapping("/save")
	//public String guardar(@Valid Usuario usuario, Model model) {
	//	usuarioService.guardar(usuario);
	//	return "redirect:/usuario";
		
//	}
	
	
}
