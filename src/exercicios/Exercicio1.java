package exercicios;


import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        final double TETO_FAIXA1 = 1100;
        final double TETO_FAIXA2 = 2203.48;
        final double TETO_FAIXA3 = 3305.22;
        final double TETO_FAIXA4 = 6433.57;

        final double ALIQUOTA_FAIXA1 = 0.075;
        final double ALIQUOTA_FAIXA2 = 0.09;
        final double ALIQUOTA_FAIXA3 = 0.12;
        final double ALIQUOTA_FAIXA4 = 0.14;

        double salary, imposto = 0;

        System.out.println("Entre com o valor do salário:");
        Scanner input = new Scanner(System.in);

        salary = Float.parseFloat(input.nextLine());

        if (salary <= TETO_FAIXA1) {
            imposto = (salary * ALIQUOTA_FAIXA1);

        } else if (salary > TETO_FAIXA1 && salary <= TETO_FAIXA2) {
            imposto = (salary * ALIQUOTA_FAIXA2);

        } else if (salary > TETO_FAIXA2 && salary <= TETO_FAIXA3) {
            imposto = (salary * ALIQUOTA_FAIXA3);

        } else if (salary > TETO_FAIXA3 && salary <= TETO_FAIXA4) {
            imposto = (salary * ALIQUOTA_FAIXA4);
        }

        System.out.println("valor do imposto é: R$" + imposto);

    }
}
