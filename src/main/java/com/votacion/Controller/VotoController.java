package com.votacion.Controller;
import com.votacion.Entity.VotarEntity;
import com.votacion.Service.VotarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/votar")
public class VotoController {

    private final VotarService votarService;

    public VotoController(VotarService votarService) {
        this.votarService = votarService;
    }


    @PostMapping(value = "/registrar")
    private ResponseEntity<String> guardarVoto(@RequestBody VotarEntity votarEntity){
        return votarService.guardarVoto(votarEntity);
    }

    @GetMapping(value = "/listar")
    private List<VotarEntity> listarVoto(){
        return votarService.listarVotos();
    }

    @PutMapping(value = "/actualizar/{id}")
    private ResponseEntity<String> actualizarVoto(@RequestBody VotarEntity votarEntity, @PathVariable("id") Long id){
        return votarService.actualizarVoto(votarEntity, id);
    }

    @DeleteMapping(value ="/eliminar/{id}")
    private ResponseEntity<String> eliminarVoto(@PathVariable("id") Long id){
        return votarService.eliminarVoto(id);
    }
}
