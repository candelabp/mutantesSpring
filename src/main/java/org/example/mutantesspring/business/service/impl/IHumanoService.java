package org.example.mutantesspring.business.service.impl;

import org.example.mutantesspring.Domain.entities.Humano;
import org.springframework.stereotype.Repository;

public interface IHumanoService {
    Humano crearHumano(Humano humano);
    Humano getById(long id);
    long contarHumanos();
    long contarMutantes();
}
