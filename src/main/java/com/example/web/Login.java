package com.example.web;

public class Login {
    private String usuario;
    private String contrasenia;

    public Login(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public boolean validarCredenciales(String user, String key){
        return this.usuario.equals(user) && this.contrasenia.equals(key);
    }

    public String getUsuario() {
        return usuario;
    }
}
