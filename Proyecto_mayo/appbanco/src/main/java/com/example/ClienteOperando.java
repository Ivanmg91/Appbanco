package com.example;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class ClienteOperando {
    
    private String nif;
    private String nombre;
    private String contrasena;
    private ArrayList<ObservableList<String>> transacciones;

    public ClienteOperando(String nif, String nombre, String contrasena, ArrayList<ObservableList<String>> transacciones) {
        this.nif = nif;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.transacciones = transacciones;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<ObservableList<String>> getTransacciones() {
        return transacciones;
    }
    
    
}
