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
        SpringApplication.run(SoftwaresolApplication.class, args);
    }

}