package com.ToDoListApp.ToDoListApp.participante;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.tarefa.Tarefa;
import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity (name = "PARTICIPANTE")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    @JsonIgnore
    @OneToOne (mappedBy = "participante")
    private Tarefa tarefa;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Participante(Lista lista, Usuario usuario){
        this.lista = lista;
        this.usuario = usuario;
    }

    public Participante(){
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
