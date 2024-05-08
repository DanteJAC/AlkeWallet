package banco;

import java.util.HashMap;
import java.util.Map;

public class Cuenta {
    private Map<String, Double> cuentas;

    // Constructor
    public Cuenta() {
        cuentas = new HashMap<>();
    }

    // Método para añadir una cuenta con su saldo inicial
    public void agregarCuenta(String cuenta, double saldoInicial) {
        cuentas.put(cuenta, saldoInicial);
    }

    // Método para revisar una cuenta específica
    public String revisarCuenta(String cuenta) {
        if (cuentas.containsKey(cuenta)) {
            double saldo = cuentas.get(cuenta);
            return "Cuenta: " + cuenta + ", Saldo: $" + saldo;
        } else {
            return "La cuenta especificada no existe.";
        }
    }

    // Método para revisar el saldo de una cuenta específica
    public double revisarSaldo(String cuenta) {
        if (cuentas.containsKey(cuenta)) {
            return cuentas.get(cuenta);
        } else {
            System.out.println("La cuenta especificada no existe.");
            return -1; // Retornar un valor negativo para indicar que la cuenta no existe
        }
    }

    // Método para realizar una transferencia entre cuentas
    public boolean transferir(String cuentaOrigen, String cuentaDestino, double monto) {
        double saldoOrigen = revisarSaldo(cuentaOrigen);
        double saldoDestino = revisarSaldo(cuentaDestino);
        
        if (saldoOrigen >= monto && saldoOrigen != -1 && saldoDestino != -1) {
            cuentas.put(cuentaOrigen, saldoOrigen - monto);
            cuentas.put(cuentaDestino, saldoDestino + monto);
            return true; // Transferencia exitosa
        } else {
            System.out.println("Error en la transferencia. Verifique que las cuentas existan y tenga saldo suficiente.");
            return false; // Transferencia fallida
        }
    }
}
