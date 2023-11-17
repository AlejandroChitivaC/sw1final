package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.repos.UsuarioRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.codelab.softwaresol.services.AuthService;
import org.codelab.softwaresol.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    private AuthController auth;

    @Autowired
    private AuthService authService;

    @GetMapping("/getUsers")
    public String getUsuarios(Model model) {
        List<Usuario> listUsers = usuarioService.getUsuarios();
        model.addAttribute("listUsers", listUsers);
        return "static/web/users/showUser.html";
    }

    @GetMapping("/getUsers2")
    public List<Usuario>listaUsuarios(){
        return this.usuarioService.getUsuarios();
    }

    @GetMapping("/getUser/{idUsuario}")
    public Optional<Usuario> getUsuarioById(@PathVariable("idUsuario") int idUsuario) {
        return usuarioService.getUsuario(idUsuario);
    }

    @PostMapping("/addUser")
    public Usuario createUsuario(@RequestBody Usuario usuario) throws AccessDeniedException {
        String currentUser = auth.getCurrentUser();
        String userRol = authService.getRolUser(currentUser);

        if (userRol != null && userRol.equals("ADMIN")) {
            usuarioService.createUsuario(usuario);
            return usuario;
        } else {
            throw new AccessDeniedException("Acceso denegado");
        }

    }

    @PutMapping("/updateUser")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        usuarioService.updateUsuario(usuario);
        return usuario;
    }

    @DeleteMapping("/deleteUser/{idUsuario}")
    public void deleteUsuario(@PathVariable("idUsuario") int idUsauario) {
        usuarioService.deleteUsuario(idUsauario);
    }
}