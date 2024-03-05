package com.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaturaTests {

    @Test
    @DisplayName("Testa se a fatura esta sendo criada com sucesso")
    void testCriacaoFatura() {
        Date dataCriacao = new Date();
        Fatura fatura = new Fatura("Gabriel Diniz", dataCriacao, 1500.0);

        assertEquals("Gabriel Diniz", fatura.getCliente());
        assertEquals(dataCriacao, fatura.getData());
        assertEquals(1500.0, fatura.getValor());
        assertEquals("PENDENTE", fatura.getEstado());
    }
}
