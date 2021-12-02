package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Cliente;
import com.nttdata.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired ClienteRepository clienteRepository;

	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteRepository.findAll() ;
	}

	public void insertarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	public Cliente buscarClienteId(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).get();
	}

	public void eliminarClienteObjeto(Cliente cliente) {
		
		clienteRepository.delete(cliente);
		
	}

	public void updateCliente(@Valid Cliente cliente) {
		
		if(clienteRepository.existsById(cliente.getId())){
			clienteRepository.save(cliente);
		}
		
	}
}
