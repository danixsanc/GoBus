package com.yozzibeens.gobus.adaptadores;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Antonio on 23/11/2016.
 */

public class AdaptadorAutobuses {

    String NombreLinea;
    String Disponibilidad;
    String Salida;
    String Destino;
    String Hora;
    String Tiempo;
    String Precio;
    Drawable Logo;

    public AdaptadorAutobuses(String nombreLinea, String disponibilidad, String salida, String destino, String hora, String tiempo, String precio, Drawable logo) {
        NombreLinea = nombreLinea;
        Disponibilidad = disponibilidad;
        Salida = salida;
        Destino = destino;
        Hora = hora;
        Tiempo = tiempo;
        Precio = precio;
        Logo = logo;
    }

    public AdaptadorAutobuses()
    {

    }


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

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getTiempo() {
        return Tiempo;
    }

    public void setTiempo(String tiempo) {
        Tiempo = tiempo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public Drawable getLogo() {
        return Logo;
    }

    public void setLogo(Drawable logo) {
        Logo = logo;
    }
}
