package banco;

public class Euro implements Moneda {

	@Override
	public String getSimbolo() {
		return "EUR";
	}

	@Override
	public double getFactorConversion() {
		return 0.85;
	}

	@Override
	public double convertir(double cantidad, Moneda otraMoneda) {
		return cantidad * otraMoneda.getFactorConversion();
	}

}
