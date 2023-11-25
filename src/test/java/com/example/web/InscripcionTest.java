package com.example.web;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscripcionTest {
Usuario usuario;
    @Before
    public void setUp(){
        usuario = new Usuario("Johan", "Roberto", "1752823649",
                "as", "Estudiante", "0983706479"
                , "Johans", "123");
        usuario.setInscripcion(new InscripcionCurso(101, "25/11/2023", "26/02/2024", "7-9", 300.0, 2));
    }

    @Test
    public void given_costo_when_getCosto_and_inscribir_then_ok() {
        double actual=usuario.getInscripcion().getCosto();
        assertEquals(300,actual);
        String expectedInscripcion="Estudiante inscrito pagar $"+ actual;
        assertEquals(expectedInscripcion,usuario.getInscripcion().inscribir());
    }
}