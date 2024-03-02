package src;

import java.util.Date;
import java.util.List;

public class Fatura {
    private String cliente;
    private Date data;
    private double valor;
    private List<Pagamento> pagamentos;

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
    public List<Pagamento> getPagamentos() {
        return this.pagamentos;
    }
    public void setPagamentos(List<Pagamento> pagamentosEfetuados) {
        this.pagamentos = pagamentosEfetuados;
    }
}
