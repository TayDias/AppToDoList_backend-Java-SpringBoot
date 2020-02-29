package com.ToDoListApp.ToDoListApp.tarefa;

import com.ToDoListApp.ToDoListApp.enums.Status;
import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String detalhes;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "responsavel_id", referencedColumnName = "id")
    private Participante participante;

    public Tarefa(){}

    public Tarefa(String nome, String detalhes, Status status){
        this.nome = nome;
        this.detalhes = detalhes;
        this.status = status;
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

    public String getStatus() {
        return status.getDescricao();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
