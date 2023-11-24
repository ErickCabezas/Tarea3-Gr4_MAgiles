package com.example.web;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Gestor_UsuarioTest {
    Gestor_Usuario usuario = null;

    @Before
    public void setUp(){
        usuario = new Gestor_Usuario();
    }

    @Test
    public void given_numberCC_when_validate_then_ok() {
        assertTrue(usuario.validarCedulaEcuatoriana("1804669925"));
    }
}