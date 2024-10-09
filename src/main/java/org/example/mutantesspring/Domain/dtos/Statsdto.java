package org.example.mutantesspring.Domain.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statsdto {
    private long count_mutant_dna;
    private long count_human_dna;
    private double ratio;

}
