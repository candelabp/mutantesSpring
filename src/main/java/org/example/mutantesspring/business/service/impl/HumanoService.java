package org.example.mutantesspring.business.service.impl;

import org.example.mutantesspring.Domain.entities.Humano;
import org.example.mutantesspring.repositories.HumanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanoService implements IHumanoService {

    @Autowired
    private HumanoRepository humanoRepository;

    @Autowired
    private DetectorMutanteService detectorMutanteService;

    @Override
    public Humano crearHumano(Humano humano) {
        // Verificar si es mutante antes de guardar
        boolean esMutante = detectorMutanteService.esMutante(humano.getDna());
        humano.setEsMutante(esMutante);
        return humanoRepository.save(humano);
    }

    @Override
    public Humano getById(long id) {
        var humano = humanoRepository.findById(id);
        if (humano.isEmpty()) throw new RuntimeException("No se ha encontrado el humano");
        return humano.get();
    }
    @Override
    public long contarHumanos() {
        return humanoRepository.countByEsMutante(false);
    }

    @Override
    public long contarMutantes() {
        return humanoRepository.countByEsMutante(true);
    }
}

