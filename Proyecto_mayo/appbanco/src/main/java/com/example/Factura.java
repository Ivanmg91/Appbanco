package com.example;

public class Factura {
    
    private int num_factura;
    private String nif;
    private Double coste;
    private String fecha;
    private String concepto;

    public Factura(int num_factura, String nif, Double coste, String fecha, String concepto) {
        this.num_factura = num_factura;
        this.nif = nif;
        this.coste = coste;
        this.fecha = fecha;
        this.concepto = concepto;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public String getNif() {
        return nif;
    }

    public Double getCoste() {
        return coste;
    }

    public String getFecha() {
        return fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    
}
