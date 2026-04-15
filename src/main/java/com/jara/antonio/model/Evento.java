package com.jara.antonio.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @NotNull(message = "El ID del evento no puede ser nulo.")
    // cambio de int al wrapper Integer para hacer uso de la validacion @NotNull
    private Integer id;
    @NotBlank(message = "El nombre no puede ser vacío.")
    private String nombre;
    @NotBlank(message = "El tipo no puede ser vacío.")
    private String tipo;
    @NotNull(message = "La fecha no puede ser vacía.")
    private String fecha;
    @NotBlank(message = "La ubicación no puede ser vacía.")
    private String ubicacion;
    @NotNull(message = "La capacidad no puede ser nula.")
    private Integer capacidad;
}