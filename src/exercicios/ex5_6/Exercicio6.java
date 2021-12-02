package exercicios.ex5_6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        Lista minhaLista = new Lista();
        int quantidadeFunc;

        while (true) {
            int codFuncionario;
            String nomeFuncionario;
            String valorSalario;
            Scanner input = new Scanner(System.in);
            LocalDate dataAdmissao;
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

        //TOTAL DE FUNCIONARIOS
        quantidadeFunc = minhaLista.getTamanho();
        System.out.println("\nTotal de funcionarios: " + quantidadeFunc + "\n");

        //LISTA COMPLETA DE FUNCIONÁRIOS MOSTRANDO O TEMPO DE EMPRESA DE CADA UM DELES (NAO ORDENADO)
        Funcionario funcionario = minhaLista.getPrimeiro();

        for (int i = 0; i < quantidadeFunc; i++) {
            LocalDate dataAtual = LocalDate.now();
            String diferencaDataDias;

            diferencaDataDias = funcionario.difDate(dataAtual);
            System.out.println(funcionario + diferencaDataDias);

            funcionario = funcionario.getProximo();
        }

        //SOMA DOS SALARIO
        System.out.println("\nSoma dos salarios: R$" + Funcionario.getSomaSalario());

        //MEDIA DOS SALARIO
        System.out.println("\nMedia dos salarios: R$" + Funcionario.calculaMedia(quantidadeFunc));

        //DADOS DO MAIOR E DO MENOR SALARIO

        Funcionario funcMenorSalario = minhaLista.getPrimeiro();
        Funcionario funcMaiorSalario = minhaLista.getPrimeiro();

        Funcionario funcMenorAux = funcMenorSalario.getProximo();
        Funcionario funcMaiorAux = funcMaiorSalario.getProximo();

        for (int i = 1; i < quantidadeFunc; i++) {
            if (funcMenorSalario.convertSalario() > funcMenorAux.convertSalario()) {
                funcMenorSalario = funcMenorAux;
            } else {
                funcMenorAux = funcMenorAux.getProximo();
            }

            if (funcMaiorSalario.convertSalario() < funcMaiorAux.convertSalario()) {
                funcMaiorSalario = funcMaiorAux;
            } else {
                funcMaiorAux = funcMaiorAux.getProximo();
            }
        }

        System.out.println("\nMenor Salario: " + funcMenorSalario);
        System.out.println("\nMaior Salario: " + funcMaiorSalario);

        System.out.println("\n");

        // ORDENACAO DA LISTA DUPLAMENTE ENCADEADA

        minhaLista.ordenacaoPorCodigo();
        minhaLista.imprime();

        System.out.println("\n");

        minhaLista.ordenacaoPorNome();
        minhaLista.imprime();
    }
}
