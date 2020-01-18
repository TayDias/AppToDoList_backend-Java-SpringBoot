package com.ToDoListApp.ToDoListApp.usuario.service;

import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import com.ToDoListApp.ToDoListApp.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServices(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public void save(Usuario usuario){
        if(!verificaUsernameExistente(usuario.getUsuario())){
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuarioRepository.save(usuario);
        }
    }

    public String getLogged(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public Usuario getUser(String usuarioLogado){
        //return usuarioRepository.findByUsername(usuarioLogado).orElseThrow(() -> null);
        return null;
    }

    public boolean verificaUsernameExistente(String username){
        List<Usuario> listU = usuarioRepository.findAll();

        for(Usuario u: listU){
            if (u.getUsuario().equals(username)){
                return true;
            }
        }

        return false;
    }
}
