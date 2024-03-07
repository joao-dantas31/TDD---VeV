package com.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProcessadorBoletoTests {
    private ProcessadorBoletos pb;
    private Fatura fatura;
    private List<Boleto> boletos;

    @BeforeEach
    void setUp() {
        pb = new ProcessadorBoletos();
        fatura = new Fatura("Gabriel", new Date(), 600);

        boletos = new ArrayList<Boleto>();
        boletos.add(new Boleto("1234", new Date(), 100));
        boletos.add(new Boleto("4321", new Date(), 250));
        boletos.add(new Boleto("1324", new Date(), 250));
    }

    @Test
    @DisplayName("Testa se o processador esta sendo criado com sucesso")
    void testCriacaoProcessadorBoletos() {
        ProcessadorBoletos pb = new ProcessadorBoletos();

        assertNotNull(pb);
    }

    @Test
    @DisplayName("Testa se o processador esta criando os pagamentos com sucesso")
    void testProcessamentoBoletos() {
        List<Pagamento> pagamentos = pb.processa(fatura, boletos);

        assertEquals(3, pagamentos.size());
    }

    @Test
    @DisplayName("Testa se os pagamentos estao sendo associados a fatura apos processar boletos")
    void testPagamentoAssociacaoFatura() {
        List<Pagamento> pagamentos = pb.processa(fatura, boletos);

        assertEquals(pagamentos, fatura.getPagamentos());
        assertEquals(3, fatura.getPagamentos().size());
    }

    @Test
    @DisplayName("Testa se o estado da fatura esta sendo trocado ao efetuar um pagamento igual")
    void testPagamentosIgualValorFatura() {
        List<Pagamento> pagamentos = pb.processa(fatura, boletos);

        assertEquals(3, pagamentos.size());
        assertEquals("PAGA", fatura.getEstado());
    }

    @Test
    @DisplayName("Testa se o estado da fatura esta sendo trocado ao efetuar um pagamento maior")
    void testPagamentosAcimaValorFatura() {
        boletos.add(new Boleto("134", new Date(), 250));
        List<Pagamento> pagamentos = pb.processa(fatura, boletos);

        assertEquals(4, pagamentos.size());
        assertEquals("PAGA", fatura.getEstado());
    }


    @Test
    @DisplayName("Testa se o estado da fatura se mantem o mesmo ao efetuar um pagamento menor")
    void testPagamentosAbaixoValorFatura() {
        Fatura fatura = new Fatura("Gabriel", new Date(), 500);

        ArrayList<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(new Boleto("1234", new Date(), 100));
        boletos.add(new Boleto("4321", new Date(), 50));
        boletos.add(new Boleto("1324", new Date(), 150));

        List<Pagamento> pagamentos = pb.processa(fatura, boletos);

        assertEquals(3, pagamentos.size());
        assertEquals("PENDENTE", fatura.getEstado());
    }
}
