package com.example.web;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String telefono;
    private String modoUsuario;
    private Login login;
    private Inscripcion inscripcion;

    public Usuario(String nombre, String apellido, String cedula, String correo, String modoUsuario, String telefono, String usuario, String contrasenia) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.modoUsuario = modoUsuario;
        this.login = new Login(usuario, contrasenia);
        //TODO: ELIMINAR ESTO Y PONER COMPOSICION O MODIFCAR SEGUN SEA
        this.inscripcion = new InscripcionExamen();
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getModoUsuario() {
        return modoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Login getLogin() {
        return login;
    }

    public String getCedula() {
        return cedula;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
}
