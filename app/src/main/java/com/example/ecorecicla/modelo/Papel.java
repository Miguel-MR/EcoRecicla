package com.example.ecorecicla.modelo;

public class Papel {
    private float cantidad1;
    private String mes;

    public Papel(float cantidad, String mes) {
        this.cantidad1 = cantidad;
        this.mes = mes;
    }

    public float getCantidad() {
        return cantidad1;
    }

    public void setCantidad(float cantidad) {
        this.cantidad1 = cantidad;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
