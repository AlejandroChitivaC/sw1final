package org.codelab.softwaresol.repos;

import org.codelab.softwaresol.model.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
}