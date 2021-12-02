package com.nttdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Productos;

@Repository
public interface ProductoRepository extends CrudRepository<Productos, Long>{

}
