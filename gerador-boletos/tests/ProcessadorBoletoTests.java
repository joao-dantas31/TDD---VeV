package tests;

import org.junit.jupiter.api.Test;
import src.Boleto;
import src.Fatura;
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

    
}
