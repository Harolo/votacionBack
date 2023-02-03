package com.votacion.Repository;

import com.votacion.Dto.CandidatoDto;
import com.votacion.Entity.CandidatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<CandidatoEntity, Long> {

    boolean existsByCedula(String cedula);
    Optional<CandidatoEntity> findByCedula(String cedula);
    List<CandidatoEntity> findBycargo(String cargo);



}
