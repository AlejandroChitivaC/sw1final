package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
}