//package com.ToDoListApp.ToDoListApp.proprietario;
//
//import com.ToDoListApp.ToDoListApp.lista.Lista;
//import com.ToDoListApp.ToDoListApp.usuario.Usuario;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//
//@Entity (name = "PROPRIETARIO")
//public class Proprietario extends Usuario {
//
//    @Id
//    private Long id;
//
//    @JsonIgnore
//    @OneToOne(mappedBy = "proprietario")
//    private Lista lista;
//
//    public Proprietario(){
//        id = super.getId();
//    }
//
//    public Lista getLista() {
//        return lista;
//    }
//
//    public void setLista(Lista lista) {
//        this.lista = lista;
//    }
//}
