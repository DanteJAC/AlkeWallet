package banco;

public class Transaccion {
    private String origen;
    private String destino;
    private double monto;

    // Constructor
    public Transaccion(String origen, String destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }
   
    // Método para realizar la transacción
    public void realizar(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino) {
        // Verificar si la cuenta de origen tiene suficientes fondos
        if (cuentaOrigen.consultarSaldo() >= monto) {
            // Realizar la transferencia
            cuentaOrigen.realizarRetiro(monto);
            cuentaDestino.realizarDeposito(monto);
            System.out.println("Transferencia realizada: $" + monto + " de " + cuentaOrigen.getNumeroCuenta() + " a " + cuentaDestino.getNumeroCuenta());
        } else {
        	
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    
 
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	
}