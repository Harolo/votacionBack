package com.votacion.Controller;

import com.votacion.Dto.CandidatoDto;
import com.votacion.Entity.CandidatoEntity;
import com.votacion.Service.CandidatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/candidato")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping(value = "/registrar")
    private ResponseEntity<String> guardarCandidato(@RequestBody @Valid CandidatoDto candidatoDto){
        return candidatoService.guardarCandidato(candidatoDto);
    }

    @PutMapping(value = "/actualizar/{id}")
    private ResponseEntity<String> actualizarCandidato(@PathVariable("id") Long id,  @RequestBody CandidatoDto candidatoDto){
        return candidatoService.actualizarCandidato(candidatoDto, id);
    }

    @GetMapping(value = "/listar/{cargo}")
    private List<CandidatoEntity> listarCandidatosCargo(@PathVariable("cargo") String cargo){
        return candidatoService.listarCandidatos(cargo);
    }

    @GetMapping(value = "/listarTodo")
    private List<CandidatoEntity> listarTodoCandidatos(){
        return candidatoService.listarTotoCandidatos();
    }

    @GetMapping(value = "/listarCandidato/{id}")
    private CandidatoEntity listarPorId(@PathVariable("id") Long id){
        return candidatoService.listarPorId(id);
    }

    @DeleteMapping(value ="/eliminar/{id}")
    private ResponseEntity<String> eliminarCandidato(@PathVariable("id") Long id){
        return candidatoService.eliminarCandidato(id);
    }

}
