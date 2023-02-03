package com.votacion.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class VotanteDto {
    private  Long id;

    @NotNull
    @Size(max = 50, message = "nombre no puede tener mas de 50 caracteres")
    @Size(min = 5, message = "nombre no puede tener menos de 5 caracteres")
    private String nombre;

    @NotNull
    @Size(max = 10, message = "telefono no puede tener mas de 10 caracteres")
    @Size(min = 8, message = "telefono no puede tener menos de 8 caracteres")
    private String  telefono;

    @NotNull
    @Size(max = 10, message = "cedeula no puede tener mas de 10 caracteres")
    @Size(min = 8, message = "cedula no puede tener menos de 8 caracteres")
    private String cedula;

    @NotNull
    @Size(max = 30, message = "dieccion no puede tener mas de 30 caracteres")
    @Size(min = 5, message = "direccion no puede tener menos de 5 caracteres")
    private String direccion;

    @NotNull
    @Size(max = 15, message = "ciudad no puede tener mas de 15 caracteres")
    @Size(min = 4, message = "cedula no puede tener menos de 4 caracteres")
    private String ciudad;

    @NotNull
    @Size(max = 20, message = "departamento no puede tener mas de 10 caracteres")
    @Size(min = 4, message = "departamento no puede tener menos de 4 caracteres")
    private String departamento;
}
