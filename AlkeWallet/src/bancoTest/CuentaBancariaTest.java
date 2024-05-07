package bancoTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.CuentaBancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    private CuentaBancaria cuenta;

    @BeforeEach
    void setUp() {
        // Crear una nueva cuenta antes de cada prueba
        cuenta = new CuentaBancaria(1000, "CuentaA");
    }
    	// Verifica que el saldo aumente correctamente. //
    @Test
    void testRealizarDeposito() {
        cuenta.realizarDeposito(200);
        assertEquals(1200, cuenta.consultarSaldo(), "El saldo después del depósito debe ser 1200");
    }
    	// Verifica que el saldo disminuya correctamente.
    @Test
    void testRealizarRetiro_SaldoSuficiente() {
        cuenta.realizarRetiro(150);
        assertEquals(850, cuenta.consultarSaldo(), "El saldo después del retiro debe ser 850");
    }
    	// Verifica que el saldo no cambie si no hay saldo disponible en la cuenta.//
    @Test
    void testRealizarRetiro_SaldoInsuficiente() {
        cuenta.realizarRetiro(1200);
        assertEquals(1000, cuenta.consultarSaldo(), "El saldo no debe cambiar si el retiro es mayor al saldo actual");
    }
}
