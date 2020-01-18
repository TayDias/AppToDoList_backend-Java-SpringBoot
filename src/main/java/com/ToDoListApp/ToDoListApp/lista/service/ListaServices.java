package com.ToDoListApp.ToDoListApp.lista.service;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.lista.repository.ListaRepository;
import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import com.ToDoListApp.ToDoListApp.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaServices {

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Lista> findAll(Long idUser){
        Usuario usuario = usuarioRepository.findById(idUser).get();
        return listaRepository.findByUsuario(usuario);
    }

    public void save(Lista lista, Long idUser){
        Usuario usuario = usuarioRepository.findById(idUser).get();
        lista.setUsuario(usuario);
        listaRepository.save(lista);
    }

    public void delete(Lista lista){
        listaRepository.delete(lista);
    }

    public void changeStatus(Lista lista){
        lista.setPublica(!lista.isPublica());
        listaRepository.save(lista);
    }

    public Lista findById(Long id){
        return listaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não existe lista com esse id"));
    }
}
