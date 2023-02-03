package com.votacion.Service;

import com.votacion.Entity.VotarEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VotarService {

    ResponseEntity<String> guardarVoto(VotarEntity votarEntity);
    ResponseEntity<String> actualizarVoto(VotarEntity votarEntity, Long id);
    List<VotarEntity> listarVotos();
    ResponseEntity<String> eliminarVoto(Long id);


}
