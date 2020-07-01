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
		model.addAttribute("usuarioDelForm", new Usuario());
		model.addAttribute("usuarios",usuarioService.obtenerUsuarios());
		model.addAttribute("formTab","active");
		return "usuario";
		
		
	}
	//----
	@GetMapping("/cancelar")
	public String cancelarEditarUsuario(ModelMap model) {
		return "redirect:/usuario";
	}
	

	//---
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.eliminar(id);
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/usuario";
	}
	
	//--------
	
	@GetMapping("/editarUsuario/{id}")
	public String obtenerFormularioEditarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {		
		try {
			Usuario usuarioEncontrado = usuarioService.encontrarUsuario(id);
			model.addAttribute("usuarioDelForm", usuarioEncontrado);
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("usuarioDelForm", usuario);
			model.addAttribute("editMode", "false");
		}				
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());		
		model.addAttribute("formTab", "active");		
		return "usuario";
	}
	
	
	//----------
	
	@PostMapping("/editarUsuario")
	public String postEditarUsuario(@Valid @ModelAttribute("usuarioDelForm") Usuario usuarioo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			//si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("usuarioDelForm", usuarioo);			
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				usuarioService.modificar(usuario);
				model.addAttribute("usuarioDelForm", usuario);
				model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formUsuarioErrorMessage",e.getMessage());
				model.addAttribute("usuarioDelForm", usuarioo);			
				model.addAttribute("formTab", "active");	
				model.addAttribute("usuarios", usuarioService.obtenerUsuarios());				
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());		
		return "usuario";
	}
	
	//---------
	
	
	
	
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute("usuarioDelForm") Usuario usuario2, BindingResult result,
			ModelMap model) {
		// agregado Valid (en el modelo tambien) y BindingResult
		if (result.hasErrors()) {
			// si da error el objeto recibido se vuelve a enviar a la vista
			model.addAttribute("usuarioDelForm", usuario2);
			model.addAttribute("formTab", "active");
		} else {
			try {
				usuarioService.guardar(usuario2);
				model.addAttribute("usuarioDelForm", usuario);
				model.addAttribute("listTab", "active");
				model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuarioDelForm", usuario2);
				model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
				model.addAttribute("formTab", "active");
			}
			
		}
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());	
		return "usuario";
	}
	
	//@PostMapping("/save")
	//public String guardar(@Valid Usuario usuario, Model model) {
	//	usuarioService.guardar(usuario);
	//	return "redirect:/usuario";
		
//	}
	
	
}