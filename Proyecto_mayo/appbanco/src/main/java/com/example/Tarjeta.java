package com.example;

public class Tarjeta {
    
    private int num_tarjeta;
    private String nif;
    private Double saldo;

    public Tarjeta(int num_tarjeta, String nif, Double saldo) {
        this.num_tarjeta = num_tarjeta;
        this.nif = nif;
        this.saldo = saldo;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public String getNif() {
        return nif;
    }

    public Double getSaldo() {
        return saldo;
    }
}
