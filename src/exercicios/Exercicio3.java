package exercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        BigDecimal valorEmprestimo;
        BigDecimal auxiliarDiv;
        BigDecimal auxiliarValor;
        int numeroParcelas;
        BigDecimal[] valorParcela;


        Scanner input = new Scanner(System.in);

        System.out.println("Entre com o valor do emprestimo: ");
        valorEmprestimo = new BigDecimal(input.nextLine());


        System.out.println("Entre com o numero de parcelas: ");
        numeroParcelas = Integer.parseInt(input.nextLine());

        valorParcela = new BigDecimal[numeroParcelas];
        auxiliarDiv = valorEmprestimo.divide(BigDecimal.valueOf(numeroParcelas), 2, RoundingMode.HALF_DOWN);

        for (int i = 0; i < numeroParcelas; i++) {
            valorParcela[i] = auxiliarDiv;
        }

        auxiliarValor = new BigDecimal(0);

        for (int i = 0; i < numeroParcelas; i++) {
            auxiliarValor = auxiliarValor.add(valorParcela[i]);
        }

        auxiliarValor = valorEmprestimo.subtract(auxiliarValor);

        if (!auxiliarValor.equals(BigDecimal.ZERO)) {
            valorParcela[numeroParcelas - 1] = valorParcela[numeroParcelas - 1].add(auxiliarValor);
        }

        for (int i = 0; i < numeroParcelas; i++) {
            System.out.println("PARCELA " + (i + 1) + ": " + valorParcela[i]);
        }
    }
}
