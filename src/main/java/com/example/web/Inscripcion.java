package com.example.web;

public abstract class Inscripcion {
    public Usuario usuario;
    public String fechaInscripcion;
    public String horario;
    public int nivel;

    public abstract String inscribir();

}


