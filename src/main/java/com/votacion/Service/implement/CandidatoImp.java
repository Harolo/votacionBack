package com.votacion.Service.implement;

import com.votacion.Dto.CandidatoDto;
import com.votacion.Entity.CandidatoEntity;
import com.votacion.Repository.CandidatoRepository;
import com.votacion.Service.CandidatoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CandidatoImp implements CandidatoService {

    private final CandidatoRepository candidatoRepository;
    private final ModelMapper modelMapper;


    public CandidatoImp(CandidatoRepository candidatoRepository, ModelMapper modelMapper) {
        this.candidatoRepository = candidatoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<String> guardarCandidato(CandidatoDto candidatoDto) {
        if (candidatoRepository.existsByCedula(candidatoDto.getCedula())) {
            return ResponseEntity.badRequest().body("El candidato ya existe");
        } else
            try {
                candidatoRepository.save(modelMapper.map(candidatoDto, CandidatoEntity.class));
                return ResponseEntity.ok().body("Candidato registrado con exito");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Error al guardar candidato:" + e);
            }

    }

    @Override
    public ResponseEntity<String> actualizarCandidato(CandidatoDto candidatoDto, Long id) {
        Optional<CandidatoEntity> candidato = candidatoRepository.findById(id);

        try {
            if (candidato.isPresent()) {
                CandidatoEntity dataCandidato = candidato.get();
                dataCandidato.setNombre(candidatoDto.getNombre());
                dataCandidato.setTelefono(candidatoDto.getTelefono());
                dataCandidato.setCargo(candidatoDto.getCargo());
                candidatoRepository.save(dataCandidato);
                return ResponseEntity.ok().body("Candidato actualizado correctamente");
            } else {
                return ResponseEntity.badRequest().body("Candidato no existe con el numero de documento suministrado");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar el candidato:" + e);
        }
    }

    @Override
    public List<CandidatoEntity> listarCandidatos(String cargo) {
        List<CandidatoEntity> candidatoCargo = null;
        try {
            switch (cargo) {
                case "alcaldia":
                    candidatoCargo = candidatoRepository.findBycargo(cargo);
                    break;

                case "consejo":
                    candidatoCargo = candidatoRepository.findBycargo(cargo);
                    break;

                case "gobernacion":
                    candidatoCargo = candidatoRepository.findBycargo(cargo);
                    break;
            }
            return candidatoCargo;

        } catch (Exception e) {
            return candidatoCargo;
        }

    }

    @Override
    public ResponseEntity<String> eliminarCandidato(Long id) {
        Optional<CandidatoEntity> candidato = candidatoRepository.findById(id);
        try {
            if (candidato.isPresent()) {
                CandidatoEntity candidatoEliminar = candidato.get();
                candidatoRepository.delete(candidatoEliminar);
                return ResponseEntity.ok().body("Candidato eliminado con exito");
            } else {
                return ResponseEntity.badRequest().body("Candidato a eliminar no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar usuario:" + e);
        }
    }

    @Override
    public List<CandidatoEntity> listarTotoCandidatos() {
        return candidatoRepository.findAll();
    }

    @Override
    public CandidatoEntity listarPorId(Long id) {
        return candidatoRepository.findById(id).get();
    }


}





