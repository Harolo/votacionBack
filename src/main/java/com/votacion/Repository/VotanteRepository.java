package com.votacion.Repository;

import com.votacion.Entity.VotanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotanteRepository extends JpaRepository<VotanteEntity, Long> {

    boolean existsByCedula(String cedula);
    Optional<VotanteEntity> findByCedula(String cedula);
}
