package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired RoleRepository roleRepository;

	public List<Role> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return roleRepository.findByNombre(nombre);
	}
	
	
}
