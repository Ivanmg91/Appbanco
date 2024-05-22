package com.example;

public class Cliente {
    private String nif;
    private String contrasena;
    private String nombre;
    private String apellidos;

    public Cliente(String nif, String contrasena, String nombre, String apellidos) {
        this.nif = nif;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
       }

    public String getNif() {
        return nif;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    /*
     * Funcion para validar un NIF
     */

    protected  Boolean validaNIF() {
        if (nif.length() == 9 && nif.substring(8).equals("A") || nif.substring(8).equals("B")
                || nif.substring(8).equals("C") || nif.substring(8).equals("D") || nif.substring(8).equals("E")
                || nif.substring(8).equals("F") || nif.substring(8).equals("G") || nif.substring(8).equals("H")
                || nif.substring(8).equals("J") || nif.substring(8).equals("N") || nif.substring(8).equals("P")
                || nif.substring(8).equals("Q") || nif.substring(8).equals("R") || nif.substring(8).equals("S")
                || nif.substring(8).equals("U") || nif.substring(8).equals("V") || nif.substring(8).equals("W")
                || nif.substring(8).equals("X") || nif.substring(8).equals("Y") || nif.substring(8).equals("Z")) {
                return true; //Es un NIF valido
            } else {
                return false; //No es un NIF valido
            }
        }

    
}
