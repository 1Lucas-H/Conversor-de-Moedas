import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConversorMoedasFixo {

    // Mapa que armazena as taxas de conversão
    private static final Map<String, Double> taxasDeConversao = new HashMap<>();

    static {
        // Inicializando o mapa com as taxas fixas fornecidas
        taxasDeConversao.put("USD_BRL", 5.6852);  // 1 USD -> BRL
        taxasDeConversao.put("BRL_USD", 1 / 5.6852);  // 1 BRL -> USD
        taxasDeConversao.put("EUR_BRL", 5.6852 / 0.8791);  // 1 EUR -> BRL
        taxasDeConversao.put("BRL_EUR", 1 / (5.6852 / 0.8791));  // 1 BRL -> EUR
        taxasDeConversao.put("GBP_BRL", 5.6852 / 0.7508);  // 1 GBP -> BRL
        taxasDeConversao.put("BRL_GBP", 1 / (5.6852 / 0.7508));  // 1 BRL -> GBP
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==== CONVERSOR DE MOEDAS ====");
            System.out.println("1. Dólar (USD) ➝ Real (BRL)");
            System.out.println("2. Real (BRL) ➝ Dólar (USD)");
            System.out.println("3. Euro (EUR) ➝ Real (BRL)");
            System.out.println("4. Real (BRL) ➝ Euro (EUR)");
            System.out.println("5. Libra (GBP) ➝ Real (BRL)");
            System.out.println("6. Real (BRL) ➝ Libra (GBP)");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 7) {
                continuar = false;
                System.out.println("Programa encerrado.");
                break;
            }

            System.out.print("Digite o valor: ");
            double valor = scanner.nextDouble();

            double resultado = 0;
            String de = "", para = "";

            switch (opcao) {
                case 1 -> {
                    resultado = converter("USD_BRL", valor);
                    de = "USD"; para = "BRL";
                }
                case 2 -> {
                    resultado = converter("BRL_USD", valor);
                    de = "BRL"; para = "USD";
                }
                case 3 -> {
                    resultado = converter("EUR_BRL", valor);
                    de = "EUR"; para = "BRL";
                }
                case 4 -> {
                    resultado = converter("BRL_EUR", valor);
                    de = "BRL"; para = "EUR";
                }
                case 5 -> {
                    resultado = converter("GBP_BRL", valor);
                    de = "GBP"; para = "BRL";
                }
                case 6 -> {
                    resultado = converter("BRL_GBP", valor);
                    de = "BRL"; para = "GBP";
                }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            System.out.printf("💱 %.2f %s = %.2f %s%n", valor, de, resultado, para);
        }

        scanner.close();
    }

    // Método para realizar a conversão baseado no código da taxa
    private static double converter(String taxa, double valor) {
        return valor * taxasDeConversao.get(taxa);
    }
}

