package bancoTest;

import org.junit.jupiter.api.Test;
import banco.Moneda;
import banco.Euro;
import banco.Dolar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonedaTest {
	// verifica el simbilo retornado sea EUR //
    @Test
    void testGetSimbolo() {
        Moneda euro = new Euro();
        assertEquals("EUR", euro.getSimbolo(), "El símbolo debe ser EUR");
    }
    // verifica el factor de conversion. Que el valor retornado sea 0.85 //
    @Test
    void testGetFactorConversion() {
        Moneda euro = new Euro();
        assertEquals(0.85, euro.getFactorConversion(), "El factor de conversión debe ser 0.85");
    }
    // verifica que la conversion sea correcta. En este caso de EUR a USD. //
    @Test
    void testConvertir() {
        Moneda dolar = new Dolar();
        Moneda euro = new Euro();
        double cantidadEnDolares = 100.0;
        double cantidadEnEuros = dolar.convertir(cantidadEnDolares, euro);
        assertEquals(85.0, cantidadEnEuros, "La conversión de dólares a euros debe ser 85.0");
    }
}
