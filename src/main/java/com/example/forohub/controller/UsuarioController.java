package com.example.forohub.controller;

import com.example.forohub.dto.DatosRegistroUsuario;
import com.example.forohub.modelo.Usuario;
import com.example.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarUsuario(@RequestBody DatosRegistroUsuario datos) {
        String claveEncriptada = new BCryptPasswordEncoder().encode(datos.clave());
        Usuario nuevoUsuario = new Usuario(datos.nombre(), datos.email(), claveEncriptada);
        usuarioRepository.save(nuevoUsuario);
    }
}