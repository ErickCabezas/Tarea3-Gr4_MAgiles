package com.example.web;

import java.util.ArrayList;
import java.util.List;

public class Gestor_Usuario {
    private List<Usuario> usuarios;

    public Gestor_Usuario() {
        this.usuarios = new ArrayList<>();

    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(String usuarioABuscar) {
        for (Usuario usuario : usuarios) {
            if (compararUsuario(usuarioABuscar, usuario)) {
                return usuario; // Persona encontrada
            }
        }
        return null; // Persona no encontrada
    }

    public boolean compararUsuario(String usuarioABuscar, Usuario usuario) {
        return usuario.getLogin().getUsuario().equals(usuarioABuscar);
    }


    public String agregarUsuario(Usuario usuario) {
        String notificacion = "";
        if (validarUsuario(usuario)) {
            usuarios.add(usuario);
            notificacion = "Usuario agregado";
        } else {
            notificacion = "Usuario no agregado";
        }

        return notificacion;
    }

    private boolean validarUsuario(Usuario usuario) {
        return validarCedulaEcuatoriana(usuario.getCedula()) && (buscarUsuario(usuario.getLogin().getUsuario()) == null);
    }


    public String eliminarUsuario(Usuario usuarioAEliminar) {
        String notificacion = "";
        Usuario usuario = buscarUsuario(usuarioAEliminar.getLogin().getUsuario());
        if (usuario != null) {
            usuarios.remove(usuario);
            notificacion = "usuario eliminado";
        } else {
            notificacion = "usuario no existe";
        }
        return notificacion;
    }

    public boolean validarCedulaEcuatoriana(String cedula) {
        // Verificar si la longitud del número de cédula es 10
        if (cedula.length() != 10) {
            return false;
        }

        // Verificar si todos los caracteres son dígitos
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(cedula.charAt(i))) {
                return false;
            }
        }

        // Obtener los dos primeros dígitos (provincia)
        int provincia = Integer.parseInt(cedula.substring(0, 2));

        // Verificar si la provincia está en el rango válido (01-24)
        if (provincia > 24 || provincia < 1) {
            return false;
        }

        // Verificar el tercer dígito (tipo de documento)
        int tipoDocumento = Integer.parseInt(cedula.substring(2, 3));

        // Verificar si el tipo de documento es válido (0, 1, 2, 3)
        if (tipoDocumento < 0 || tipoDocumento > 5) {
            return false;
        }

        // Validar el dígito verificador
        int verificador = Integer.parseInt(cedula.substring(9));
        return validarDigitoVerificador(cedula.substring(0, 9), verificador);
    }

    // Método para validar el dígito verificador
    private boolean validarDigitoVerificador(String cedulaBase, int verificador) {
        int suma = 0;

        //*
        for (int i = 0; i < cedulaBase.length(); i++) {
            int digito = Character.getNumericValue(cedulaBase.charAt(i));
            digito = (i % 2 == 0) ? digito * 2 : digito;
            suma += (digito > 9) ? digito - 9 : digito;
        }

        int resultado = 10 - (suma % 10);
        if (resultado == 10) {
            resultado = 0;
        }

        return resultado == verificador;
    }

    public int CalcularResultado(int suma) {
        return suma;
    }

}
