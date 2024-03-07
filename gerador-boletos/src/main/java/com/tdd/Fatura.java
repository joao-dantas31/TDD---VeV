package com.tdd;

import java.util.Date;
import java.util.List;

public class Fatura {
    private String cliente;
    private Date data;
    private double valor;
    private List<Pagamento> pagamentos;
    private EstadoFatura estado;

    public Fatura(String cliente, Date data, double valor) {
        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
        this.estado = EstadoFatura.PENDENTE;
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
    public List<Pagamento> getPagamentos() {
        return this.pagamentos;
    }
    public String getEstado() {
        return this.estado.getEstado();
    }
    public void setPagamentos(List<Pagamento> pagamentosEfetuados) {
        double total = 0;
        for (Pagamento pagamento : pagamentosEfetuados) {
            total += pagamento.getValor();
        }

        if (total >= this.valor) {
            this.estado = EstadoFatura.PAGA;
        } else {
            this.estado = EstadoFatura.PENDENTE;
        }

        this.pagamentos = pagamentosEfetuados;
    }
}
