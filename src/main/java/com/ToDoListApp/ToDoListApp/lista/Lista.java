package com.ToDoListApp.ToDoListApp.lista;

import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.ToDoListApp.ToDoListApp.tarefa.Tarefa;
import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity (name = "LISTA")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean publica;

    @JsonIgnore
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "lista")
    private List<Tarefa> tarefas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "lista")
    private List<Participante> participantes;

    public Lista(){
    }

    public Lista(String nome, boolean publica){
        this.nome = nome;
        this.publica = publica;
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

    public boolean isPublica() {
        return publica;
    }

    public void setPublica(boolean publica) {
        this.publica = publica;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void addParticipante(Participante p){
        participantes.add(p);
    }

    public void removeParticipante(Participante p){
        participantes.remove(p);
    }

}
