package com.nttdata.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuarios;
import com.nttdata.services.UsuarioService;


@Controller
public class HomeController {

	
	/*@RequestMapping("/")
	//metodo inicial
	public String index() {
	
		return "Hola hola";
	}
	
	@RequestMapping("/index")
	//metodo inicial
	public String index2() {
	
		return "Hola hola 2";
	}*/
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		String nombre = (String) session.getAttribute("nombre_usuario");
		Long usuarioId= (Long) session.getAttribute("usuario_id");
		
		model.addAttribute("nombre_usuario", nombre);
		model.addAttribute("usuario_id", usuarioId);
		return "home.jsp";
	}
	
	//http://localhost:8080/login
	@RequestMapping("/login")
	public String login() {

	return "usuario/login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuarios usuario) {

		return "usuario/registro.jsp";
	}
	
	
	
}
