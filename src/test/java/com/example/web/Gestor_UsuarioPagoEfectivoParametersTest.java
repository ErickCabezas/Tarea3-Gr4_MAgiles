package com.example.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(value = Parameterized.class)
public class Gestor_UsuarioPagoEfectivoParametersTest {
    private String expectedMessage;
    private Usuario usuario;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<>();

        objects.add(new Object[]{new Usuario("Pablo", "R", "1713041273",
                "as", "Estudiante", "0983206471", "Pablo", "123")});
        objects.add(new Object[]{new Usuario("Maria", "S", "1752823649",
                "as", "Estudiante", "0983206472", "Maria", "456")});
        objects.add(new Object[]{new Usuario("David", "T", "1751398924",
                "as", "Estudiante", "0983206473", "David", "789")});
        objects.add(new Object[]{new Usuario("Nicole", "Flores", "1727163337",
                "as", "Profesor", "093370641T", "Pablo", "123")});
        objects.add(new Object[]{new Usuario("Tito", "osman", "1727208884",
                "as", "Estudiante", "0933706412", "Tito", "123")});
        objects.add(new Object[]{new Usuario("Uriel", "Flores", "1752823656",
                "as", "Profesor", "0985516471", "Pablo", "123")});
        objects.add(new Object[]{new Usuario("Nicole", "Flores", "1727163337",
                "as", "Profesor", "098370647T", "Pablo", "123")});
        return objects;
    }

    public Gestor_UsuarioPagoEfectivoParametersTest(Usuario usuario) {
        this.usuario = usuario;
        usuario.setInscripcion(new InscripcionCurso(101, "25/11/2023", "26/02/2024", "7-9", 300.0, 2));
    }

    @Test
    public void given_parameters_when_addUserAndInscripcionPagar_then_ok() {
        assertTrue(usuario.getInscripcion().pagar("efectivo"));
    }

}
