package com.example.alumnosdanielhung.restaurantes;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 06/02/2017.
 */
public class RestauranteBean  implements Serializable{
    private int foto;
    private String nombre, telefono, direccion;

    public RestauranteBean(String direccion, int foto, String nombre, String telefono) {
        this.direccion = direccion;
        this.foto = foto;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
