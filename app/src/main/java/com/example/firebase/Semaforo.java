package com.example.firebase;

public class Semaforo {
    private String Sema;
    private int Larco1;
    private int cantidad;
    private String estado;
    private Double latitud;
    private Double longitud;

    public Semaforo() {
    }

    public String getSema() {
        return Sema;
    }

    public void setSema(String sema) {
        Sema = sema;
    }

    public int getLarco1() {
        return Larco1;
    }

    public void setLarco1(int larco1) {
        Larco1 = larco1;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
