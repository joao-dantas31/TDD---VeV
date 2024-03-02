package src;

import java.util.Date;
import java.util.List;

public class Fatura {
    private String cliente;
    private Date data;
    private double valor;
    private List<Pagamento> pagamentos;
    private String estado;

    public Fatura(String cliente, Date data, double valor) {
        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
        this.estado = "PENDENTE";
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
        return this.estado;
    }
    public void setPagamentos(List<Pagamento> pagamentosEfetuados) {
        double total = 0;
        for (Pagamento pagamento : pagamentosEfetuados) {
            total += pagamento.getValor();
        }

        if (total >= this.valor) {
            this.estado = "PAGA";
        } else {
            this.estado = "PENDENTE";
        }

        this.pagamentos = pagamentosEfetuados;
    }
}
