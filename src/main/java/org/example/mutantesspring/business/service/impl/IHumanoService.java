package org.example.mutantesspring.business.service.impl;

import org.example.mutantesspring.Domain.entities.Humano;

public interface IHumanoService {
    Humano crearHumano(Humano humano);
    Humano getById(long id);
}
