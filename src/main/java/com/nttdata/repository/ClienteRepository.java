package com.nttdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Cliente;

@Repository
public interface ClienteRepository extends  CrudRepository<Cliente, Long> {

}
