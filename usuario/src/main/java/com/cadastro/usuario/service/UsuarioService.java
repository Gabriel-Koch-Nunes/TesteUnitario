package com.cadastro.usuario.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.usuario.model.Usuario;
import com.cadastro.usuario.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listaUser() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUser(Usuario user) {
        return usuarioRepository.save(user);
    }

}