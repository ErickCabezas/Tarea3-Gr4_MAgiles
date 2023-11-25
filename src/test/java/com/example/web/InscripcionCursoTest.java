package com.example.web;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InscripcionCursoTest {
    Usuario usuario;
    @Before
    public void setUp(){
        usuario = new Usuario("Johan", "Roberto", "1752823649",
                "as", "Estudiante", "0983706479"
                , "Johans", "123");
        usuario.setInscripcion(new InscripcionCurso(101, "25/11/2023", "26/02/2024", "7-9", 300.0, 2));
    }


    @Test
    public void given_modoPago_when_pagar_then_Error() {
        assertFalse(usuario.getInscripcion().pagar("transferencia"));
    }

    @Test(timeout = 50)
    public void given_modoPago_when_pagor_then_timeout() {
        assertTrue(usuario.getInscripcion().pagar("efectivo"));
    }

}