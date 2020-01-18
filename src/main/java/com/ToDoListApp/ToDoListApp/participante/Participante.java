package com.ToDoListApp.ToDoListApp.participante;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity (name = "PARTICIPANTE")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    public Participante(){
    }

    public Participante(Long usuarioId){
        this.usuarioId = usuarioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

}
