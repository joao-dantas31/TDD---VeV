package tests;

import org.junit.jupiter.api.Test;
import src.Pagamento;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagamentoTests {
    @Test
    void testCriacaoPagamento() {
        Date dataCriacao = new Date();
        Pagamento pagamento = new Pagamento(1500.0, dataCriacao, "BOLETO");

        assertEquals(1500.0, pagamento.getValor());
        assertEquals(dataCriacao, pagamento.getData());
        assertEquals("BOLETO", pagamento.getTipo());
    }
}
