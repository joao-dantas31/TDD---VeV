package src;


import java.util.ArrayList;
import java.util.List;

public class ProcessadorBoletos {
    public ProcessadorBoletos() {

    }

    public List<Pagamento> processa(Fatura fatura, List<Boleto> boletos) {
        List<Pagamento> pagamentosEfetuados = new ArrayList<>();

        for (Boleto boleto : boletos) {
            Pagamento novoPagamento = new Pagamento(boleto.getValor(), boleto.getData(), "BOLETO");

            pagamentosEfetuados.add(novoPagamento);
        }

        fatura.setPagamentos(pagamentosEfetuados);

        return pagamentosEfetuados;
    }
}
