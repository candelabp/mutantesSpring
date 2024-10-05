package org.example.mutantesspring.presentation.rest;

import org.example.mutantesspring.Domain.dtos.Humanodto;
import org.example.mutantesspring.business.facade.IHumanoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/humanos")
public class HumanoController {

    @Autowired
    private IHumanoFacade humanoFacade;

    @GetMapping("/all/{id}")
    public ResponseEntity<Humanodto> getAllDataById(@PathVariable Long id) {
        Humanodto humanodto = humanoFacade.getAllDataById(id);
        if (humanodto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(humanodto);
    }

    @PostMapping()
    public ResponseEntity<Humanodto> crear(@RequestBody Humanodto humanodto) {
        Humanodto createdHumanodto = humanoFacade.crearHumano(humanodto);
        return ResponseEntity.ok().body(createdHumanodto);
    }
}
