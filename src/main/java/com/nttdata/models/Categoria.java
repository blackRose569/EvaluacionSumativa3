package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	@Size(min = 3, max = 15)
	private String nombre;
	@Size(min = 3, max = 15)
	private String descripcion;
	
	

	//relacion many to many
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name="categorias_productos",//tabla intermedia
			joinColumns = @JoinColumn(name="categoria_id"),
			inverseJoinColumns = @JoinColumn(name="producto_id")
		)
		private List<Productos> productos;
	
	public Categoria() {
		super();
	}

	public Categoria(Long id, String nombre, String descripcion, List<Productos> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	

}
