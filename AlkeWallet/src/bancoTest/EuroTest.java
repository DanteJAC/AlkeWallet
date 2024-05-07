package bancoTest;

import org.junit.jupiter.api.Test;

import banco.Euro;
import banco.Moneda;
import banco.Dolar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuroTest {
	
	// verifica el simbilo retornado sea EUR //
    @Test
    void testGetSimbolo() {
        Euro euro = new Euro();
        assertEquals("EUR", euro.getSimbolo(), "El símbolo debe ser EUR");
    }
    // verifica el factor de conversion. Que el valor retornado sea 0.85 //
    @Test
    void testGetFactorConversion() {
        Euro euro = new Euro();
        assertEquals(0.85, euro.getFactorConversion(), "El factor de conversión debe ser 0.85");
    }
    // verifica que la conversion sea correcta. En este caso de EUR a USD. //
    @Test
    void testConvertir() {
        Euro euro = new Euro();
        Moneda dolar = new Dolar();
        double cantidadEnEuros = 100.0;
        double cantidadEnDolares = euro.convertir(cantidadEnEuros, dolar);
        assertEquals(85.0, cantidadEnDolares, "La conversión de euros a dólares debe ser 85.0");
    }
}
