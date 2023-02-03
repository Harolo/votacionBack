package com.votacion.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "votar")
public class VotarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidato_id", referencedColumnName = "id")
    private CandidatoEntity candidatoEntity;

    @ManyToOne
    @JoinColumn(name = "votante_id", referencedColumnName = "id")
    private VotanteEntity votanteEntity;

}
