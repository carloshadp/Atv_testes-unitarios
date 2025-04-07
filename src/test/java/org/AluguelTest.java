package org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AluguelTest {
    private Aluguel veiculoComum;
    private Aluguel veiculoCaro;

    @BeforeEach
    void setUp() {
        veiculoComum = new Aluguel("Gol", 100.0);
        veiculoCaro = new Aluguel("Ferrari", 500.0);
    }

    @Test
    void testConstrutorComValoresValidos() {
        assertEquals("Gol", veiculoComum.getModelo());
        assertEquals(100.0, veiculoComum.getValorDiaria(), 0.001);

        assertEquals("Ferrari", veiculoCaro.getModelo());
        assertEquals(500.0 * 4.5, veiculoCaro.getValorDiaria(), 0.001);
    }

    @Test
    void testConstrutorComDiariaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Aluguel("Palio", -50.0));
    }

    @Test
    void testSetValorDiaria() {
        veiculoComum.setValorDiaria(120.0);
        assertEquals(120.0, veiculoComum.getValorDiaria(), 0.001);
    }

    @Test
    void testSetValorDiariaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> veiculoComum.setValorDiaria(-10.0));
    }

    @Test
    void testCalcularCusto() {
        assertEquals(300.0, veiculoComum.calcularCusto(3), 0.001);
        assertEquals(2250.0, veiculoCaro.calcularCusto(1), 0.001);
    }

    @Test
    void testCalcularCustoComZeroDias() {
        assertThrows(IllegalArgumentException.class, () -> veiculoComum.calcularCusto(0));
    }

    @Test
    void testCalcularCustoComDiasNegativos() {
        assertThrows(IllegalArgumentException.class, () -> veiculoComum.calcularCusto(-5));
    }

    @Test
    void testDesconto() {
        assertEquals(300.0, veiculoComum.desconto(3), 0.001);


        assertEquals(630.0, veiculoComum.desconto(7), 0.001);
    }

    @Test
    void testCalcularMulta() {
        assertEquals(150.0, veiculoComum.calcularMulta(1), 0.001);
    }

    @Test
    void testCalcularMultaComDiasNegativos() {
        assertThrows(IllegalArgumentException.class, () -> veiculoComum.calcularMulta(-1));
    }

    @Test
    void testCalcularDescontoProgressivo() {
        assertEquals(500.0, veiculoComum.calcularDescontoProgressivo(5), 0.001);

        assertEquals(720.0, veiculoComum.calcularDescontoProgressivo(8), 0.001);

        assertEquals(1275.0, veiculoComum.calcularDescontoProgressivo(15), 0.001);

        assertEquals(2325.0, veiculoComum.calcularDescontoProgressivo(31), 0.001);
    }

    @Test
    void testCalcularDescontoProgressivoComZeroDias() {
        assertThrows(IllegalArgumentException.class, () -> veiculoComum.calcularDescontoProgressivo(0));
    }

    @Test
    void testModelosPremium() {
        Aluguel lamborghini = new Aluguel("Lamborghini", 600.0);
        assertEquals(600.0 * 4.5, lamborghini.getValorDiaria(), 0.001);

        Aluguel porsche = new Aluguel("Porsche", 400.0);
        assertEquals(400.0 * 4.5, porsche.getValorDiaria(), 0.001);
    }
}