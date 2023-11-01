package org.codelab.softwaresol.model.repos;

import org.codelab.softwaresol.model.domain.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUserByUsuario(String usuario);
}