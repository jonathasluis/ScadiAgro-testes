package exercicios;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        String texto, textoReverso = "";
        int quantidadeCaracteres, quantidadePalavrasTexto, contadorPalavras = 1;
        String[] palavras;

        Scanner input = new Scanner(System.in);

        System.out.println("Entre com o texto: ");
        texto = input.nextLine();

        // QUANIDADE DE CARACTERES SEM ESPAÇO

        quantidadeCaracteres = texto.trim().replaceAll(" ", "").length();
        System.out.println("Quantidade de caracteres descontando os espaços: " + quantidadeCaracteres);

        // QUANTIDADE DE PALAVRAS NO TEXTO

        palavras = texto.replaceAll("\\p{Punct}", "").split(" ");
        quantidadePalavrasTexto = palavras.length;
        System.out.println("\nQuantidade de palavras: " + quantidadePalavrasTexto + "\n");

        // NUMERO DE VEZES QUE CADA PALAVRA APARECE

        for (int i = 0; i < quantidadePalavrasTexto; i++) {
            if (palavras[i].equals("")) {
                for (int j = i + 1; j < quantidadePalavrasTexto; j++) {
                    if (palavras[i].equalsIgnoreCase(palavras[j])) {
                        contadorPalavras++;
                        palavras[j] = "";
                    }
                }

                System.out.println(palavras[i] + " " + contadorPalavras);
                contadorPalavras = 1;
            }
        }

        // ESCREVE TEXTO COM A ORDEM DAS PALAVRAS AO CONTRARIO

        for (int i = quantidadePalavrasTexto - 1; i >= 0; i--) {
            textoReverso = textoReverso.concat(palavras[i]);
            textoReverso = textoReverso.concat(" ");
        }

        System.out.println("\nREVERSO: \n" + textoReverso);

        // ESCREVE TEXTO AO CONTRARIO

        System.out.println("\nREVERSO PALAVRA POR PALAVRA: ");
        for (int i = texto.length() - 1; i >= 0; i--)
            System.out.print(texto.charAt(i));
    }
}
