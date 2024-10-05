package org.example.mutantesspring.repositories;

import org.example.mutantesspring.Domain.entities.Humano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanoRepository extends JpaRepository<Humano, Long> {

}
