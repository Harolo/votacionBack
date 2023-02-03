package com.votacion.Service.implement;

import com.votacion.Dto.RespuestaDto;
import com.votacion.Entity.CandidatoEntity;
import com.votacion.Entity.VotarEntity;
import com.votacion.Repository.CandidatoRepository;
import com.votacion.Repository.VotarRepository;
import com.votacion.Service.VotarService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class VotarImp implements VotarService {
    private final VotarRepository votarRepository;
    private final CandidatoRepository candidatoRepository;


    public VotarImp(VotarRepository votarRepository, CandidatoRepository candidatoRepository) {
        this.votarRepository = votarRepository;
        this.candidatoRepository = candidatoRepository;
    }


    @Override
    public ResponseEntity<String> guardarVoto(VotarEntity votarEntity) {
        try {
            VotarEntity votar = new VotarEntity();
            votar.setVotanteEntity(votarEntity.getVotanteEntity());
            votar.setCandidatoEntity(votarEntity.getCandidatoEntity());
            votarRepository.save(votar);
            Optional<CandidatoEntity> candidato = candidatoRepository.findById(votarEntity.getCandidatoEntity().getId());
            if (candidato.isPresent()) {
                CandidatoEntity candidatoData = candidato.get();
                try {
                    RespuestaDto respuestaDto = votarRepository.data(candidatoData.getCargo());
                    Optional<CandidatoEntity> candidatoGanador = candidatoRepository.findByCedula(respuestaDto.getCedula());
                    return ResponseEntity.ok().body("Voto guardado con exito, va ganando el candidato: " + candidatoGanador.get().getNombre() + " " + "para el cargo de: " + candidatoData.getCargo());
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body("Hay un empate");
                }
            } else {
                return ResponseEntity.ok().body("EL candidato no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guaradr el voto: " + e);
        }
    }

    @Override
    public ResponseEntity<String> actualizarVoto(VotarEntity votarEntity, Long id) {
        Optional<VotarEntity> voto = votarRepository.findById(id);

        try {
            if (voto.isPresent()) {
                VotarEntity votoActualizado = voto.get();
                votoActualizado.setCandidatoEntity(votarEntity.getCandidatoEntity());
                votoActualizado.setVotanteEntity(votarEntity.getVotanteEntity());
                votarRepository.save(votoActualizado);
                return ResponseEntity.ok().body("Voto actualizado correctamente");
            } else {
                return ResponseEntity.badRequest().body("Voto no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar el voto: " + e);
        }
    }


    @Override
    public List<VotarEntity> listarVotos() {
        return votarRepository.findAll();
    }

    @Override
    public ResponseEntity<String> eliminarVoto(Long id) {
        Optional<VotarEntity> voto = votarRepository.findById(id);
        try {
            if (voto.isPresent()) {
                VotarEntity votoEliminar = voto.get();
                votarRepository.delete(votoEliminar);
                return ResponseEntity.ok().body("Voto eliminado correctamente");
            } else {
                return ResponseEntity.ok().body("voto no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el voto: " + e);
        }
    }


}
