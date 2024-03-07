package com.tdd;

import java.util.Date;

public class Pagamento {
    private double valor;
    private Date data;
    private String tipo;

    public Pagamento(double valor, Date data, String tipo) {
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public Date getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }
}
