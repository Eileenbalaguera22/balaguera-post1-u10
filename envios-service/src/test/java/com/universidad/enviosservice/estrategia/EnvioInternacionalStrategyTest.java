
package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioInternacionalStrategyTest {

    private final EnvioInternacionalStrategy estrategia =
            new EnvioInternacionalStrategy();

    @ParameterizedTest
    @CsvSource({
            "3.0, 100.0, 230.0",
            "8.0, 100.0, 239.0",
            "25.0, 100.0, 297.5"
    })
    void calculaCostoPorTramoDePeso(double peso, double distancia,
                                    double esperado) {

        assertEquals(esperado,
                estrategia.calcular(peso, distancia), 0.01);
    }

    @Test
    void aplicaRecargoPorDistanciaMayorA5000Km() {

        double resultado = estrategia.calcular(3.0, 6000.0);

        assertEquals(10950.0, resultado, 0.01);
    }
}
