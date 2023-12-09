package com.example.ecorecicla.modelo;

public class Usuario {
    private String nombre;
    private String correo;
    private String celular;
    private String contraseña;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario(String nombre, String correo, String celular, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.contraseña = contraseña;
    }
}

