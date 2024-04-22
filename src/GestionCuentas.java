import java.util.Scanner;
public class GestionCuentas {
    private Scanner Scanner;
    public GestionCuentas() {
        Scanner = new Scanner(System.in);
    }
    public void GestionarCuentaBancaria() {
        System.out.print("Ingrese su nombre que va a ser el de la cuenta: ");
        String Nombre = Scanner.nextLine();
        System.out.print("Ingrese el saldo inicial de la cuenta: ");
        double SaldoInicial = Scanner.nextDouble();
        CuentaBancaria Cuenta = new CuentaBancaria(Nombre, SaldoInicial);
        System.out.println("¡Bienvenido, " + Cuenta.ConsultarCuenta() + "!");
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");

            int opcion = Scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + Cuenta.ConsultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double CantidadDeposito = Scanner.nextDouble();
                    Cuenta.depositar(CantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double CantidadRetiro = Scanner.nextDouble();
                    Cuenta.retirar(CantidadRetiro);
                    break;
                case 4:
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    Scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
    public void GestionarCuentaCorriente() {
        System.out.print("Ingrese el nombre de la cuenta corriente: ");
        String titular = Scanner.nextLine();

        System.out.print("Ingrese el saldo inicial de la cuenta corriente: ");
        double SaldoInicial = Scanner.nextDouble();

        System.out.print("Ingrese el límite de sobregiro de la cuenta corriente: ");
        double LimiteSobregiro = Scanner.nextDouble();

        CuentaCorriente Cuenta = new CuentaCorriente(titular, SaldoInicial, LimiteSobregiro);
        System.out.println("¡Bienvenido, " + Cuenta.ConsultarCuenta() + "!");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Consultar límite de sobregiro");
            System.out.println("5. Salir");
            int opcion = Scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + Cuenta.ConsultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = Scanner.nextDouble();
                    Cuenta.Depositar(cantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double CantidadRetiro = Scanner.nextDouble();
                    Cuenta.Retirar(CantidadRetiro);
                    break;
                case 4:
                    System.out.println("Límite de sobregiro: $" + Cuenta.ConsultarLimiteSobregiro());
                    break;
                case 5:
                    System.out.println("¡Gracias, hasta luego ;)");
                    Scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
    public void GestionarCuentaAhorro() {
        System.out.print("Ingrese el nombre de la cuenta de ahorro: ");
        String Nombre = Scanner.nextLine();

        System.out.print("Ingrese el saldo inicial de la cuenta de ahorro: ");
        double SaldoInicial = Scanner.nextDouble();

        System.out.print("Ingrese la tasa de interés anual (%): ");
        double TasaInteres = Scanner.nextDouble() / 100.0;

        CuentaAhorro Cuenta = new CuentaAhorro(Nombre, SaldoInicial, TasaInteres);
        System.out.println("¡Bienvenido, " + Cuenta.ConsultarCuenta() + "!");
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Calcular intereses");
            System.out.println("5. Salir");

            int opcion = Scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + Cuenta.ConsultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double CantidadDeposito = Scanner.nextDouble();
                    Cuenta.Depositar(CantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = Scanner.nextDouble();
                    Cuenta.Retirar(cantidadRetiro);
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad de meses para calcular los intereses: ");
                    int meses = Scanner.nextInt();
                    Cuenta.CalcularIntereses(meses);
                    break;
                case 5:
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    Scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
    public static void main(String[] args) {
        GestionCuentas GestionCuentas = new GestionCuentas();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de cuenta que desea gestionar:");
        System.out.println("1. Cuenta Bancaria");
        System.out.println("2. Cuenta Corriente");
        System.out.println("3. Cuenta de Ahorro");
        System.out.print("Ingrese el número correspondiente a la opción deseada: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                GestionCuentas.GestionarCuentaBancaria();
                break;
            case 2:
                GestionCuentas.GestionarCuentaCorriente();
                break;
            case 3:
                GestionCuentas.GestionarCuentaAhorro();
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }
    }
}
