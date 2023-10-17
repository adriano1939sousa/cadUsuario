package com.desafio.first.cadUsuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.first.cadUsuario.entity.Usuario;
import com.desafio.first.cadUsuario.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository; // Injete o repositório de usuário

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        // Adicione qualquer lógica de validação necessária aqui antes de salvar o usuário
        return usuarioRepository.save(usuario);
    }
}

