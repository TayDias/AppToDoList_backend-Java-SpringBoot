package com.ToDoListApp.ToDoListApp.participante.service;

import com.ToDoListApp.ToDoListApp.lista.Lista;
import com.ToDoListApp.ToDoListApp.lista.repository.ListaRepository;
import com.ToDoListApp.ToDoListApp.participante.Participante;
import com.ToDoListApp.ToDoListApp.participante.repository.ParticipanteRepository;
import com.ToDoListApp.ToDoListApp.usuario.Usuario;
import com.ToDoListApp.ToDoListApp.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteServices {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Participante> findAll(Long idLista){
        Lista lista = listaRepository.findById(idLista).get();
        List<Participante> participantes = removeProprietario(participanteRepository.findByLista(lista));
        return participantes;
    }

    public void save(Long idUser, Long idLista){
        Lista lista = listaRepository.findById(idLista).get();

        if(lista.isPublica()){
            if(verificaParticipanteRepetido(lista, idUser)){
                Usuario usuario = usuarioRepository.findById(idUser).get();
                Participante p = new Participante(lista, usuario);
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
            if (p.getUsuario().getId() == idUser){
                return false;
            }
        }
        return true;
    }

    public void addProprietario(Lista lista){
        if(lista.isPublica()){
            save(lista.getId(),lista.getUsuario().getId());
        }
    }

    public void removeTodosParticipantes(Lista lista){
        if(lista.isPublica()){
            List<Participante> participantes = participanteRepository.findByLista(lista);
            for (Participante p: participantes){
                delete(p);
            }
        }
    }

    public List<Participante> removeProprietario(List<Participante> participantes){
        for(Participante p: participantes){
            participantes.remove(p);
            break;
        }
        return participantes;
    }
}
