package org.codelab.softwaresol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class SoftwaresolApplication {
    public static void main(String[] args) throws URISyntaxException, IOException {

        // URL que deseas pasar como argumento
        String url = "http://localhost:8080/web/login.html";

        // Crear una instancia de ApplicationArguments con la URL como argumento
        //mandar como parametro del run la url (http://localhost:8080/web/login.html)
        SpringApplication.run(SoftwaresolApplication.class, args);
    }

}