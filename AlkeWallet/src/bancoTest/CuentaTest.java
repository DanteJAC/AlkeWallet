package bancoTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.Cuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class CuentaTest {
    private Cuenta cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new Cuenta();
        cuenta.agregarCuenta("CuentaCorriente1", 5000.0);
        cuenta.agregarCuenta("CuentaCorriente2", 10000.0);
        cuenta.agregarCuenta("CuentaCorriente3", 7500.0);
    }

    @Test
    public void testAgregarCuenta() {
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
    }

  @Test
  public void testRevisarCuentaExistente() {
     assertEquals("Cuenta: CuentaCorriente1, Saldo: $5000.0", cuenta.revisarCuenta("CuentaCorriente1"));
  }

   @Test
   public void testRevisarCuentaNoExistente() {
       assertEquals("La cuenta especificada no existe.", cuenta.revisarCuenta("CuentaNoExistente"));
   } 

    @Test
    public void testRevisarSaldoExistente() {
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
    }

    @Test
    public void testRevisarSaldoNoExistente() {
        assertEquals(-1, cuenta.revisarSaldo("CuentaNoExistente"));
    }

    @Test
    public void testTransferirExitoso() {
        assertTrue(cuenta.transferir("CuentaCorriente1", "CuentaCorriente2", 1000.0));
        assertEquals(4000.0, cuenta.revisarSaldo("CuentaCorriente1"));
        assertEquals(11000.0, cuenta.revisarSaldo("CuentaCorriente2"));
    }

    @Test
    public void testTransferirFallaPorSaldoInsuficiente() {
        assertFalse(cuenta.transferir("CuentaCorriente1", "CuentaCorriente2", 6000.0));
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
        assertEquals(10000.0, cuenta.revisarSaldo("CuentaCorriente2"));
    }

    @Test
    public void testTransferirFallaPorCuentaNoExistente() {
        assertFalse(cuenta.transferir("CuentaCorriente1", "CuentaNoExistente", 1000.0));
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
    }
}
