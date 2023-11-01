package org.codelab.softwaresol.repositories;

import org.codelab.softwaresol.entities.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
}