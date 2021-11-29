package exercicios;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        double valor = 0, valorParcela = 0;
        int numeroParcelas = 0, resto=0;

        System.out.println("Entre com o valor: ");
        Scanner input = new Scanner(System.in);

        valor = Float.parseFloat(input.nextLine());

        System.out.println("Entre com o número de parcelas: ");
        numeroParcelas = Integer.parseInt(input.nextLine());

        resto = valor % numeroParcelas;


        System.out.println(valorParcela*numeroParcelas);
    }
}
