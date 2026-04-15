package com.jara.antonio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jara.antonio.model.Evento;
import com.jara.antonio.repository.EventoRepository;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> readAll(){
        return eventoRepository.obtenerEventos();
    }
    
    public Evento create(Evento evento){
        if (eventoRepository.obtenerPorId(evento.getId()) != null) {
        throw new RuntimeException("El ID " + evento.getId() + " ya está en uso.");
        }
        return eventoRepository.guardarEvento(evento);
    }
    
    public Evento readById(Integer id){
        return eventoRepository.obtenerPorId(id);
    }

    public Evento eventoUpdate(Integer id, Evento evento){
        return eventoRepository.actualizar(id, evento);
    }
    
    public boolean delete(Integer id){
        return eventoRepository.eliminar(id);
    }

    public List<Evento> readByType(String tipo){
        return eventoRepository.buscarPorTipo(tipo);
    }
}
