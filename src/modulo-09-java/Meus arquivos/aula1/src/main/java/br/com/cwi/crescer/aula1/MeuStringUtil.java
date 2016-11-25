package br.com.cwi.crescer.aula1;

import java.text.Normalizer;
import java.util.Scanner;

public class MeuStringUtil {

    public static void main(String[] args) {
        System.out.println("--MeuStringUtil--");
        Scanner s = new Scanner(System.in);
        int entrada = -1;
        while (entrada != 0) {
            String str;
            System.out.println("Insira a sua palavra/frase:");
            str = s.next();
            System.out.println("Escolha uma operação:");
            System.out.println("1) isEmpty");
            System.out.println("2) contarVogais");
            System.out.println("3) inverter");
            System.out.println("4) isPalindrome");
            System.out.println("0) Sair");
            entrada = s.nextInt();
            String resposta = null;
            switch (entrada) {
                case 1:
                    resposta = isEmpty(str) + "";
                    break;
                case 2:
                    resposta = contarVogais(str) + "";
                    break;
                case 3:
                    resposta = inverter(str) + "";
                    break;
                case 4:
                    resposta = isPalindrome(str) + "";
                    break;
                default:
                    resposta = "Saiu";
                    break;
            }
            System.out.println("Resultado: " + resposta);
        }
    }

    private static String normalize(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static boolean isEmpty(String str) {
        return str.isEmpty();
    }

    public static int contarVogais(String str) {
        int count = 0;
        String fraseLower = str.toLowerCase();

        char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < fraseLower.length(); i++) {
            char letra = fraseLower.charAt(i);
            for (int j = 0; j < vogais.length; j++) {
                if (vogais[j] == letra) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String inverter(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        String revertedStr = inverter(str).toLowerCase();
        return normalize(str.toLowerCase()).equals(normalize(revertedStr));
    }

}
