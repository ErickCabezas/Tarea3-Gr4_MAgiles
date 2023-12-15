package com.example.web;

import entities.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import static entities.ConexionBD.entityManager;

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

        try {
            Thread.sleep(20);
            if (validarUsuario(usuario)) {
                usuarios.add(usuario);
                notificacion = "Usuario agregado";
            } else {
                notificacion = "Usuario no agregado";
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return notificacion;
    }

    public void insertar(entities.Usuario usuario) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(usuario);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Este es el lugar actual donde se imprime la traza de la excepción

            // Puedes agregar más detalles a la excepción y relanzarla
            throw new RuntimeException("Error durante la transacción. Detalles: " + e.getMessage(), e);
        }
    }

    public entities.Usuario buscar(String nombreUsuario, String contrasenia){
        try{
            String query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.contrasena = :constrasena";
            entities.Usuario usuario2 = new entities.Usuario();
            usuario2.setUsuario(nombreUsuario);
            usuario2.setContrasena(contrasenia);
            entities.Usuario usuarioExistente = entityManager.createQuery(query, entities.Usuario.class).setParameter("usuario", usuario2.getUsuario()).setParameter("constrasena", usuario2.getContrasena()).getSingleResult();
            if(usuarioExistente != null){
                return usuarioExistente;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private boolean validarUsuario(Usuario usuario) {
        return comprobarDatosValidos(usuario);
    }

    private boolean comprobarDatosValidos(Usuario usuario) {
        return validarCedulaEcuatoriana(usuario.getCedula()) && (buscarUsuario(usuario.getLogin().getUsuario()) == null)
                && comprobarNumeroSinLetras(usuario.getTelefono());
    }

    public boolean comprobarNumeroSinLetras(String telefono) {
        int telefonoEntero;
        try {
            telefonoEntero = Integer.parseInt(telefono);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
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
            digito = getDigito(i, digito);
            suma += getSuma(digito);
        }

        int resultado = calcularResultado(suma);
        if (resultado == 10) {
            resultado = 0;
        }
        return resultado == verificador;
    }

    public int getDigito(int i, int digito) {
        return (i % 2 == 0) ? digito * 2 : digito;
    }

    public int getSuma(int digito) {
        return (digito > 9) ? digito - 9 : digito;
    }

    public int calcularResultado(int suma) {

        return 10 - (suma % 10);
    }

}
