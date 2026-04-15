package com.jara.antonio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jara.antonio.model.Evento;
import com.jara.antonio.service.EventoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getEventos() {
        return ResponseEntity.ok(eventoService.readAll());
    }
    
    @PostMapping
    public ResponseEntity<?> postEvento(@Valid @RequestBody Evento evento) {
        Evento nuevoEvento = eventoService.create(evento);
        if (nuevoEvento != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEvento);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear nuevo evento");
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getEventoReadById(@PathVariable Integer id){
        Evento evento = eventoService.readById(id);
        if (evento != null) {
            return ResponseEntity.ok(evento);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento no encontrado");
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putEvento(@PathVariable Integer id, @Valid @RequestBody Evento evento){
        Evento eventoActualizado = eventoService.eventoUpdate(id, evento);
        if (eventoActualizado != null) {
            return ResponseEntity.ok(eventoActualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento no encontrado");
    }
    
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> deleteEvento(@PathVariable Integer id){
        boolean eliminado = eventoService.delete(id);
        if (eliminado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento no encontrado");
    }

    //operacion de transformación
    @GetMapping("tipo/{tipo}")
    public ResponseEntity<?> getEventosByType(@PathVariable String tipo) {
        List<Evento> filtrados = eventoService.readByType(tipo);
        if (!filtrados.isEmpty()){
            return ResponseEntity.ok(filtrados);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay eventos de ese tipo :(");
    }
    
    
}
