package com.ToDoListApp.ToDoListApp.participante.repository;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    public List<Participante> findByLista(Lista lista);

    public Participante findByUsuario(Usuario usuario);
}
