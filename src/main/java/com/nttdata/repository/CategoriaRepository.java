package com.nttdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {


}
