package com.ToDoListApp.ToDoListApp.lista.controller;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.lista.service.ListaServices;
import com.ToDoListApp.ToDoListApp.participante.service.ParticipanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/lista")
public class ListaController {

    @Autowired
    private ListaServices listaServices;

    @Autowired
    private ParticipanteServices participanteServices;

    @GetMapping
    public ResponseEntity<List<Lista>> findAll(@Valid @RequestParam Long idUser){
        List<Lista> listas = listaServices.findAll(idUser);
        return ResponseEntity.ok().body(listas);
    }

    @PutMapping(path = "/salvar")
    public ResponseEntity<String> save(@Valid @RequestBody Lista lista, @Valid @RequestParam Long idUser){
        listaServices.save(lista,idUser);
        return new ResponseEntity<>("Lista salva com sucesso", HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletar")
    public ResponseEntity<String> delete(@Valid @RequestParam(value = "id") Long id){
        Lista lista = listaServices.findById(id);
        listaServices.delete(lista);
        return new ResponseEntity<>("Lista deletada", HttpStatus.OK);
    }

    @PostMapping(path = "/altStatus")
    public ResponseEntity<String> changeStatus(@Valid @RequestParam(value = "id") Long id){
        Lista lista = listaServices.findById(id);
        participanteServices.removeTodosParticipantes(lista);
        listaServices.changeStatus(lista);
        participanteServices.addProprietario(lista);
        return new ResponseEntity<>("Status alterado para "+ lista.isPublica(), HttpStatus.OK);
    }
}
