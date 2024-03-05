package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.Boleto;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoletoTests {
    @Test
    @DisplayName("Testa se o pagamento esta sendo criado com sucesso")
    void testCriacaoBoleto() {
        Date dataCriado = new Date();

        Boleto boleto = new Boleto("12345", dataCriado, 120.0);

        assertEquals("12345", boleto.getCodigo());
        assertEquals(dataCriado, boleto.getData());
        assertEquals(120.0, boleto.getValor());
    }
}
