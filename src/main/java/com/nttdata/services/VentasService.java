package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Ventas;
import com.nttdata.repository.VentasRepository;

@Service
public class VentasService {
	@Autowired
	VentasRepository ventasRepository;

	public void insertarVenta(@Valid Ventas venta) {
		// TODO Auto-generated method stub
		ventasRepository.save(venta);
	}

	public List<Ventas> listarVentas() {
		
		return (List<Ventas>) ventasRepository.findAll();
	}

	public Ventas buscarVentaId(Long id) {
		// TODO Auto-generated method stub
		return ventasRepository.findById(id).get();
	}

	public void eliminarVentaObjeto(Ventas venta) {
		
		ventasRepository.delete(venta);
		
	}

	public void updateVenta(@Valid Ventas venta) {
		if(ventasRepository.existsById(venta.getId())){
			ventasRepository.save(venta);
		}
		
	}
}
