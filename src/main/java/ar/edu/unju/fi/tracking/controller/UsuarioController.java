package ar.edu.unju.fi.tracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String guardar(@Valid Usuario usuario, Model model) {
		usuarioService.guardar(usuario);
		return "redirect:/usuario";
		
	}
	
	
}
