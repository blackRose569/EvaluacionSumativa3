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

@Entity
@Table(name = "roles")
public class Role {

	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	private String nombre;
	
	//relacion many to many
			@ManyToMany(mappedBy = "roles")
			private List<Usuarios> usuarios;
			
	
	public Role() {
		super();
	}


	public Role(Long id, String nombre, List<Usuarios> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
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


	public List<Usuarios> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
}
