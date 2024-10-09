package org.example.mutantesspring.repositories;

import org.example.mutantesspring.Domain.entities.Humano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanoRepository extends JpaRepository<Humano, Long> {
boolean existsByDna(String dna);
long countByEsMutante(boolean esMutante);
}
