package bancoTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.Transaccion;

import static org.junit.jupiter.api.Assertions.*;

public class TransaccionTest {
    private Transaccion transaccion;

    @BeforeEach
    public void setUp() {
        transaccion = new Transaccion(123456, 789012, 1000.0);
    }

    @Test
    public void testRevisarSaldo() {
        assertEquals(1000.0, transaccion.revisarSaldo());
    }

    @Test
    public void testTransferirExitoso() {
        transaccion.transferir(789012, 500.0);
        assertEquals(500.0, transaccion.revisarSaldo());
    }

    @Test
    public void testTransferirFallaPorSaldoInsuficiente() {
        transaccion.transferir(789012, 2000.0);
        assertEquals(1000.0, transaccion.revisarSaldo());
    }

    @Test
    public void testDepositar() {
        transaccion.depositar(500.0);
        assertEquals(1500.0, transaccion.revisarSaldo());
    }

    @Test
    public void testRetirarExitoso() {
        transaccion.retirar(500.0);
        assertEquals(500.0, transaccion.revisarSaldo());
    }

    @Test
    public void testRetirarFallaPorSaldoInsuficiente() {
        transaccion.retirar(2000.0);
        assertEquals(1000.0, transaccion.revisarSaldo());
    }
}

