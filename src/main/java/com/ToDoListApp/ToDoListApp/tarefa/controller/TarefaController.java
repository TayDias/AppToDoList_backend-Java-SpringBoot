package com.ToDoListApp.ToDoListApp.tarefa.controller;

import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.ToDoListApp.ToDoListApp.participante.service.ParticipanteServices;
import com.ToDoListApp.ToDoListApp.tarefa.Tarefa;
import com.ToDoListApp.ToDoListApp.tarefa.service.TarefaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaServices tarefaServices;

    @Autowired
    private ParticipanteServices participanteServices;

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(@Valid @RequestParam Long idLista){
        List<Tarefa> tarefas = tarefaServices.findAll(idLista);
        return ResponseEntity.ok().body(tarefas);
    }

    @PutMapping(path = "/salvar")
    public ResponseEntity<String> save(@Valid @RequestBody Tarefa tarefa, @Valid @RequestParam Long idLista){
        tarefaServices.save(tarefa, idLista);
        return new ResponseEntity<>("Tarefa salva com sucesso", HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletar")
    public ResponseEntity<String> delete(@Valid @RequestParam (value = "id") Long id){
        Tarefa tarefa = tarefaServices.findById(id);
        tarefaServices.delete(tarefa);
        return new ResponseEntity<>("Tarefa deletada", HttpStatus.OK);
    }

    @PostMapping(path = "/assumir")
    public ResponseEntity<String> assumir(@Valid @RequestParam (value = "id") Long idT, @Valid @RequestParam Long idP){
        Tarefa tarefa = tarefaServices.findById(idT);
        Participante participante = participanteServices.findById(idP);
        tarefaServices.assumirTarefa(tarefa,participante);
        return new ResponseEntity<>("Tarefa assumida", HttpStatus.OK);
    }
}
