import java.util.Scanner;
public class CuentaAhorro {
    private String Nombre;
    private double Saldo;
    private double TasaInteres;
    public CuentaAhorro(String titular, double SaldoInicial, double TasaInteres) {
        this.Nombre = Nombre;
        this.Saldo = SaldoInicial;
        this.TasaInteres = TasaInteres;
    }
    public void Depositar(double Cantidad) {
        if (Cantidad > 0) {
            Saldo += Cantidad;
            System.out.println("Depósito de $" + Cantidad + " realizado. Nuevo saldo: $" + Saldo);
        } else {
            System.out.println("Error, La cantidad para depositar debe ser mayor que cero.");
        }
    }
    public void Retirar(double Cantidad) {
        if (Cantidad > 0 && Saldo >= Cantidad) {
            Saldo -= Cantidad;
            System.out.println("Retiro de $" + Cantidad + " realizado. Nuevo saldo: $" + Saldo);
        } else if (Cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
        } else {
            System.out.println("Error: Saldo insuficiente.");
        }
    }
    public void CalcularIntereses(int Meses) {
        double Intereses = Saldo * TasaInteres * Meses / 12.0;
        Saldo += Intereses;
        System.out.println("Intereses en " + Meses + " meses: $" + Intereses);
        System.out.println("Nuevo saldo con intereses: $" + Saldo);
    }
    public double ConsultarSaldo() {
        return Saldo;
    }
    public String ConsultarCuenta() {
        return Nombre;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la cuenta de ahorro: ");
        String titular = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial de la cuenta de ahorro: ");
        double SaldoInicial = scanner.nextDouble();

        System.out.print("Ingrese la tasa de interés anual (%): ");
        double TasaInteres = scanner.nextDouble() / 100.0;

        CuentaAhorro Cuenta = new CuentaAhorro(titular, SaldoInicial, TasaInteres);
        System.out.println("¡Bienvenido, " + Cuenta.ConsultarCuenta() + "!");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Calcular intereses");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + Cuenta.ConsultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    Cuenta.Depositar(cantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double CantidadRetiro = scanner.nextDouble();
                    Cuenta.Retirar(CantidadRetiro);
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad de meses para calcular los intereses: ");
                    int meses = scanner.nextInt();
                    Cuenta.CalcularIntereses(meses);
                    break;
                case 5:
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}

