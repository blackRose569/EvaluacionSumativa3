package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Categoria;
import com.nttdata.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired CategoriaRepository categoriaRepository;

	public List<Categoria> listarCategorias() {
		
		return (List<Categoria>) categoriaRepository.findAll();
	}

	public void insertarCategoria(@Valid Categoria categoria) {
		
		categoriaRepository.save(categoria);
		
	}
}
