package banco;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta cuenta = new Cuenta();

        // Agregar cuentas con saldos iniciales
        cuenta.agregarCuenta("CC1", 5000.0);
        cuenta.agregarCuenta("CC2", 10000.0);
        cuenta.agregarCuenta("CC3", 7500.0);

        int opcion;
        String cuentaSeleccionada;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Revisar saldo de una cuenta");
            System.out.println("2. Realizar transferencia");
            System.out.println("3. Convertir USD a EUR");
            System.out.println("4. Convertir EUR a USD");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                
                case 1:
                    System.out.print("Ingrese el nombre de la cuenta para revisar su saldo: ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    cuentaSeleccionada = scanner.nextLine();
                    double saldo = cuenta.revisarSaldo(cuentaSeleccionada);
                    if (saldo != -1) {
                        System.out.println("Saldo de la cuenta " + cuentaSeleccionada + ": $" + saldo);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la cuenta origen: ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    String cuentaOrigen = scanner.nextLine();
                    System.out.print("Ingrese el nombre de la cuenta destino: ");
                    String cuentaDestino = scanner.nextLine();
                    System.out.print("Ingrese el monto a transferir: ");
                    double monto = scanner.nextDouble();
                    cuenta.transferir(cuentaOrigen, cuentaDestino, monto);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad de USD a convertir a EUR: ");
                    double cantidadUSD = scanner.nextDouble();
                    Dolar dolar = new Dolar();
                    Euro euro = new Euro();
                    double cantidadEUR = dolar.convertir(cantidadUSD, euro);
                    System.out.println("$" + cantidadUSD + " USD equivale a €" + cantidadEUR + " EUR.");
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad de EUR a convertir a USD: ");
                    double cantidadEUR2 = scanner.nextDouble();
                    Euro euro2 = new Euro();
                    Dolar dolar2 = new Dolar();
                    double cantidadUSD2 = euro2.convertir(cantidadEUR2, dolar2);
                    System.out.println("€" + cantidadEUR2 + " EUR equivale a $" + cantidadUSD2 + " USD.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
