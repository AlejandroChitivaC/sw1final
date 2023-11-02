package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.domain.user.LoginData;
import org.codelab.softwaresol.model.domain.user.Usuario;
import org.codelab.softwaresol.model.domain.repos.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
public class AuthController {
    UsuarioRepository userRepo;

    public AuthController(UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(path = "/login")
            public ResponseEntity<String>login(@RequestBody LoginData loginRequest) {
        Usuario usr = userRepo.findUserByUsuario(loginRequest.getUsername());
        if (usr != null && loginRequest.getPassword().equals(usr.getPassword())) {
            // Autenticación exitosa
            return ResponseEntity.ok("Login exitoso");
        } else {
            // Autenticación fallida
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
