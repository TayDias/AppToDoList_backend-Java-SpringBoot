package com.ToDoListApp.ToDoListApp.security.service;

import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import com.ToDoListApp.ToDoListApp.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsuario(username).orElseThrow(() ->
                new UsernameNotFoundException("User: " + username + " não encontrado"));
        return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getSenha(),
                Arrays.asList(new SimpleGrantedAuthority("user")));
    }
}
