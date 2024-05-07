package bancoTest;

import org.junit.jupiter.api.Test;

import banco.Dolar;
import banco.Moneda;
import banco.Euro;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DolarTest {
		
		// verifica el simbilo retornado sea USD //
    @Test
    void testGetSimbolo() {
        Dolar dolar = new Dolar();
        assertEquals("USD", dolar.getSimbolo(), "El símbolo debe ser USD");
    }
    	// verifica el factor de conversion. Que el valor retornado sea 1.0 //
    @Test
    void testGetFactorConversion() {
        Dolar dolar = new Dolar();
        assertEquals(1.0, dolar.getFactorConversion(), "El factor de conversión debe ser 1.0");
    }
    	// verifica que la conversion sea correcta. En este caso de UDS a EURO. //
    @Test
    void testConvertir() {
        Dolar dolar = new Dolar();
        Moneda euro = new Euro();
        double cantidadEnDolares = 100.0;
        double cantidadEnEuros = dolar.convertir(cantidadEnDolares, euro);
        assertEquals(85.0, cantidadEnEuros, "La conversión de dólares a euros debe ser 85.0");
    }
}
