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
@Table(name="ventas")
public class Ventas {
	
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;	
	private int cantidad;
	private float totalVenta;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="ventas_productos",//tabla intermedia
		joinColumns = @JoinColumn(name="venta_id"),
		inverseJoinColumns = @JoinColumn(name="producto_id")
	)
	List<Productos> productos;

	public Ventas() {
		super();
	}

	public Ventas(int cantidad, float totalVenta, List<Productos> productos) {
		super();
		this.cantidad = cantidad;
		this.totalVenta = totalVenta;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	
	
	
	
	
	
	
	
}
