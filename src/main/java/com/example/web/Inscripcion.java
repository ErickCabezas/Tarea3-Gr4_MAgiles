package com.example.web;

public abstract class Inscripcion {
    protected Usuario usuario;
    protected String fechaInscripcion;
    protected String horario;
    public int nivel;

    public abstract String inscribir();

    public boolean pagar(String modoPago) {
        return false;
    }
    public double getCosto() {
        return 0;
    }
}


