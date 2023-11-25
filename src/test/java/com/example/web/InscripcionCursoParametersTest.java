package com.example.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(value = Parameterized.class)
public class InscripcionCursoParametersTest {
    private String expectedMessage;
    private InscripcionCurso inscripcionCurso;


    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"Dar prueba de ubicación", new InscripcionCurso(101, "25/11/2023", "26/02/2024", "7-9", 300.0, 2)});
        objects.add(new Object[]{"Dar prueba de ubicación", new InscripcionCurso(101, "25/11/2022", "26/02/2022", "14-16", 300.0, 0)});
        objects.add(new Object[]{"Dar prueba de ubicación", new InscripcionCurso(101, "25/11/2021", "26/02/2021", "16-18", 300.0, 3)});

        return objects;
    }


    public InscripcionCursoParametersTest(String expectedMessage, InscripcionCurso inscripcionCurso) {
        this.expectedMessage = expectedMessage;
        this.inscripcionCurso = inscripcionCurso;
    }

    @Test
    public void given_parameters_when_inscription_then_error() {
        String actualMessage = this.inscripcionCurso.inscribir();
        assertEquals("Dar prueba de ubicación", actualMessage);

    }


}