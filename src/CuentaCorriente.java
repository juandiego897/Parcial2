import java.util.Scanner;
public class CuentaCorriente {
    private String Nombre;
    private double Saldo;
    private double LimiteSobregiro;
    public CuentaCorriente(String Nombre, double SaldoInicial, double LimiteSobregiro) {
        this.Nombre = Nombre;
        this.Saldo = SaldoInicial;
        this.LimiteSobregiro = LimiteSobregiro;
    }
    public void Depositar(double Cantidad) {
        if (Cantidad > 0) {
            Saldo += Cantidad;
            System.out.println("Depósito de $" + Cantidad + " realizado. Nuevo saldo: $" + Saldo);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
        }
    }
    public void Retirar(double Cantidad) {
        if (Cantidad > 0 && Saldo + LimiteSobregiro >= Cantidad) {
            Saldo -= Cantidad;
            System.out.println("Retiro de $" + Cantidad + " realizado. Nuevo saldo: $" + Saldo);
        } else if (Cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
        } else {
            System.out.println("Error: Saldo insuficiente. El límite de sobregiro es de $" + LimiteSobregiro);
        }
    }
    public double ConsultarSaldo() {
        return Saldo;
    }
    public double ConsultarLimiteSobregiro() {
        return LimiteSobregiro;
    }
    public String ConsultarCuenta() {
        return Nombre;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la cuenta corriente: ");
        String titular = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial de la cuenta corriente: ");
        double SaldoInicial = scanner.nextDouble();

        System.out.print("Ingrese el límite de sobregiro de la cuenta corriente: ");
        double LimiteSobregiro = scanner.nextDouble();

        CuentaCorriente Cuenta = new CuentaCorriente(titular, SaldoInicial, LimiteSobregiro);
        System.out.println("¡Bienvenido, " + Cuenta.ConsultarCuenta()+ "!");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Consultar límite de sobregiro");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + Cuenta.ConsultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double CantidadDeposito = scanner.nextDouble();
                    Cuenta.Depositar(CantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double CantidadRetiro = scanner.nextDouble();
                    Cuenta.Retirar(CantidadRetiro);
                    break;
                case 4:
                    System.out.println("Límite de sobregiro: $" + Cuenta.ConsultarLimiteSobregiro());
                    break;
                case 5:
                    System.out.println("¡Gracias, hasta luego ;)");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
