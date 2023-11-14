package org.codelab.softwaresol.services;

import org.codelab.softwaresol.model.entities.repos.UsuarioRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios (){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuario (int idUsuario){
        return usuarioRepository.findById(idUsuario);
    }

    public Usuario createUsuario (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario (int idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

}
