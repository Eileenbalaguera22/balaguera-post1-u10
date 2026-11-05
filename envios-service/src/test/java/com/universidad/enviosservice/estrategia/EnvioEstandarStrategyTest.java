
package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioEstandarStrategyTest {

    private final EnvioEstandarStrategy estrategia =
            new EnvioEstandarStrategy();

    @ParameterizedTest
    @CsvSource({
            "3.0, 100.0, 50.0",
            "8.0, 100.0, 52.4",
            "25.0, 100.0, 68.0"
    })
    void calculaCostoPorTramoDePeso(double peso, double distancia,
                                    double esperado) {

        assertEquals(esperado,
                estrategia.calcular(peso, distancia), 0.01);
    }

    @Test
    void aplicaRecargoPorDistanciaMayorA500Km() {

        double resultado = estrategia.calcular(3.0, 600.0);

        assertEquals(310.0, resultado, 0.01);
    }
}
