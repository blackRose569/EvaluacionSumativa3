package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Categoria;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired CategoriaService categoriaService;
	@Autowired ProductoService productoService;
	
	@RequestMapping("")
	public String categiria(@ModelAttribute("categoria") Categoria categoria,
			Model model) {
		model.addAttribute("categoria",  categoria);
		model.addAttribute("listaCategorias", categoriaService.listarCategorias());
		model.addAttribute("listaProductos", productoService.listarProductos());
		return "categoria/categoria.jsp";
	}
	
	@RequestMapping("/crear")
	
	public String login(@Valid @ModelAttribute("categoria") Categoria categoria)
	{
		System.out.println(categoria.getNombre()+" "+categoria.getDescripcion());
		
		categoriaService.insertarCategoria(categoria);
		
		return "redirect:/categorias/lista_categorias";
	}
	
	@RequestMapping("/lista_categorias")
	public String lista(Model model) {
		
		model.addAttribute("listaCategorias", categoriaService.listarCategorias());
		return "categoria/listaCategorias.jsp";
	}
	
	
}
