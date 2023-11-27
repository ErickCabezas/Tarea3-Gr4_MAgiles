package com.example.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(value = Parameterized.class)
public class InscripcionCursoYPagoParametersTest {

    private InscripcionCurso inscripcionCurso;


    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{new InscripcionCurso(101, "25/11/2023", "26/02/2024", "7-9", 300.0, 2)});
        objects.add(new Object[]{new InscripcionCurso(101, "25/11/2022", "26/02/2022", "14-16", 200.0, 0)});
        objects.add(new Object[]{new InscripcionCurso(101, "25/11/2021", "26/02/2021", "16-18", 300.0, 3)});

        return objects;
    }


    public InscripcionCursoYPagoParametersTest(InscripcionCurso inscripcionCurso) {
        this.inscripcionCurso = inscripcionCurso;
    }

    @Test(timeout = 50)
    public void given_parameters_when_pagar_then_timeout() {
        assertTrue(inscripcionCurso.pagar("efectivo"));
    }


}