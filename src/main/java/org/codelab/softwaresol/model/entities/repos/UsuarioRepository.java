package org.codelab.softwaresol.model.entities.repos;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUserByUsuario(String usuario);
}