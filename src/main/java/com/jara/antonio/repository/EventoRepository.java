package com.jara.antonio.repository;

import com.jara.antonio.model.Evento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventoRepository {
    private List<Evento> listaEventos = new ArrayList<>();

    public List<Evento> obtenerEventos() {
        return listaEventos;
    }

    public Evento guardarEvento(Evento evento) {
        listaEventos.add(evento);
        return evento;
    }

    public Evento obtenerPorId(int id) {
        for (Evento evento : listaEventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }

    public Evento actualizar(Integer id, Evento evento) {
        Evento buscado = obtenerPorId(id);
        if (buscado != null) {
            buscado.setNombre(evento.getNombre());
            buscado.setTipo(evento.getTipo());
            buscado.setFecha(evento.getFecha());
            buscado.setUbicacion(evento.getUbicacion());
            buscado.setCapacidad(evento.getCapacidad());
            return buscado;
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        return listaEventos.removeIf(e -> e.getId().equals(id));
    }

    // operacion de trasnformacion solicitada
    public List<Evento> buscarPorTipo(String tipo) {
        List<Evento> filtrados = new ArrayList<>();
        for (Evento evento : listaEventos) {
            if (evento.getTipo().equalsIgnoreCase(tipo)) {
                filtrados.add(evento);
            }
        }
        return filtrados;
    }
}
