package tests;

import org.junit.jupiter.api.Test;
import src.Boleto;
import src.Fatura;
import src.Pagamento;
import src.ProcessadorBoletos;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProcessadorBoletoTests {
    @Test
    void testCriacaoProcessadorBoletos() {
        ProcessadorBoletos pb = new ProcessadorBoletos();

        assertNotNull(pb);
    }

    @Test
    void testProcessamentoBoletos() {
        ProcessadorBoletos pb = new ProcessadorBoletos();
        Fatura fatura = new Fatura("Gabriel", new Date(), 600);

        ArrayList<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(new Boleto("1234", new Date(), 100));
        boletos.add(new Boleto("4321", new Date(), 250));
        boletos.add(new Boleto("1324", new Date(), 150));

        Pagamento pagamento = pb.processa(fatura, boletos);
    }
}
