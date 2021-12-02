package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="productos")
public class Productos {
	
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	@Size(min = 3, max = 15)
	private String nombre;
	@Size(min = 3, max = 20)
	private String descripcion;
	@Size(min = 1, max = 15)
	private String precio;
	@Column(updatable = false)
	private Date createdAt;

	private Date updatedAt ;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="categorias_productos",//tabla intermedia
		joinColumns = @JoinColumn(name="producto_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id")
	)
	
	private List<Categoria> categorias;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="ventas_productos",//tabla intermedia
		joinColumns = @JoinColumn(name="producto_id"),
		inverseJoinColumns = @JoinColumn(name="venta_id")
	)
	
	private List<Ventas> ventas;

	public Productos() {
		super();
	}

	public Productos(String nombre, String descripcion, String precio, List<Categoria> categorias,
			List<Ventas> ventas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categorias = categorias;
		this.ventas = ventas;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}
	
	

	

}
