import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorMoedas {
    // Função para fazer a requisição HTTP e obter a taxa de câmbio
    public static double getTaxaDeCambio(String moedaOrigem, String moedaDestino) {
        try {
            // URL da API
            String urlString = "https://v6.exchangerate-api.com/v6/3be13650ccaa63cd3c0277c8/latest/" + moedaOrigem;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Usando Gson para parsear o JSON
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject taxasDeCambio = jsonResponse.getAsJsonObject("conversion_rates");

            // Verificando se a moeda destino existe no JSON
            if (taxasDeCambio.has(moedaDestino)) {
                return taxasDeCambio.get(moedaDestino).getAsDouble();
            } else {
                System.out.println("Moeda de destino não disponível.");
                return 0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // Função principal que lida com o menu e a interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione a conversão de moeda:");
            System.out.println("1. USD -> ARS");
            System.out.println("2. USD -> BOB");
            System.out.println("3. USD -> BRL");
            System.out.println("4. USD -> CLP");
            System.out.println("5. USD -> COP");
            System.out.println("6. ARS -> USD");
            System.out.println("7. BOB -> USD");
            System.out.println("8. BRL -> USD");
            System.out.println("9. CLP -> USD");
            System.out.println("10. COP -> USD");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            String moedaOrigem = "USD"; // Default moeda origem
            String moedaDestino = "";

            switch (opcao) {
                case 1:
                    moedaDestino = "ARS";
                    break;
                case 2:
                    moedaDestino = "BOB";
                    break;
                case 3:
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaDestino = "CLP";
                    break;
                case 5:
                    moedaDestino = "COP";
                    break;
                case 6:
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                    break;
                case 7:
                    moedaOrigem = "BOB";
                    moedaDestino = "USD";
                    break;
                case 8:
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    break;
                case 9:
                    moedaOrigem = "CLP";
                    moedaDestino = "USD";
                    break;
                case 10:
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            System.out.print("Informe o valor a ser convertido de " + moedaOrigem + " para " + moedaDestino + ": ");
            double valor = scanner.nextDouble();

            // Obtendo a taxa de câmbio dinâmica
            double taxa = getTaxaDeCambio(moedaOrigem, moedaDestino);

            if (taxa != 0.0) {
                double valorConvertido = valor * taxa;
                System.out.printf("O valor de %.2f %s é igual a %.2f %s\n", valor, moedaOrigem, valorConvertido, moedaDestino);
            } else {
                System.out.println("Não foi possível obter a taxa de câmbio. Tente novamente mais tarde.");
            }
        }

        scanner.close();
    }
}
