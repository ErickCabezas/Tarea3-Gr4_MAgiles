package com.example.web;

public abstract class Inscripcion {
    protected Usuario usuario;
    protected String fechaInscripcion;
    protected String horario;
    public int nivel;

    public abstract String inscribir();

}


