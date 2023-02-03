package com.votacion.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "candidato")
public class CandidatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "can_nombre")
    private String nombre;

    @Column(name = "can_telefono")
    private String  telefono;

    @Column(name = "can_cedula", unique = true)
    private String cedula;

    @Column(name = "can_cargo")
    private  String cargo;

}
