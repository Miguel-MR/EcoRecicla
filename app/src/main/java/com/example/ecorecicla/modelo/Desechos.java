package com.example.ecorecicla.modelo;

public class Desechos  {
    private float cantidad;
    private String mes;

    public Desechos(float cantidad, String mes) {
        this.cantidad = cantidad;
        this.mes = mes;
    }
    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}

