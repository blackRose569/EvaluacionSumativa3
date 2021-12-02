package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.models.Usuarios;
import com.nttdata.repository.UsuarioRepository;


@Service
public class UsuarioDetailsServiceImplementation implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRepository.findByNombre(nombre);
        
        System.out.println(usuario);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario not found");
        }
        
        return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getPassword(), getAuthorities(usuario));
    }
    
    
    private List<GrantedAuthority> getAuthorities(Usuarios Usuario){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                for(Role role : Usuario.getRoles()) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getNombre());
                    authorities.add(grantedAuthority);
                }
                return authorities;
        }
}