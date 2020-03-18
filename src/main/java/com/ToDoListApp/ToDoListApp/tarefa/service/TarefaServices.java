package com.ToDoListApp.ToDoListApp.tarefa.service;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.lista.repository.ListaRepository;
import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.ToDoListApp.ToDoListApp.tarefa.Tarefa;
import com.ToDoListApp.ToDoListApp.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServices {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ListaRepository listaRepository;

    public List<Tarefa> findAll(Long id){
        Lista lista = listaRepository.findById(id).get();
        return tarefaRepository.findByLista(lista);
    }

    public void save(Tarefa tarefa, Long idLista){
        Lista lista = listaRepository.findById(idLista).get();
        tarefa.setLista(lista);
        tarefaRepository.save(tarefa);
    }

    public void delete(Tarefa tarefa){
        tarefaRepository.delete(tarefa);
    }

    public void assumirTarefa(Tarefa tarefa, Participante p){
        if(tarefa.getParticipante() == null){
            tarefa.setParticipante(p);
            tarefaRepository.save(tarefa);
        }
        else{
            if(tarefa.getParticipante().getId() == p.getId()){
                tarefa.setParticipante(null);
                tarefaRepository.save(tarefa);
            }
            else {
                throw new IllegalArgumentException("Tarefa ja assumida por outro usuário.");
            }
        }
    }

    public Tarefa findById(Long id){
        return tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não existe tarefa com esse id"));
    }
}
