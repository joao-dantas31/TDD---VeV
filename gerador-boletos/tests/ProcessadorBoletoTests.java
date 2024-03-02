package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.Boleto;
import src.Fatura;
import src.Pagamento;
import src.ProcessadorBoletos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProcessadorBoletoTests {
    @Test
    @DisplayName("Testa se o processador esta sendo criado com sucesso")
    void testCriacaoProcessadorBoletos() {
        ProcessadorBoletos pb = new ProcessadorBoletos();

        assertNotNull(pb);
    }

    @Test
    @DisplayName("Testa se o processador esta criando os pagamentos com sucesso")
    void testProcessamentoBoletos() {
        ProcessadorBoletos pb = new ProcessadorBoletos();
        Fatura fatura = new Fatura("Gabriel", new Date(), 600);

        ArrayList<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(new Boleto("1234", new Date(), 100));
        boletos.add(new Boleto("4321", new Date(), 250));
        boletos.add(new Boleto("1324", new Date(), 150));

        List<Pagamento> pagamentos = pb.processa(fatura, boletos);
        assertEquals(3, pagamentos.size());
    }
}
