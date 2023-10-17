package com.desafio.first.cadUsuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafio.first.cadUsuario.entity.Usuario;
import com.desafio.first.cadUsuario.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios") // Define a rota base para todos os endpoints neste controlador
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // Injete o serviço de usuário

    // Endpoint para buscar todos os usuários (GET)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Endpoint para criar um novo usuário (POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        try {
        	Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        	return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

