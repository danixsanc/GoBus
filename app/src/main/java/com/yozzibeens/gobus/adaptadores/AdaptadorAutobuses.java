package com.yozzibeens.gobus.adaptadores;

/**
 * Created by Antonio on 23/11/2016.
 */

public class AdaptadorAutobuses {

    public String getNombreLinea() {
        return NombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        NombreLinea = nombreLinea;
    }

    public String getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        Disponibilidad = disponibilidad;
    }

    public String getSalida() {
        return Salida;
    }

    public void setSalida(String salida) {
        Salida = salida;
    }

    public AdaptadorAutobuses(String nombreLinea, String disponibilidad, String salida) {
        NombreLinea = nombreLinea;
        Disponibilidad = disponibilidad;
        Salida = salida;
    }

    public AdaptadorAutobuses(){

    }

    String NombreLinea;
    String Disponibilidad;
    String Salida;

}
