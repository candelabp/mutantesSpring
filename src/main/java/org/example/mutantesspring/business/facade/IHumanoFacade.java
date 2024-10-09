package org.example.mutantesspring.business.facade;

import org.example.mutantesspring.Domain.dtos.Humanodto;
import org.example.mutantesspring.Domain.dtos.Statsdto;

public interface IHumanoFacade {
    Humanodto crearHumano(Humanodto human);
    Humanodto getAllDataById(Long id);
    Statsdto obtenerEstadisticas();
}
