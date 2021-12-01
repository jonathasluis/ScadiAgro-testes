package exercicios.ex5_6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        Lista minhaLista = new Lista();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            int codFuncionario;
            String nomeFuncionario;
            String valorSalario;
            LocalDate dataAdmissao;

            System.out.println("\nCodigo funcionario: ");
            codFuncionario = Integer.parseInt(input.nextLine());

            if (codFuncionario == 0) {
                break;
            }

            System.out.println("Nome funcionario: ");
            nomeFuncionario = input.nextLine();

            System.out.println("Salario funcionario: ");
            valorSalario = input.nextLine();

            System.out.println("data de admissao do funcionario (dd/MM/yyyy): ");
            String dataAux = input.nextLine();
            dataAdmissao = LocalDate.parse(dataAux, formatoData);

            minhaLista.insereFim(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao);
        }

        minhaLista.imprime();
        minhaLista.imprimeReverso();

    }
}
