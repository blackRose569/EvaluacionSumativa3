package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.models.Usuarios;
import com.nttdata.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired 
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bcpe;
	

	public Usuarios findByEmail(String email) {
		System.out.println(usuarioRepository.findByEmail(email).getEmail());
		return usuarioRepository.findByEmail(email);
	}
	
	public Usuarios findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}
	
	//insertar usuario
	public Usuarios persistirUsuarioRol(Usuarios usuario) {
		usuario.setPassword(bcpe.encode(usuario.getPassword()));
		usuario.setRoles(roleService.findByNombre("ROLE_USER"));
		/*Role role = roleService.getListRole("ROLE_USER");
		List<Role> roles = new ArrayList<>();
		roles.add(role);*/
		return usuarioRepository.save(usuario);
				
	}
	
	
	public Usuarios registroUsuario(Usuarios usuario) {
		String password_hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(password_hashed);
		return usuarioRepository.save(usuario);
	}
	
	
	
	public void insertarUsuario(@Valid Usuarios usuario) {
		
		usuarioRepository.save(usuario);
	}

//lista registros de la BD
	public List<Usuarios> listarUsuarios(){
		
		return (List<Usuarios>) usuarioRepository.findAll(); 
	}

	public Usuarios buscarUsuarioId(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuariosObjeto(Usuarios usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.delete(usuario);
	}

	public void updateUsuario(@Valid Usuarios usuario) {
		
		if(usuarioRepository.existsById(usuario.getId())){
			usuarioRepository.save(usuario);
		}
		
	}
	
	public boolean loginUsuario(String email, String password) {

		Usuarios usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {
			return false;
		} else {
			// if(password.equals(usuario.getPassword())) {
			if (BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}


}
