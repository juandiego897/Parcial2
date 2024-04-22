import java.util.Scanner;
public class CuentaBancaria {
    private String Nombre;
    private double saldo;
    public CuentaBancaria(String nombre, double SaldoInicial) {
        this.Nombre = nombre;
        this.saldo = SaldoInicial;
    }
    public void depositar(double Cantidad) {
        if (Cantidad > 0) {
            saldo += Cantidad;
            System.out.println("Depósito de $" + Cantidad + " realizado. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Error: La cantidad para depositar debe de ser mayor que 0.");
        }
    }
    public void retirar(double Cantidad) {
        if (Cantidad > 0 && saldo >= Cantidad) {
            saldo -= Cantidad;
            System.out.println("Retiro de $" + Cantidad + " realizado. Nuevo saldo: $" + saldo);
        } else if (Cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
        } else {
            System.out.println("Error: Saldo insuficiente.");
        }
    }
    public double ConsultarSaldo() {
        return saldo;
    }
    public String ConsultarCuenta() {
        return Nombre;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre que va a ser el de la cuenta: ");
        String titular = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial de la cuenta: ");
        double SaldoInicial = scanner.nextDouble();

        CuentaBancaria cuenta = new CuentaBancaria(titular, SaldoInicial);
        System.out.println("¡Bienvenido, " + cuenta.ConsultarCuenta() + "!");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + cuenta.ConsultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double CantidadDeposito = scanner.nextDouble();
                    cuenta.depositar(CantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double CantidadRetiro = scanner.nextDouble();
                    cuenta.retirar(CantidadRetiro);
                    break;
                case 4:
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
