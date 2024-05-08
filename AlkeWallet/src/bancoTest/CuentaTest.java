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
    
  @Test 	//Verifica que la cuenta se agregue correctamente con el saldo inicial especificado.
    public void testAgregarCuenta() {
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
    }

  @Test 	//Comprueba que la función revisarCuenta devuelva la información correcta para una cuenta existente.
  public void testRevisarCuentaExistente() {
     assertEquals("Cuenta: CuentaCorriente1, Saldo: $5000.0", cuenta.revisarCuenta("CuentaCorriente1"));
  }

   @Test 	//Asegura que la función revisarCuenta maneje correctamente el caso en el que se especifica una cuenta que no existe.
   public void testRevisarCuentaNoExistente() {
       assertEquals("La cuenta especificada no existe.", cuenta.revisarCuenta("CuentaNoExistente"));
   } 

    @Test 	//Verifica que la función revisarSaldo devuelva el saldo correcto para una cuenta existente.
    public void testRevisarSaldoExistente() {
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
    }

    @Test	//Comprueba que la función revisarSaldo maneje correctamente el caso en el que se especifica una cuenta que no existe
    public void testRevisarSaldoNoExistente() {
        assertEquals(-1, cuenta.revisarSaldo("CuentaNoExistente"));
    }

    @Test	//Verifica que la función transferir realice una transferencia exitosa entre dos cuentas existentes.
    public void testTransferirExitoso() {
        assertTrue(cuenta.transferir("CuentaCorriente1", "CuentaCorriente2", 1000.0));
        assertEquals(4000.0, cuenta.revisarSaldo("CuentaCorriente1"));
        assertEquals(11000.0, cuenta.revisarSaldo("CuentaCorriente2"));
    }

    @Test	//Asegura que la función transferir maneje correctamente el caso en el que no hay suficiente saldo en la cuenta de origen para la transferencia
    public void testTransferirFallaPorSaldoInsuficiente() {
        assertFalse(cuenta.transferir("CuentaCorriente1", "CuentaCorriente2", 6000.0));
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
        assertEquals(10000.0, cuenta.revisarSaldo("CuentaCorriente2"));
    }

    @Test	//Comprueba que la función transferir maneje correctamente el caso en el que se especifica una cuenta de destino que no existe. 
    public void testTransferirFallaPorCuentaNoExistente() {
        assertFalse(cuenta.transferir("CuentaCorriente1", "CuentaNoExistente", 1000.0));
        assertEquals(5000.0, cuenta.revisarSaldo("CuentaCorriente1"));
    }
}
