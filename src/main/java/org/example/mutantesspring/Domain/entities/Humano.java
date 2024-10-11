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
    @Column(nullable = false, unique = true)
    @Convert(converter = DnaConverter.class)
    private String[] dna;




}
