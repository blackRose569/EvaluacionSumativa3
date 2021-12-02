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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente {
	
	//atributos
		@Id //clave primaria o PK
		@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
		private Long id;
		
		private String rut;
		@Size(min = 3, max = 15)
		private String nombre; 
		@Size(min = 3)
		private Integer edad; 
		@Size(min = 1, max = 7)
		private String sexo;
		private Boolean plan;
		@Size(min = 3, max = 15)
		private String celular;
		@Column(updatable = false)
		private Date createdAt;
		private Date updatedAt;

		
		//relacion many to many
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name="clientes_proveedores",//tabla intermedia
			joinColumns = @JoinColumn(name="cliente_id"),
			inverseJoinColumns = @JoinColumn(name="proveedor_id")
		)
		private List<Proveedor> proveedores;

		
		public Cliente() {
			super();
		}
		
		public List<Proveedor> getProveedores() {
			return proveedores;
		}

		public void setProveedores(List<Proveedor> proveedores) {
			this.proveedores = proveedores;
		}
		
		public Cliente(String rut, String nombre, Integer edad, String sexo, Boolean plan, String celular) {
			super();
			this.rut = rut;
			this.nombre = nombre;
			this.edad = edad;
			this.sexo = sexo;
			this.plan = plan;
			this.celular = celular;
		}
		
		@Override
		public String toString() {
			return "Cliente [rut=" + rut + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", plan=" + plan
					+ ", celular=" + celular + "]";
		}
		
		public String getRut() {
			return rut;
		}
		public void setRut(String rut) {
			this.rut = rut;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Integer getEdad() {
			return edad;
		}
		public void setEdad(Integer edad) {
			this.edad = edad;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public Boolean getPlan() {
			return plan;
		}
		public void setPlan(Boolean plan) {
			this.plan = plan;
		}
		public String getCelular() {
			return celular;
		}
		public void setCelular(String celular) {
			this.celular = celular;
		}
		
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

}
