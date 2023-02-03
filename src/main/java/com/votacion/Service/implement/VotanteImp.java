package com.votacion.Service.implement;

import com.votacion.Dto.VotanteDto;
import com.votacion.Entity.VotanteEntity;
import com.votacion.Repository.VotanteRepository;
import com.votacion.Service.VotanteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VotanteImp implements VotanteService {

    private final VotanteRepository votanteRepository;
    private final ModelMapper modelMapper;

    public VotanteImp(VotanteRepository votanteRepository, ModelMapper modelMapper) {
        this.votanteRepository = votanteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<String> guardarVotante(VotanteDto votanteDto) {
        if (votanteRepository.existsByCedula(votanteDto.getCedula())) {
            return ResponseEntity.badRequest().body("El votante ya existe");
        } else {
            try {
                votanteRepository.save(modelMapper.map(votanteDto, VotanteEntity.class));
                return ResponseEntity.ok().body("votante registrado con exito");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Error al guardar el votante");
            }
        }
    }

    @Override
    public ResponseEntity<String> actualizarVotante(VotanteDto votanteDto, Long id) {
        Optional<VotanteEntity> votante = votanteRepository.findById(id);
        try {
            if (votante.isPresent()) {
                VotanteEntity dataVotante = votante.get();
                dataVotante.setNombre(votanteDto.getNombre());
                dataVotante.setTelefono(votanteDto.getTelefono());
                dataVotante.setCiudad(votanteDto.getCiudad());
                dataVotante.setDepartamento(votanteDto.getDepartamento());
                dataVotante.setDireccion(votanteDto.getDireccion());
                votanteRepository.save(dataVotante);
                return ResponseEntity.ok().body("votante actualizado correctamente");

            } else {
                return ResponseEntity.badRequest().body("votante no existe con el numero de documento suministrado");
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar el votante:" + e);
        }
    }

    @Override
    public List<VotanteEntity> listarVotante() {
        List<VotanteEntity> listaVotantes = null;
        try {
            listaVotantes = votanteRepository.findAll();
            return listaVotantes;
        } catch (Exception e) {
            return listaVotantes;
        }
    }

    @Override
    public ResponseEntity<String> eliminarVotante(Long id) {
        Optional<VotanteEntity> votante = votanteRepository.findById(id);
        try {
            if (votante.isPresent()) {
                VotanteEntity votanteEliminar = votante.get();
                votanteRepository.delete(votanteEliminar);
                return ResponseEntity.ok().body("votante eliminado con exito");
            } else {
                return ResponseEntity.badRequest().body("votante a eliminar no existe");
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar votante:" + e);
        }
    }

    @Override
    public VotanteEntity listarPorId(Long id) {
        return votanteRepository.findById(id).get();
    }
}
