package com.votacion.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CandidatoDto {
    private  Long id;

    @NotNull
    @Size(max = 50, message = "nombre no puede tener mas de 50 caracteres")
    @Size(min = 5, message = "nombre no puede tener menos de 5 caracteres")
    private String nombre;

    @NotNull
    @Size(max = 10, message = "telefono no puede tener mas de 10 caracteres")
    @Size(min = 8, message = "telefono no puede tener menos de 8 caracteres")
    private String telefono;

    @NotNull
    @Size(max = 10, message = "cedeula no puede tener mas de 10 caracteres")
    @Size(min = 8, message = "cedula no puede tener menos de 9 caracteres")
    private String cedula;

    @NotNull
    @Size(max = 20, message = "cargo no puede tener mas de 20 caracteres")
    @Size(min = 5, message = "cargo no puede tener menos de 5 caracteres")
    private String cargo;
}
