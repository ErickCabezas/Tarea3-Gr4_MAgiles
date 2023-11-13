package com.example.web;

import java.time.LocalDate;

public class InscripcionExamen extends Inscripcion{
    private double nota;

    public InscripcionExamen() {
        super.nivel=0;
    }

    public InscripcionExamen(String horario) {
        super.horario=horario;
    }

    @Override
    public String inscribir() {

        if(super.nivel==0){
            super.fechaInscripcion= String.valueOf(LocalDate.now());
            super.usuario.setInscripcion(this);
            return "de el examen de ubicación y espere a ser asignado a un nivel";
        }else{
            asignarNivel(super.nivel);
            return "Matriculese";
        }
    }

    public void asignarNivel(int nivel){
        switch (nivel){
            case 1:
                this.nota=25;
                break;
            case 2:
                this.nota=45;
                break;
            case 3:
                this.nota=60;
                break;
            case 4:
                this.nota=80;
                break;
        }
    }
}
