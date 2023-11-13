package com.example.web;

public class Usuario {
    private String nombre;
    private String apellido;
    private String ci;
    private String correo;
    private String telefono;
    private String modoUsuario;
    private Login login;
    private int nivel;
    private Inscripcion inscripcion;

    public Usuario(String nombre, String apellido, String ci, String correo, String modoUsuario, String telefono, String user, String key) {
        this.apellido = apellido;
        this.nombre= nombre;
        this.ci= ci;
        this.correo=correo;
        this.telefono = telefono;
        this.modoUsuario = modoUsuario;
        this.login=new Login(user, key);
        this.inscripcion= new InscripcionExamen();
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

    public String getCi() {
        return ci;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
}
