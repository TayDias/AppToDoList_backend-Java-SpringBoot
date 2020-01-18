package com.ToDoListApp.ToDoListApp.participante.controller;

import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.ToDoListApp.ToDoListApp.participante.service.ParticipanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/part")
public class ParticipanteController {

    @Autowired
    private ParticipanteServices participanteService;

    @GetMapping
    public ResponseEntity<List<Participante>> findAll(@Valid @RequestParam Long idLista){
        List<Participante> participantes = participanteService.findAll(idLista);
        return  ResponseEntity.ok().body(participantes);
    }

    @PutMapping(path = "/adicionar")
    public ResponseEntity<Void> save(@Valid @RequestParam Long idUser, @Valid @RequestParam Long idLista){
        participanteService.save(idUser,idLista);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/remover")
    public ResponseEntity<Void> delete(@Valid @RequestParam(value = "id")Long idPart){
        Participante participante = participanteService.findById(idPart);
        participanteService.delete(participante);
        return ResponseEntity.noContent().build();
    }
}
