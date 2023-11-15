package com.example.web;

import java.util.ArrayList;
import java.util.List;

public class Gestor_Usuario {
    private List<Usuario> listaUsuarios;

    public Gestor_Usuario() {
        this.listaUsuarios = new ArrayList<>();

    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarUsuario(String usuario){
        for (Usuario user : listaUsuarios) {
            if (user.getLogin().getUsuario().equals(usuario)) {
                return user; // Persona encontrada
            }
        }
        return null; // Persona no encontrada
    }
    public String actualizarInformacion(){
    return "implementar";
    }
    public String agregarUsuario(Usuario user){
        if(validarCedulaEcuatoriana(user.getCi()) && (buscarUsuario(user.getLogin().getUsuario())==null)){
            listaUsuarios.add(user);
            return "usuario agregado";
        }else{
            return "usuario no agregado";
        }
    }
    public String eliminarUsuario(Usuario user){
        Usuario usuario=buscarUsuario(user.getLogin().getUsuario());
        if(usuario!=null){
            listaUsuarios.remove(usuario);
            return "usuario eliminado";
        }else{
            return "usuario no existe";
        }
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
        if (provincia < 1 || provincia > 24) {
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

}
