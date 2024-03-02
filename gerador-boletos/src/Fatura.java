package src;

import java.util.Date;

public class Fatura {
    private String cliente;
    private Date data;
    private double valor;
    public Fatura(String cliente, Date data, double valor) {
        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
    }
    public String getCliente() {
        return cliente;
    }
    public Date getData() {
        return data;
    }
    public double getValor() {
        return valor;
    }
}
