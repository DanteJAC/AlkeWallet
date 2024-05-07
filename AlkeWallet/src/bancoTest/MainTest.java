package bancoTest;

import org.junit.jupiter.api.Test;

import banco.CuentaBancaria;
import banco.Transaccion;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void testMain() {
        // Crear cuentas bancarias con saldos iniciales
        CuentaBancaria cuenta1 = new CuentaBancaria(1000, "CuentaA");
        CuentaBancaria cuenta2 = new CuentaBancaria(2000, "CuentaB");

        // Realizar depósito en cuenta1
        cuenta1.realizarDeposito(300);

        // Realizar retiro en cuenta2
        cuenta2.realizarRetiro(150);

        // Realizar una transacción de cuenta1 a cuenta2
        Transaccion miTransaccion = new Transaccion("CuentaA", "CuentaB", 50);
        miTransaccion.realizar(cuenta1, cuenta2);

        // Consultar saldos después de las operaciones
        double saldoCuenta1 = cuenta1.consultarSaldo();
        double saldoCuenta2 = cuenta2.consultarSaldo();

        // Verificar los resultados esperados
        assertEquals(1250, saldoCuenta1, "El saldo de CuentaA después de las operaciones debe ser 1250");
        assertEquals(1900, saldoCuenta2, "El saldo de CuentaB después de las operaciones debe ser 1900");
    }
}
