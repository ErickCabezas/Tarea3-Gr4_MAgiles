package com.example.web;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Gestor_UsuarioTest {
    Gestor_Usuario gestorUsuario = null;
    Usuario usuario;

    @Before
    public void setUp() {
        gestorUsuario = new Gestor_Usuario();
        usuario = crearUsuarioParaPrueba();
    }

    private static Usuario crearUsuarioParaPrueba() {
        return new Usuario("Johan", "Roberto", "1752823649",
                "as", "Estudiante", "0983706479", "Johans", "123");
    }

    @Test
    public void given_numberCC_when_validate_then_ok() {
        assertTrue(gestorUsuario.validarCedulaEcuatoriana("1804669925"));
    }

    @Test
    public void given_AnUser_when_addUser_then_timeout() {
        assertEquals("Usuario agregado", gestorUsuario.agregarUsuario(usuario));
    }


}