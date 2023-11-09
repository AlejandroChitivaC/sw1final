package org.codelab.softwaresol.controllers;

import org.codelab.softwaresol.model.entities.user.LoginData;
import org.codelab.softwaresol.model.entities.repos.UsuarioRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.codelab.softwaresol.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
public class AuthController {
    @Autowired
    UsuarioRepository userRepo;

    @Autowired
    private AuthService authService;

    public AuthController(UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginData loginRequest) {
        Usuario usr = userRepo.findUserByUsuario(loginRequest.getUsername());

        if (usr != null && loginRequest.getPassword().equals(usr.getPassword())) {
            String rol = authService.getRolUser(loginRequest.getUsername());

            if (rol != null) {

                System.out.println(rol);
                return ResponseEntity.ok("Login exitoso. Rol: " + rol);
            } else {

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el rol del usuario.");
            }
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
