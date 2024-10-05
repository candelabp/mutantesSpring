package org.example.mutantesspring.business.mapper;

import org.example.mutantesspring.Domain.dtos.Humanodto;
import org.example.mutantesspring.Domain.entities.Humano;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface HumanoMapper {
    Humanodto humanoDto(Humano humano);
    Humano humanoDtoToHumano(Humanodto humanodto);
}
