package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
}