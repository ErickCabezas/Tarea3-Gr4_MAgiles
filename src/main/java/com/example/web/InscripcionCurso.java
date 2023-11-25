package com.example.web;

public class InscripcionCurso extends Inscripcion {
    private Usuario profesor;
    private int aula;
    private String fechaInicio, fechaFin;
    private double costo;

    private ProcesoPago procesoPago;


    public InscripcionCurso(int aula, String fechaInicio, String fechaFin, String horario, double costo, int nivel) {
        super.nivel = nivel;
        super.horario = horario;
        this.aula = aula;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
    }



    @Override
    public String inscribir() {
        if (super.nivel == 0) {
            return "Dar prueba de ubicación";
        } else {
            return "Estudiante inscrito pagar $"+ getCosto();
        }

    }
    @Override
    public double getCosto() {
        return costo;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    @Override
    public boolean pagar(String modoPago) {
        if(modoPago.equalsIgnoreCase("efectivo")){
            procesoPago=new ProcesoPago(this.getCosto());
            return procesoPago.PagoEfectivo();
        }else{
            return true;
        }
    }

}
