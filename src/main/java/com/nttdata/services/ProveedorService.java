package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proveedor;
import com.nttdata.repository.ProveedorRepository;

@Service
public class ProveedorService {

	@Autowired ProveedorRepository proveedorRepository;

	public List<Proveedor> listarProveedores() {
		// TODO Auto-generated method stub
		return (List<Proveedor>) proveedorRepository.findAll() ;
	}

	public void insertarProveedor(@Valid Proveedor proveedor) {
		proveedorRepository.save(proveedor);
		
	}

	public Proveedor buscarProveedorId(Long id) {
		
		return proveedorRepository.findById(id).get();
	}

	public void eliminarProveedorObjeto(Proveedor proveedor) {
		
		proveedorRepository.delete(proveedor);
		
	}

	public void updateProveedor(@Valid Proveedor proveedor) {
		
		if(proveedorRepository.existsById(proveedor.getId())){
			proveedorRepository.save(proveedor);
		}
		
	}
	
	
}
