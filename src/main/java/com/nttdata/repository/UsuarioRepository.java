package com.nttdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuarios;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuarios, Long>{

	
	Usuarios findByEmail(String email);
	Usuarios findByNombre(String nombre);
	
	List<Usuarios>findAll();
}
