package com.nttdata.controllers;


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

import com.nttdata.models.Productos;
import com.nttdata.models.Ventas;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;
import com.nttdata.services.VentasService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	ProductoService productosService;
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired 
	VentasService ventaService;
	
	//desplegar inicialmente el jsp
		@RequestMapping("")
		public String productos(@ModelAttribute("productos") Productos producto,
				Model model) {
			model.addAttribute("listaCategorias", categoriaService.listarCategorias());
			return "producto/productos.jsp";
		}
		
		//capturar la informacion del formulario
		@RequestMapping("/crear")
		
		public String registroProducto(@Valid @ModelAttribute("productos") Productos producto, BindingResult br, RedirectAttributes ra)
		{
			if(br.hasErrors()) {
				
				ra.addFlashAttribute("mensajeError", "Campos no validos");
				return "redirect:/productos";
			}
			
			
			System.out.println(producto.getNombre()+" "+producto.getCategorias()+" "+producto.getPrecio());
			
			
			productosService.insertarProducto(producto);
			
			return "redirect:/productos/lista_productos";
		}
		
		@RequestMapping("/lista_productos")
		public String lista(Model model) {
			
			model.addAttribute("listaProductos", productosService.listarProductos());
			return "producto/listarProductos.jsp";
		}
		
		@RequestMapping("/eliminar")
		public String eliminarProducto(@RequestParam("id") Long id) {
			
			Productos producto = productosService.buscarProductoId(id);
			
			if(producto !=null) {
				productosService.eliminarProductosObjeto(producto);
			}
			
			return "redirect:/productos/lista_productos";
		}
		
		@RequestMapping("/{id}/editar")
	    public String edit(@PathVariable("id") Long id, Model model) {
	    	System.out.println("editar");
	    	Productos producto = productosService.buscarProductoId(id);
	    	if(producto !=null) {
			       model.addAttribute("producto", producto);
			       return "editarProductos.jsp";
			}
			
			return "redirect:/productos/lista_productos";
	    }
	    
	    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("producto") Productos producto, BindingResult result) {
	    	System.out.println("Update");
	        if (result.hasErrors()) {
	            return "/productos/editarProductos.jsp";
	        } else {
	        	productosService.updateProducto(producto);
	            return "redirect:/productos/lista_productos";
	        }
	    }
	    
	    @RequestMapping(value="/agregar", method=RequestMethod.POST)
	    public String agregar(@Valid @ModelAttribute("ventas") Ventas venta, Model model, BindingResult result) {
	    	System.out.println("Agregar");
			
	    	model.addAttribute("listaProductos", productosService.listarProductos());
	    	ventaService.insertarVenta(venta);
	    	return "redirect:/ventas/lista_ventas";
	    }
}
