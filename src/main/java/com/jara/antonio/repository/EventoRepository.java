package com.jara.antonio.repository;
import com.jara.antonio.model.Evento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventoRepository {
    private List<Evento> listaEventos = new ArrayList <>();

    public List<Evento> obtenerEventos() {
        return listaEventos;
    }

    public Evento guardarEvento(Evento evento) {
        listaEventos.add(evento);
        return evento;
    }

    public Evento obtenerPorId(int id){
        for (Evento evento : listaEventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }
}  
