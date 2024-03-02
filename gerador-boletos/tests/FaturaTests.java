package tests;

import org.junit.jupiter.api.Test;
import src.Fatura;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaturaTests {

    @Test
    void testCriacaoFatura() {
        Date dataCriacao = new Date();
        Fatura fatura = new Fatura("Gabriel Diniz", dataCriacao, 1500.0);

        assertEquals(fatura.getCliente(), "Gabriel Diniz");
        assertEquals(fatura.getData(), dataCriacao);
        assertEquals(fatura.getValor(), 1500.0);
    }
}
