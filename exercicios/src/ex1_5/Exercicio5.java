package ex1_5;

import ex_Funcionario.Funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();
        Funcionario funcMenorSalario, funcMaiorSalario;
        int quantidadeFunc;

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


            Funcionario funcionario = new Funcionario(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao);
            listaDeFuncionarios.add(funcionario);
        }

        //Total de funcionarios
        quantidadeFunc = listaDeFuncionarios.size();
        System.out.println("\nTotal de funcionarios: " + quantidadeFunc + "\n");

        //Lista completa de funcionários mostrando o tempo de empresa de cada um deles
        for (int i = 0; i < quantidadeFunc; i++) {
            Funcionario funcionario;
            String diferencaDataDias;

            funcionario = listaDeFuncionarios.get(i);
            diferencaDataDias = funcionario.difDate(dataAtual);

            System.out.println(funcionario + diferencaDataDias);

        }

        //Soma dos Salário
        double soma = 0;
        for (int i = 0; i < quantidadeFunc; i++) {
            soma += listaDeFuncionarios.get(i).convertSalario();
        }
        System.out.println("\nSoma dos salarios: R$" + soma);

        //Média dos Salários
        System.out.println("\nMedia dos salarios: R$" + soma / quantidadeFunc);

        //Dados do Maior e do Menor Salário
        funcMenorSalario = listaDeFuncionarios.get(0);
        funcMaiorSalario = listaDeFuncionarios.get(0);

        for (int i = 1; i < quantidadeFunc; i++) {
            if (funcMenorSalario.convertSalario() > listaDeFuncionarios.get(i).convertSalario()) {
                funcMenorSalario = listaDeFuncionarios.get(i);
            }
            if (funcMaiorSalario.convertSalario() < listaDeFuncionarios.get(i).convertSalario()) {
                funcMaiorSalario = listaDeFuncionarios.get(i);
            }
        }

        System.out.println("\nMenor Salario: " + funcMenorSalario);
        System.out.println("\nMaior Salario: " + funcMaiorSalario);

    }
}
