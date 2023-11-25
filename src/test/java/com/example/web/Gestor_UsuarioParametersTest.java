package com.example.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(value = Parameterized.class)
public class Gestor_UsuarioParametersTest {
    private String expectedMessage;
    private Usuario usuario;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<>();

        objects.add(new Object[]{"Usuario agregado", new Usuario("Pablo", "R", "1713041273",
                "as", "Estudiante", "0983206471", "Pablo", "123")});
        objects.add(new Object[]{"Usuario agregado", new Usuario("Maria", "S", "1752823649",
                "as", "Estudiante", "0983206472", "Maria", "456")});
        objects.add(new Object[]{"Usuario agregado", new Usuario("David", "T", "1751398924",
                "as", "Estudiante", "0983206473", "David", "789")});
        objects.add(new Object[]{"Usuario agregado", new Usuario("Nicole", "Flores", "1727163337",
                "as", "Profesor", "093370641T", "Pablo", "123")});
        objects.add(new Object[]{"Usuario agregado", new Usuario("Tito", "osman", "1727208884",
                "as", "Estudiante", "0933706412", "Tito", "123")});
        objects.add(new Object[]{"Usuario agregado", new Usuario("Uriel", "Flores", "1752823656",
                "as", "Profesor", "0985516471", "Pablo", "123")});
        objects.add(new Object[]{"Usuario agregado", new Usuario("Nicole", "Flores", "1727163337",
                "as", "Profesor", "098370647T", "Pablo", "123")});
        return objects;
    }

    public Gestor_UsuarioParametersTest(String expectedMessage, Usuario usuario) {
        this.expectedMessage = expectedMessage;
        this.usuario = usuario;
    }

    @Test
    public void given_parameters_when_addUser_then_ok() {
        Gestor_Usuario gestorUsuario = new Gestor_Usuario();
        String actualMessage = gestorUsuario.agregarUsuario(usuario);
        assertEquals(expectedMessage, actualMessage);
    }

}
