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
import com.nttdata.services.VentasService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	VentasService ventaService;
	
	//desplegar inicialmente el jsp
			@RequestMapping("")
			public String ventas(@ModelAttribute("ventas") Ventas venta,
					Model model) {
				return "ventas.jsp";
			}
			
			//capturar la informacion del formulario
			@RequestMapping("/registro_ventas")
			public String registroVenta(@Valid @ModelAttribute("ventas") Ventas venta, BindingResult br, RedirectAttributes ra)
			{
				if(br.hasErrors()) {
					
					ra.addFlashAttribute("mensajeError", "Campos no validos");
					return "redirect:/ventas";
				}
				
				
				//System.out.println(venta.getNombreVendedor()+" "+venta.getTotalVenta());
				
				
				ventaService.insertarVenta(venta);
				
				return "redirect:/ventas/lista_ventas";
			}
			
			@RequestMapping("/lista_ventas")
			public String lista(Model model) {
				
				model.addAttribute("listaVentas", ventaService.listarVentas());
				return "venta/listaVentas.jsp";
			}
			
			@RequestMapping("/eliminar")
			public String eliminarVenta(@RequestParam("id") Long id) {
				
				Ventas venta = ventaService.buscarVentaId(id);
				
				if(venta !=null) {
					ventaService.eliminarVentaObjeto(venta);
				}
				
				return "redirect:/ventas/lista_ventas";
			}
			
			@RequestMapping("/{id}/editar")
		    public String edit(@PathVariable("id") Long id, Model model) {
		    	System.out.println("editar");
		    	Ventas venta = ventaService.buscarVentaId(id);
		    	if(venta !=null) {
				       model.addAttribute("venta", venta);
				       return "editarVentas.jsp";
				}
				
				return "redirect:/ventas/lista_ventas";
		    }
		    
		    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
		    public String update(@Valid @ModelAttribute("ventas") Ventas venta, BindingResult result) {
		    	System.out.println("Update");
		        if (result.hasErrors()) {
		            return "/ventas/editarVentas.jsp";
		        } else {
		        	ventaService.updateVenta(venta);
		            return "redirect:/ventas/lista_ventas";
		        }
		    }
		    
			/*
			 * @RequestMapping(value="/agregar/{id}", method=RequestMethod.POST) public
			 * String agregar(@Valid @ModelAttribute("ventas") Ventas venta, BindingResult
			 * result) { System.out.println("Agregar"); if (result.hasErrors()) { return
			 * "/ventas/ventas.jsp"; } else { ventaService.insertarVenta(venta); return
			 * "redirect:/ventas/lista_ventas"; } }
			 */
			
			
}
