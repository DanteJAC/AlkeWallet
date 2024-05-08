package banco;

public class Transaccion {
    private double montoActual;

    // Constructor
    public Transaccion(int cuentaOrigen, int cuentaDestino, double montoActual) {
        this.montoActual = montoActual;
    }

    // Método para revisar saldo
    public double revisarSaldo() {
        return montoActual;
    }

    // Método para realizar transferencias
    public void transferir(int cuentaDestino, double monto) {
        if (monto <= montoActual) {
            montoActual -= monto;
            System.out.println("Transferencia de $" + monto + " a la cuenta " + cuentaDestino + " realizada.");
        } else {
            System.out.println("No hay fondos suficientes para realizar la transferencia.");
        }
    }

    // Método para realizar depósitos
    public void depositar(double monto) {
        montoActual += monto;
        System.out.println("Depósito de $" + monto + " realizado. Nuevo saldo: $" + montoActual);
    }

    // Método para realizar retiros
    public void retirar(double monto) {
        if (monto <= montoActual) {
            montoActual -= monto;
            System.out.println("Retiro de $" + monto + " realizado. Nuevo saldo: $" + montoActual);
        } else {
            System.out.println("No hay fondos suficientes para realizar el retiro.");
        }
    }
}
