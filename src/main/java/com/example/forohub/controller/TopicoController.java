package com.example.forohub.controller;

import com.example.forohub.dto.TopicoDTO;
import com.example.forohub.modelo.Topico;
import com.example.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody TopicoDTO datos) {
        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.autor(),
                datos.curso()
        );
        topicoRepository.save(topico);
    }

    @GetMapping
    public List<TopicoDTO> listarTopicos() {
        return topicoRepository.findAll().stream()
                .map(t -> new TopicoDTO(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor(), t.getCurso()))
                .toList();
    }
}
