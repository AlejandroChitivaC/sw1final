package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
}