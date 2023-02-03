package com.votacion.Service;

import com.votacion.Dto.CandidatoDto;
import com.votacion.Entity.CandidatoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CandidatoService {
    ResponseEntity<String> guardarCandidato(CandidatoDto candidatoDto);

    ResponseEntity<String> actualizarCandidato(CandidatoDto candidatoDto, Long id);

    List<CandidatoEntity> listarCandidatos(String cargo);

    ResponseEntity<String> eliminarCandidato(Long id);
    List<CandidatoEntity> listarTotoCandidatos();
    CandidatoEntity listarPorId(Long id);
}
