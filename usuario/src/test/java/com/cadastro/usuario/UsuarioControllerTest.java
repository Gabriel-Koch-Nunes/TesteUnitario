package com.cadastro.usuario;

import com.cadastro.usuario.controller.UsuarioController;
import com.cadastro.usuario.model.Usuario;
import com.cadastro.usuario.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    void deveListarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario(1L, "Gabriel", "gabriel@email.com"),
                new Usuario(2L, "Kevin", "kevin@email.com")
        );

        when(usuarioService.listaUser()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioController.listarUsuarios();

        assertEquals(2, resultado.size());
        assertEquals("Gabriel", resultado.get(0).getName());
        verify(usuarioService, times(1)).listaUser();
    }

    @Test
    void deveSalvarUsuario() {
        Usuario usuario = new Usuario(null, "Lucas", "Lucas@email.com");
        Usuario usuarioSalvo = new Usuario(1L, "Elen", "Elen@email.com");

        when(usuarioService.salvarUser(usuario)).thenReturn(usuarioSalvo);

        ResponseEntity<Usuario> response = usuarioController.salvarUsuario(usuario);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Carlos", response.getBody().getName());
        assertEquals("carlos@email.com", response.getBody().getEmail());
        verify(usuarioService, times(1)).salvarUser(usuario);

    }
}
