Desafio do conversor de moedas!

Mapa que armazena as taxas de conversão
    private static final Map<String, Double> taxasDeConversao = new HashMap<>();

    Método para realizar a conversão baseado no código da taxa
    private static double converter(String taxa, double valor) {
        return valor * taxasDeConversao.get(taxa);
