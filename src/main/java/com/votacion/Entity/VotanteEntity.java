package com.votacion.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "votante")
public class VotanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vot_nombre")
    private String nombre;

    @Column(name = "vot_telefono")
    private String  telefono;

    @Column(name = "vot_cedula", unique = true)
    private String cedula;

    @Column(name = "vot_direccion")
    private String direccion;

    @Column(name = "vot_ciudad")
    private String ciudad;

    @Column(name = "vot_departamento")
    private String departamento;
}
