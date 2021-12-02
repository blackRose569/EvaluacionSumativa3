package com.nttdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {

}
