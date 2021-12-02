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

import com.nttdata.models.Productos;
import com.nttdata.models.Proveedor;
import com.nttdata.services.ClienteService;
import com.nttdata.services.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

	@Autowired ProveedorService proveedorService;
	@Autowired ClienteService clienteService;
	
	//desplegar inicialmente el jsp
			@RequestMapping("")
			public String proveedor(@ModelAttribute("proveedor") Proveedor proveedor,
					Model model) {
				model.addAttribute("proveedor",  proveedor);
				model.addAttribute("listaProveedores", proveedorService.listarProveedores());
				model.addAttribute("listaClientes", clienteService.listarClientes());
				return "proveedor/proveedor.jsp";
			}
			
			//capturar la informacion del formulario
					@RequestMapping("/crear")
					
					public String login(@Valid @ModelAttribute("proveedor") Proveedor proveedor)
					{
						System.out.println(proveedor.getNombre()+" "+proveedor.getApellido()+" "+proveedor.getEmail()+" "+proveedor.getEdad());
						
						proveedorService.insertarProveedor(proveedor);
						
						return "redirect:/proveedores/lista_proveedores";
					}
					
					@RequestMapping("/lista_proveedores")
					public String lista(Model model) {
						System.out.println(proveedorService.listarProveedores());
						model.addAttribute("listaProveedores", proveedorService.listarProveedores());
						return "proveedor/listaProveedores.jsp";
					}
					
					@RequestMapping("/eliminar")
					public String eliminarProveedor(@RequestParam("id") Long id) {
						
						Proveedor proveedor = proveedorService.buscarProveedorId(id);
						
						if(proveedor !=null) {
							proveedorService.eliminarProveedorObjeto(proveedor);
						}
						
						return "redirect:/proveedor/lista_proveedores";
					}
					
					@RequestMapping("/{id}/editar")
				    public String edit(@PathVariable("id") Long id, Model model) {
				    	System.out.println("editar");
				    	Proveedor proveedor = proveedorService.buscarProveedorId(id);
				    	model.addAttribute("listaClientes", clienteService.listarClientes());
				    	if(proveedor !=null) {
						       model.addAttribute("proveedor", proveedor);
						       return "proveedor/editarProveedor.jsp";
						}
						
						return "redirect:/proveedor/lista_proveedores";
				    }
				    
				    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
				    public String update(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult result) {
				    	System.out.println("Update");
				        if (result.hasErrors()) {
				            return "/proveedor/editarProveedor.jsp";
				        } else {
				        	proveedorService.updateProveedor(proveedor);
				            return "redirect:/proveedores/lista_proveedores";
				        }
				    }
	
	
}
