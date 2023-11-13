package com.example.web;

public class InscripcionCurso extends Inscripcion{
    private Usuario profesor;
    private int aula;
    private String fechaInicio, fechaFin;
    private double costo;

    @Override
    public void inscribir() {
        super.inscribir();

    }

    public double getCosto() {
        return costo;
    }

    public void getInfo(){

    }

    public void pagar(){

    }
}
