package com.nttdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Ventas;

@Repository
public interface VentasRepository extends CrudRepository<Ventas,Long> {

}
