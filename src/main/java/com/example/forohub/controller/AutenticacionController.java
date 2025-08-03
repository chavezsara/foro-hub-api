package com.example.forohub.controller;

import com.example.forohub.dto.DatosAutenticacionUsuario;
import com.example.forohub.modelo.Usuario;
import com.example.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public String autenticarUsuario(@RequestBody DatosAutenticacionUsuario datos) {
        Authentication token = new UsernamePasswordAuthenticationToken(
                datos.nombre(), datos.clave()
        );
        authenticationManager.authenticate(token);
        return "Usuario autenticado correctamente";
    }
}