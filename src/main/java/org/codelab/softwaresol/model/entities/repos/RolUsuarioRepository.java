package org.codelab.softwaresol.model.entities.repos;

import org.codelab.softwaresol.model.entities.user.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
}