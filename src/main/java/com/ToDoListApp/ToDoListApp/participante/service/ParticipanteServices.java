package com.ToDoListApp.ToDoListApp.participante.service;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.lista.repository.ListaRepository;
import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.ToDoListApp.ToDoListApp.participante.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteServices {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private ListaRepository listaRepository;

    public List<Participante> findAll(Long idLista){
        Lista lista = listaRepository.findById(idLista).get();
        return participanteRepository.findByLista(lista);
    }

    public void save(Long idUser, Long idLista){
        Lista lista = listaRepository.findById(idLista).get();
        if(lista.isPublica()){
            if(verificaParticipanteRepetido(lista, idUser)){
                Participante p = new Participante(idUser);
                p.setLista(lista);
                lista.addParticipante(p);
                participanteRepository.save(p);
            }
            else{
                throw new IllegalArgumentException("Esse usuário ja participa dessa lista.");
            }
        }
        else{
            throw new IllegalArgumentException("Não é permitido adicionar participantes em listas privadas.");
        }
    }

    public void delete(Participante participante){
        participanteRepository.delete(participante);
    }

    public Participante findById(Long id){
        return participanteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não existe participante com esse Id"));
    }

    public boolean verificaParticipanteRepetido(Lista lista, Long idUser){
        List<Participante> listP = participanteRepository.findByLista(lista);
        for(Participante p: listP){
            if (p.getUsuarioId() == idUser){
                return false;
            }
        }
        return true;
    }
}
