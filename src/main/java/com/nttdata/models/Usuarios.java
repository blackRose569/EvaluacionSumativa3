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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuarios {
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	
	@Size(min = 3, max = 15)
	private String nombre;
	@Size(min = 3, max = 15)
	private String apellido;
	@Size(min = 9, max = 13)
	private int telefono;
	@Size(min = 4, max = 25)
	private String email;
	@Size(min = 5, max = 25)
	private String password;
	@Size(min = 5, max = 25)
	@Transient
	private String confirmPassword;
	
	//relacion many to many
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	name="roles_usuarios",//tabla intermedia
	joinColumns = @JoinColumn(name="usuario_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;
	
	
	
	public Usuarios() {
		super();
	}
	


	public Usuarios(Long id, String nombre, String apellido, int telefono, String email, String password,
			String confirmPassword, List<Role> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.roles = roles;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getConfirmPassword() {
		return confirmPassword;
	}




	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
