public class CardUtils {

    public static String descobrirBandeira(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.length() < 4) {
            return "Número inválido";
        }

        // Visa: começa com 4
        if (numeroCartao.startsWith("4")) {
            return "Visa";
        }

        // MasterCard: 51-55 ou 2221-2720
        int prefix2 = Integer.parseInt(numeroCartao.substring(0, 2));
        int prefix4 = Integer.parseInt(numeroCartao.substring(0, 4));
        int prefix6 = numeroCartao.length() >= 6 ? Integer.parseInt(numeroCartao.substring(0, 6)) : -1;

        if ((prefix2 >= 51 && prefix2 <= 55) ||
            (prefix4 >= 2221 && prefix4 <= 2720)) {
            return "MasterCard";
        }

        // American Express: 34 ou 37
        if (numeroCartao.startsWith("34") || numeroCartao.startsWith("37")) {
            return "American Express";
        }

        // Diners Club 36, 38, 30
        if (numeroCartao.startsWith("36") || 
            numeroCartao.startsWith("38") || 
            numeroCartao.startsWith("30")) {
            return "Diners Club";
        }

        // Discover: 6011, 65, 644-649
        if (numeroCartao.startsWith("6011") ||
            numeroCartao.startsWith("65") ||
            (prefix3(numeroCartao) >= 644 && prefix3(numeroCartao) <= 649)) {
            return "Discover";
        }

        // Hipercard: geralmente começa com 6062
        if (numeroCartao.startsWith("6062")) {
            return "Hipercard";
        }

        // Elo: 4011, 4312, 4389, entre outros (exemplo com alguns prefixos conhecidos)
        String[] eloPrefixes = {"4011", "4312", "4389"};
        for (String prefix : eloPrefixes) {
            if (numeroCartao.startsWith(prefix)) {
                return "Elo";
            }
        }
        
        // EnRoute: 2014 ou 2149
        if (numeroCartao.startsWith("2014") || numeroCartao.startsWith("2149")) {
            return "EnRoute";
        }

        // JCB: 3528, 3529, 3530, 3531, 3532, 3533, 3534, 3535, 3536, 3537, 3538, 3539, 3568 e 3588
        String[] jcbPrefixes = {"3528", "3529", "3530", "3531", "3532", "3533", "3534", 
                                "3535", "3536", "3537", "3538", "3539", "3568", "3588"};
        for (String prefix : jcbPrefixes) {
            if (numeroCartao.startsWith(prefix)) {
                return "JCB";
            }
        }

        // Aura: começa com 50
        if (numeroCartao.startsWith("50")) {
            return "Aura";
        }

        return "Bandeira desconhecida";
    }

    private static int prefix3(String numeroCartao) {
        if (numeroCartao.length() < 3) return -1;
        return Integer.parseInt(numeroCartao.substring(0, 3));
    }
}