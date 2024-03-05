package com.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagamentoTests {
    @Test
    @DisplayName("Testa se o pagamento esta sendo criado com sucesso")
    void testCriacaoPagamento() {
        Date dataCriacao = new Date();
        Pagamento pagamento = new Pagamento(1500.0, dataCriacao, "BOLETO");

        assertEquals(1500.0, pagamento.getValor());
        assertEquals(dataCriacao, pagamento.getData());
        assertEquals("BOLETO", pagamento.getTipo());
    }
}
