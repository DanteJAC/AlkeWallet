package bancoTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.CuentaBancaria;
import banco.Transaccion;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransaccionTest {

    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;

    @BeforeEach
    void setUp() {
        cuentaOrigen = new CuentaBancaria(1000, "CuentaA");
        cuentaDestino = new CuentaBancaria(2000, "CuentaB");
    }

    @Test
    void testRealizarTransferencia_SaldoSuficiente() {
        Transaccion miTransaccion = new Transaccion("CuentaA", "CuentaB", 50);
        miTransaccion.realizar(cuentaOrigen, cuentaDestino);

        assertEquals(950, cuentaOrigen.consultarSaldo(), "El saldo de CuentaA después de la transferencia debe ser 950");
        assertEquals(2050, cuentaDestino.consultarSaldo(), "El saldo de CuentaB después de la transferencia debe ser 2050");
    }

    @Test
    void testRealizarTransferencia_SaldoInsuficiente() {
        Transaccion miTransaccion = new Transaccion("CuentaA", "CuentaB", 1200);
        miTransaccion.realizar(cuentaOrigen, cuentaDestino);

        assertEquals(1000, cuentaOrigen.consultarSaldo(), "El saldo de CuentaA no debe cambiar si la transferencia es mayor al saldo actual");
        assertEquals(2000, cuentaDestino.consultarSaldo(), "El saldo de CuentaB no debe cambiar si la transferencia es mayor al saldo actual");
    }
}