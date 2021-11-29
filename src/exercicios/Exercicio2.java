package exercicios;

import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        double salary = 0, aliquot = 0;

        System.out.println("Entre com o valor do salário:");
        Scanner input = new Scanner(System.in);

        salary = Float.parseFloat(input.nextLine());

        if (salary <= 1100){
            aliquot = (salary * 0.075);
        }else if (salary >= 1100.01 && salary <= 2203.48){
            aliquot =  ((salary - 1100) * 0.09) + (1100 * 0.075);
        }else if (salary >= 2203.49 && salary <= 3305.22){
            aliquot =  ((salary - 2203.49) * 0.12) + ((2203.48 - 1100) * 0.09) + (1100 * 0.075) ;
        }else if (salary >= 3305.23 && salary <= 6433.57){
            aliquot =  ((salary - 3305.23) * 0.14) + ((3305.22 - 2203.49) * 0.12) + ((2203.48 - 1100) * 0.09) + (1100 * 0.075);
        }else if (salary > 6433.57){
            aliquot =  ((6433.57 - 3305.23) * 0.14) + ((3305.22 - 2203.49) * 0.12) + ((2203.48 - 1100) * 0.09) + (1100 * 0.075);
        }

        System.out.format("valor da alíquota: R$ %.2f",aliquot);
    }
}