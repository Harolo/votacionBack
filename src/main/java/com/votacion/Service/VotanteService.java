package com.votacion.Service;

import com.votacion.Dto.VotanteDto;
import com.votacion.Entity.VotanteEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VotanteService {

    ResponseEntity<String> guardarVotante(VotanteDto votanteDto);
    ResponseEntity<String> actualizarVotante(VotanteDto votanteDto,Long id);
    List<VotanteEntity> listarVotante();
    ResponseEntity<String> eliminarVotante(Long id);
    VotanteEntity listarPorId(Long id);
}