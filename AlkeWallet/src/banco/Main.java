package banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear cuentas bancarias con saldos iniciales
        CuentaBancaria cuenta1 = new CuentaBancaria(1000, "CuentaA");
        CuentaBancaria cuenta2 = new CuentaBancaria(2000, "CuentaB");

        // Realizar depósito en cuenta1
        cuenta1.realizarDeposito(300);

        // Realizar retiro en cuenta2
        cuenta2.realizarRetiro(150);

        // Realizar una transacción de cuenta1 a cuenta2
        Transaccion miTransaccion = new Transaccion("CuentaA", "CuentaB", 50);
        miTransaccion.realizar(cuenta1, cuenta2);

        // Consultar saldos después de las operaciones
        double saldoCuenta1 = cuenta1.consultarSaldo();
        double saldoCuenta2 = cuenta2.consultarSaldo();

        System.out.println("Saldo actual de CuentaA: $" + saldoCuenta1);
        System.out.println("Saldo actual de CuentaB: $" + saldoCuenta2);

        // Realizar cambio de moneda
        Moneda dolar = new Dolar();
        Moneda euro = new Euro();
        double cantidadEnDolares = 100.0;
        double cantidadEnEuros = dolar.convertir(cantidadEnDolares, euro);

        System.out.println(cantidadEnDolares + " dólares = " + cantidadEnEuros + " euros");

        // Cerrar el scanner
        scanner.close();
    }
}
