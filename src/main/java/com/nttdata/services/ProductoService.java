package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Productos;
import com.nttdata.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;

	public void insertarProducto(@Valid Productos producto) {
		
		productoRepository.save(producto);
	}
	
	//lista registros de la BD
		public List<Productos> listarProductos(){
			
			return (List<Productos>) productoRepository.findAll(); 
		}

		public Productos buscarProductoId(Long id) {
			return productoRepository.findById(id).get();
			// TODO Auto-generated method stub
			
		}

		public void eliminarProductosObjeto(Productos producto) {
			 productoRepository.delete(producto);
			
		}

		public void updateProducto(@Valid Productos producto) {
			
			if(productoRepository.existsById(producto.getId())){
				productoRepository.save(producto);
			}
			
		}

		
}
