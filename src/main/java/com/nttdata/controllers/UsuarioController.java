package com.nttdata.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nttdata.models.Usuarios;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	//desplegar inicialmente el jsp
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuarios") Usuarios usuario,
			Model model) {
		return "usuario/usuario.jsp";
	}
	
	@RequestMapping("registrarjsp")
	public String registrarJsp(@ModelAttribute("usuario") Usuarios usuario,
			Model model) {
		return "usuario/registro.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@Valid @ModelAttribute("usuario") Usuarios usuario, BindingResult br, RedirectAttributes ra) {
		/*usuarioService.registroUsuario(usuario);
		return "usuario/login.jsp";*/
		Usuarios usuario2 = usuarioService.findByEmail(usuario.getEmail());
		if(usuario2 == null) {
			//usuarioService.registroUsuario(usuario);
			usuarioService.persistirUsuarioRol(usuario);
		}
		return "redirect:/usuarios/login";
	}
	
	/*
	//capturar la informacion del formulario
		@RequestMapping("/login")
		
		public String login(@Valid @ModelAttribute("usuario") Usuarios usuario, BindingResult br, RedirectAttributes ra)
		{
			if(br.hasErrors()) {
				
				ra.addFlashAttribute("mensajeError", "Campos no validos");
				return "redirect:/usuarios";
			}
			
			
			System.out.println(usuario.getNombre()+" "+usuario.getApellido()+" "+usuario.getTelefono());
			
			
			usuarioService.insertarUsuario(usuario);
			
			return "redirect:/usuarios/lista";
		}
		*/
	
	//capturar la informacion del formulario
	/*@RequestMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		System.out.println(email + " " + password);

		boolean resultado = usuarioService.loginUsuario(email, password);
		if (resultado) {
			Usuarios usuario = usuarioService.findByEmail(email);
			session.setAttribute("usuario_id", usuario.getId());
			session.setAttribute("nombre_usuario", usuario.getNombre());
			return "redirect:/home";
		} else {
			return "redirect:/login";
		}

	}*/
	
	//capturar la informacion del formulario
		@RequestMapping("/login")
		public String login(Model model, Principal principal,
				HttpSession session
				) 
		{
			//boolean resultado = usuarioService.loginUsuario(email,password);
			/*if(resultado) {
				Usuarios usuario = usuarioService.findByEmail(email);
				//almacenando variables de sessio0n
				session.setAttribute("usuario_id", usuario.getId());
				session.setAttribute("nombre_usuario", usuario.getNombre());
				return "redirect:/home";
			}else {
				return "usuario/login.jsp";
			}*/
			
			String nombre = principal.getName();
			
			
			Usuarios usuario= usuarioService.findByNombre(nombre);
			model.addAttribute("nombre_usuario", usuario.getNombre());
			//return "redirect:/home";
			return "home.jsp";
			
			
		}
	
		
		
		@RequestMapping("/lista")
		public String lista(Model model) {
			
			model.addAttribute("listaUsuarios", usuarioService.listarUsuarios());
			return "listarUsuarios.jsp";
		}
		
		@RequestMapping("/eliminar")
		public String eliminarUsuario(@RequestParam("id") Long id) {
			
			Usuarios usuario = usuarioService.buscarUsuarioId(id);
			
			if(usuario !=null) {
				usuarioService.eliminarUsuariosObjeto(usuario);
			}
			
			return "redirect:/usuarios/lista";
		}
		
		@RequestMapping("/{id}/editar")
	    public String edit(@PathVariable("id") Long id, Model model) {
	    	System.out.println("editar");
	    	Usuarios usuario = usuarioService.buscarUsuarioId(id);
	    	if(usuario !=null) {
			       model.addAttribute("usuario", usuario);
			       return "editarUsuario.jsp";
			}
			
			return "redirect:/usuarios/lista";
	    }
	    
	    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("usuario") Usuarios usuario, BindingResult result) {
	    	System.out.println("Update");
	        if (result.hasErrors()) {
	            return "/usuarios/editarUsuario.jsp";
	        } else {
	        	usuarioService.updateUsuario(usuario);
	            return "redirect:/usuarios/lista";
	        }
	    }

}
