package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

}