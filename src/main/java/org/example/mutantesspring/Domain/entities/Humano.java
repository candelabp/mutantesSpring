package org.example.mutantesspring.Domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.mutantesspring.business.service.impl.DnaConverter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Humano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean esMutante = false;
    @Convert(converter = DnaConverter.class)
    private String[] dna = new String[6];




}
