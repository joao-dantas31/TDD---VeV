package com.tdd;

import java.util.Date;

public class Boleto {
    private String codigo;
    private Date data;
    private double valor;
    public Boleto(String codigo, Date data, double valor) {
        this.codigo = codigo;
        this.data = data;
        this.valor = valor;
    }
    public String getCodigo() {
        return this.codigo;
    }
    public Date getData() {
        return this.data;
    }
    public double getValor() {
        return this.valor;
    }
}
