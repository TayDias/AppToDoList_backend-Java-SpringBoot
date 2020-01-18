package com.ToDoListApp.ToDoListApp.tarefa;

import com.ToDoListApp.ToDoListApp.enums.Status;
import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String detalhes;
    private int status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    public Tarefa(){}

    public Tarefa(String nome, String detalhes, Status status){
        this.nome = nome;
        this.detalhes = detalhes;
        this.status = (status == null) ? null : status.getCodigo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
