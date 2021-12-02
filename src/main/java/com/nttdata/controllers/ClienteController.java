package com.nttdata.controllers;

import java.util.List;

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

import com.nttdata.models.Cliente;
import com.nttdata.models.Proveedor;
import com.nttdata.models.Ventas;
import com.nttdata.services.ClienteService;
import com.nttdata.services.ProveedorService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	
@Autowired ClienteService clienteService;
	
	@Autowired ProveedorService proveedorService;
	
	
	//desplegar inicialmente el jsp
		@RequestMapping("")
		public String cliente(@ModelAttribute("cliente") Cliente cliente,
				Model model) {
			List<Proveedor> listaProveedores = proveedorService.listarProveedores();
			List<Cliente> listaClientes = clienteService.listarClientes();
			model.addAttribute("listaClientes", clienteService.listarClientes());
			model.addAttribute("cliente", cliente);
			model.addAttribute("listaClientes", listaClientes);
			
			if(listaClientes!=null) {
				for (Cliente clienteL : listaClientes) {
					
				}
			}
			
			model.addAttribute("listaProveedores", listaProveedores);
			return "cliente/cliente.jsp";
		}
		
		//capturar la informacion del formulario
				@RequestMapping("/crear")
				
				public String login(@Valid @ModelAttribute("cliente") Cliente cliente)
				{
					System.out.println(cliente.getRut()+" "+cliente.getNombre()+" "+cliente.getEdad()+" "+cliente.getSexo()+" "+cliente.getPlan()+" "+cliente.getCelular());
					
					clienteService.insertarCliente(cliente);
					
					return "redirect:/clientes/lista_clientes";
				}
				
				@RequestMapping("/lista_clientes")
				public String lista(Model model) {
					
					model.addAttribute("listaClientes", clienteService.listarClientes());
					return "cliente/listaClientes.jsp";
				}
				
				@RequestMapping("/eliminar")
				public String eliminarCliente(@RequestParam("id") Long id) {
					
					Cliente cliente = clienteService.buscarClienteId(id);
					
					if(cliente !=null) {
						clienteService.eliminarClienteObjeto(cliente);
					}
					
					return "redirect:/clientes/lista_clientes";
				}
				
				@RequestMapping("/{id}/editar")
			    public String edit(@PathVariable("id") Long id, Model model) {
			    	System.out.println("editar");
			    	Cliente cliente = clienteService.buscarClienteId(id);
			    	if(cliente !=null) {
					       model.addAttribute("cliente", cliente);
					       return "cliente/editarCliente.jsp";
					}
					
					return "redirect:/clientes/lista_clientes";
			    }
			    
			    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
			    public String update(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result) {
			    	System.out.println("Update");
			        if (result.hasErrors()) {
			            return "/clientes/editarCliente.jsp";
			        } else {
			        	clienteService.updateCliente(cliente);
			            return "redirect:/clientes/lista_clientes";
			        }
			    }
	
}
