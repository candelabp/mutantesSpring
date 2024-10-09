package org.example.mutantesspring.business.facade.impl;

import org.example.mutantesspring.Domain.dtos.Humanodto;
import org.example.mutantesspring.Domain.dtos.Statsdto;
import org.example.mutantesspring.business.facade.IHumanoFacade;
import org.example.mutantesspring.business.mapper.HumanoMapper;
import org.example.mutantesspring.business.service.impl.IHumanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanoFacade implements IHumanoFacade {

    @Autowired
    private IHumanoService humanoService;

    @Autowired
    private HumanoMapper humanoMapper;

    @Override
    public Humanodto crearHumano(Humanodto nuevoHumano) {
        // Convertir DTO a entidad
        var newHumano = humanoMapper.humanoDtoToHumano(nuevoHumano);
        // Guardar entidad
        var humanoGuardado = humanoService.crearHumano(newHumano);
        // Devolver la nueva entidad convertida en DTO
        return humanoMapper.humanoDto(humanoGuardado);
    }

    @Override
    public Humanodto getAllDataById(Long id) {
        // Obtener humano por ID
        var humano = humanoService.getById(id);
        if (humano == null) {
            // Lanza una excepción o retorna nulo si no se encuentra
            return null;
        }
        // Devolver la entidad convertida en DTO con todos los datos
        return humanoMapper.humanoDto(humano);
    }
    public Statsdto obtenerEstadisticas() {
        long countHumanDna = humanoService.contarHumanos();
        long countMutantDna = humanoService.contarMutantes();
        double ratio = (countHumanDna == 0) ? 0 : (double) countMutantDna / countHumanDna;

        return Statsdto.builder()
                .count_human_dna(countHumanDna)
                .count_mutant_dna(countMutantDna)
                .ratio(ratio)
                .build();
    }
}

