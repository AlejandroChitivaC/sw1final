package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.repos.UsuarioRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean authUsuario(String username, String password){
        Usuario usuario = usuarioRepository.findUserByUsuario(username);

        if (usuario != null && usuario.getContraseña().equals(password)) {
            return true;
        }
        return false;
    }

    public String getRolUser (String username){
        Usuario usuario = usuarioRepository.findUserByUsuario(username);
        if (usuario != null) {
            return usuario.getRol();
        }
        return "No se ha encontrado el rol";
    }
}
