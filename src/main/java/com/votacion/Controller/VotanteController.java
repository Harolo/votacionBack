package com.votacion.Controller;

import com.votacion.Dto.VotanteDto;
import com.votacion.Entity.VotanteEntity;
import com.votacion.Service.VotanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/votante")
public class VotanteController {

    private final VotanteService votanteService;

    public VotanteController(VotanteService votanteService) {
        this.votanteService = votanteService;
    }

    @PostMapping(value = "/registrar")
    private ResponseEntity<String> guardarVotante(@RequestBody @Valid  VotanteDto votanteDto){
        return votanteService.guardarVotante(votanteDto);
    }

    @GetMapping(value = "/listarTodo")
    private List<VotanteEntity> listarVotantes(){
        return votanteService.listarVotante();
    }

    @GetMapping(value = "/listar/{id}")
    private VotanteEntity listarVotantesId(@PathVariable("id")Long id){
        return votanteService.listarPorId(id);
    }

    @PutMapping(value = "/actualizar/{id}")
    private ResponseEntity<String> actualizarVotante(@RequestBody VotanteDto votanteDto, @PathVariable("id") Long id){
        return votanteService.actualizarVotante(votanteDto, id);
    }

    @DeleteMapping(value ="/eliminar/{id}")
    private ResponseEntity<String> eliminarVotante(@PathVariable("id") Long id){
        return votanteService.eliminarVotante(id);
    }
}
