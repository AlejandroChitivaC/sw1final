package org.codelab.softwaresol.repos;

import org.codelab.softwaresol.model.domain.user.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
}