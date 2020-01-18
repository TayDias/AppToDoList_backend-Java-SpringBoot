package com.ToDoListApp.ToDoListApp.tarefa.repository;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    //Exemplo metodo buscar por algum dado
    //public Tarefa findByNome(String nome);

    public List<Tarefa> findByLista(Lista lista);
}
