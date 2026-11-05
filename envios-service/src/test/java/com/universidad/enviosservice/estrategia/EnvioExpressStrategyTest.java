
package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioExpressStrategyTest {

    private final EnvioExpressStrategy estrategia =
            new EnvioExpressStrategy();

    @ParameterizedTest
    @CsvSource({
            "3.0, 100.0, 156.0",
            "8.0, 100.0, 161.85",
            "25.0, 100.0, 198.25"
    })
    void calculaCostoPorTramoDePeso(double peso, double distancia,
                                    double esperado) {

        assertEquals(esperado,
                estrategia.calcular(peso, distancia), 0.01);
    }

    @Test
    void aplicaRecargoPorDistanciaMayorA500Km() {

        double resultado = estrategia.calcular(3.0, 600.0);

        assertEquals(968.5, resultado, 0.01);
    }
}
