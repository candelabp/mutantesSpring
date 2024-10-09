package org.example.mutantesspring.Domain.dtos;

import jakarta.persistence.Convert;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Humanodto {
    private Long id;
    private boolean esMutante = false;
    private String[] dna = new String[6];;
}

