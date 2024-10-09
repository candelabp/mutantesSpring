package org.example.mutantesspring.presentation.rest;

import org.example.mutantesspring.Domain.dtos.Humanodto;
import org.example.mutantesspring.Domain.dtos.Statsdto;
import org.example.mutantesspring.business.facade.IHumanoFacade;
import org.example.mutantesspring.business.service.impl.DetectorMutanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/humanos")
public class HumanoController {

    @Autowired
    private IHumanoFacade humanoFacade;

    @Autowired
    private DetectorMutanteService detectorMutanteService;

    @GetMapping("/all/{id}")
    public ResponseEntity<Humanodto> getAllDataById(@PathVariable Long id) {
        Humanodto humanodto = humanoFacade.getAllDataById(id);
        if (humanodto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(humanodto);
    }

    @PostMapping()
    public ResponseEntity<String> crear(@RequestBody Humanodto humanodto) {
        // Lógica de creación de humano
        Humanodto createdHumanodto = humanoFacade.crearHumano(humanodto);

        // Verificación de si es mutante
        boolean esMutante = detectorMutanteService.esMutante(humanodto.getDna());

        if (esMutante) {
            // Si es mutante, devolvemos 200 OK
            return ResponseEntity.ok("El humano es un mutante");
        } else {
            // Si no es mutante, devolvemos 403 Forbidden
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El humano no es un mutante");
        }
    }
    @Autowired


    @GetMapping("/stats")
    public ResponseEntity<Statsdto> obtenerEstadisticas() {
        Statsdto stats = humanoFacade.obtenerEstadisticas();
        return ResponseEntity.ok().body(stats);
}
}

