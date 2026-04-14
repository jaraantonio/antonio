package com.jara.antonio.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @NotNull(message = "El ID del evento no puede estar vacío.")
    private int id;
    @NotBlank(message = "El nombre del evento no puede estar vacío.")
    private String nombre;
    private String tipo;
    @NotNull(message = "La fecha del evento no puede estar vacía.")
    private LocalDate fecha;
    @NotBlank(message = "La ubicación del evento no puede estar vacía.")
    private String ubicacion;
    private int asistentes;
}