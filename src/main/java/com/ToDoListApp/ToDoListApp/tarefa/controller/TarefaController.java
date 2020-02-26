package com.ToDoListApp.ToDoListApp.tarefa.controller;

import com.ToDoListApp.ToDoListApp.tarefa.Tarefa;
import com.ToDoListApp.ToDoListApp.tarefa.service.TarefaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaServices tarefaServices;

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(@Valid @RequestParam Long idLista){
        List<Tarefa> tarefas = tarefaServices.findAll(idLista);
        return ResponseEntity.ok().body(tarefas);
    }

    @PutMapping(path = "/salvar")
    public ResponseEntity<Void> save(@Valid @RequestBody Tarefa tarefa, @Valid @RequestParam Long idLista){
        tarefaServices.save(tarefa, idLista);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/deletar")
    public ResponseEntity<Void> delete(@Valid @RequestParam (value = "id") Long id){
        Tarefa tarefa = tarefaServices.findById(id);
        tarefaServices.delete(tarefa);
        return ResponseEntity.noContent().build();
    }
}
