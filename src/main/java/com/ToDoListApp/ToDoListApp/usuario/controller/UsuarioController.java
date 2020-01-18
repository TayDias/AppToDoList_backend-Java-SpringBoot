package com.ToDoListApp.ToDoListApp.usuario.controller;

import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import com.ToDoListApp.ToDoListApp.usuario.service.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value ="/usuario")
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    @Autowired
    public UsuarioController(UsuarioServices usuarioServices){
        this.usuarioServices = usuarioServices;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> users = usuarioServices.getAll();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<String> save(@Valid @RequestBody Usuario usuario){
        usuarioServices.save(usuario);
        return new ResponseEntity<>("Salvo com sucesso", HttpStatus.OK);
    }
}
