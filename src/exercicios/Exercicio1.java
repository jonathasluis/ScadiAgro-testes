package exercicios;


import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        double salary = 0.f, aliquot = 0.f;

        System.out.println("Entre com o valor do salário:");
        Scanner input = new Scanner(System.in);

        salary = Float.parseFloat(input.nextLine());

        if (salary <= 1100){
            aliquot = (salary * 0.075);
        }else if (salary >= 1100.01 && salary <= 2203.48){
            aliquot = (salary * 0.09);
        }else if (salary >= 2203.49 && salary <= 3305.22){
            aliquot = (salary * 0.12);
        }else if (salary >= 3305.23 && salary <= 6433.57){
            aliquot = (salary * 0.14);
        }

        System.out.println("valor da alíquota: R$"+ aliquot);

    }
}
