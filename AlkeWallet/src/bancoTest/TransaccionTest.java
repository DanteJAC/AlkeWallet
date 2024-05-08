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

    @Test	// Verifica que la función revisarSaldo devuelva el saldo correcto de la transacción
    public void testRevisarSaldo() {
        assertEquals(1000.0, transaccion.revisarSaldo());
    }

    @Test	// Comprueba que la función transferir realice una transferencia exitosa.
    public void testTransferirExitoso() {
        transaccion.transferir(789012, 500.0);
        assertEquals(500.0, transaccion.revisarSaldo());
    }

    @Test	// Asegura que la función transferir maneje correctamente el caso en el que no hay suficiente saldo en la cuenta de origen para la transferencia.
    public void testTransferirFallaPorSaldoInsuficiente() {
        transaccion.transferir(789012, 2000.0);
        assertEquals(1000.0, transaccion.revisarSaldo());
    }

    @Test	// Verifica que la función depositar aumente correctamente el saldo de la transacción.
    public void testDepositar() {
        transaccion.depositar(500.0);
        assertEquals(1500.0, transaccion.revisarSaldo());
    }

    @Test	// Asegura que la función retirar realice un retiro exitoso.
    public void testRetirarExitoso() {
        transaccion.retirar(500.0);
        assertEquals(500.0, transaccion.revisarSaldo());
    }

    @Test	// Comprueba que la función retirar maneje correctamente el caso en el que no hay suficiente saldo para el retiro.
    public void testRetirarFallaPorSaldoInsuficiente() {
        transaccion.retirar(2000.0);
        assertEquals(1000.0, transaccion.revisarSaldo());
    }
}

