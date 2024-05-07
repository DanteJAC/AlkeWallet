package banco;

public class Dolar implements Moneda {

	@Override
	public String getSimbolo() {
		return "USD";
	}

	@Override
	public double getFactorConversion() {
		return 1.0;
	}

	@Override
	public double convertir(double cantidad, Moneda otraMoneda) {
		return cantidad * otraMoneda.getFactorConversion();
	}

}
