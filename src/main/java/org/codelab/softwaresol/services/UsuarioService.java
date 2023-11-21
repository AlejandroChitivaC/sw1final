package org.codelab.softwaresol.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.codelab.softwaresol.model.entities.repos.UsuarioRepository;
import org.codelab.softwaresol.model.entities.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private ViewResolver viewResolver;


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

    public Usuario getById(int id){
        return usuarioRepository.findById(id).get();
    }
}
