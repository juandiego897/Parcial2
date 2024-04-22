import java.text.NumberFormat;
import java.util.Scanner;
public class TablaDeAmortizacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el monto del préstamo: ");
        double monto = scanner.nextDouble();

        System.out.print("Ingrese el plazo en meses: ");
        int plazo = scanner.nextInt();

        System.out.print("Ingrese el mes de abono adicional (0 si no hay abono): ");
        int mesDeAbono = scanner.nextInt();

        System.out.print("Ingrese el abono adicional (0 si no hay abono): ");
        double abono = scanner.nextDouble();

        double tasaBancaria = 0.0577;
        if (monto > 0 && plazo > 0) {
            double cuotaPago = calcularCuotaPago(monto, plazo, tasaBancaria);
            System.out.println("\nCuota de pago: $" + NumberFormat.getInstance().format(Math.round(cuotaPago)));
            System.out.println("Mes\tSaldo Inicial\tIntereses\tCuota\tAbono\tSaldo Final");
            double saldoFinal = monto;
            for (int i = 1; i <= plazo; i++) {
                double intereses = saldoFinal * tasaBancaria;
                double cuota = cuotaPago;
                if (i == mesDeAbono) {
                    saldoFinal -= abono;
                    if (saldoFinal < 0) {
                        saldoFinal = 0;
                    }
                }
                saldoFinal = calcularSaldoFinal(saldoFinal, cuota, intereses);
                System.out.println(i + "\t$" + NumberFormat.getInstance().format(Math.round(saldoFinal)) +
                        "\t$" + NumberFormat.getInstance().format(Math.round(intereses)) +
                        "\t$" + NumberFormat.getInstance().format(Math.round(cuota)) +
                        "\t$" + NumberFormat.getInstance().format(Math.round(abono)) +
                        "\t$" + NumberFormat.getInstance().format(Math.round(saldoFinal)));
            }
        } else {
            System.out.println("Ingrese números válidos");
        }

        scanner.close();
    }
    private static double calcularCuotaPago(double monto, int plazo, double tasa) {
        return monto * (tasa / (1 - Math.pow(1 + tasa, -plazo)));
    }
    private static double calcularSaldoFinal(double saldoInicial, double cuota, double intereses) {
        return saldoInicial + intereses - cuota;
    }
}


