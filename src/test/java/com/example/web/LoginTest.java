package com.example.web;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {
private Usuario usuario;
private Login login;
    @Before
    public void setUp(){
        usuario = new Usuario("Johan", "Roberto", "1752823649",
                "as", "Estudiante", "0983706479"
                , "Johans", "123");
        login=new Login("Johans","123");
    }

    @Test(timeout = 50)
    public void give_validarCredenciales_when_is_correct_then_true() {
        assertTrue(login.validarCredenciales("Johans","123"));
    }

}