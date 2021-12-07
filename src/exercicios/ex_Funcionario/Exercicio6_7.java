package exercicios.ex_Funcionario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio6_7 {

    public static void main(String[] args) {
        Lista minhaLista = new Lista();
        int quantidadeFunc;

        final String ARQUIVO_NAO_INDEXADO = "src/exercicios/ex_Funcionario/funcionario.dat";
        final String ARQUIVO_INDEXADO_CODIGO = "src/exercicios/ex_Funcionario/funcionario_idx01.idx";
        final String ARQUIVO_INDEXADO_NOME = "src/exercicios/ex_Funcionario/funcionario_idx02.idx";

        while (true) {
            int codFuncionario;
            String nomeFuncionario;
            String valorSalario;
            LocalDate dataAdmissao;
            Scanner input = new Scanner(System.in);
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // CODIGO
            System.out.println("\nCodigo funcionario: ");
            codFuncionario = Integer.parseInt(input.nextLine());

            if (codFuncionario == 0) {
                break;
            }

            //NOME
            System.out.println("Nome funcionario: ");
            nomeFuncionario = input.nextLine();

            //SALARIO
            System.out.println("Salario funcionario: ");
            valorSalario = input.nextLine();

            //DATA
            System.out.println("data de admissao do funcionario (dd/MM/yyyy): ");
            String dataAux = input.nextLine();
            dataAdmissao = LocalDate.parse(dataAux, formatoData);

            minhaLista.insereFim(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao);
        }

        //TOTAL DE FUNCIONARIOS
        quantidadeFunc = minhaLista.getTamanho();
        System.out.println("\nTotal de funcionarios: " + quantidadeFunc + "\n");

        //LISTA COMPLETA DE FUNCIONÁRIOS MOSTRANDO O TEMPO DE EMPRESA DE CADA UM DELES (NAO ORDENADO)
        minhaLista.diferencaDataTodosFunc();

        //SOMA DOS SALARIO
        double somaSalarios = minhaLista.getSomaSalarios();
        System.out.println("\nSoma dos salarios: R$" + somaSalarios);

        //MEDIA DOS SALARIO
        System.out.println("\nMedia dos salarios: R$" + minhaLista.mediaSalarios(somaSalarios));

        //DADOS DO MAIOR E DO MENOR SALARIO
        System.out.println("\nMenor Salario: " + minhaLista.menorSalario().getValorSalario());
        System.out.println("\nMaior Salario: " + minhaLista.maiorSalario().getValorSalario());

        // GRAVA A LISTA NA ORDEM DE INSERCAO
        try {
            minhaLista.gravaLista(ARQUIVO_NAO_INDEXADO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nLISTA NAO ORDENADA:");
        minhaLista.imprime();

        // ORDENACAO DA LISTA DUPLAMENTE ENCADEADA PELO CODIGO E GRAVACAO NO ARQUIVO
        minhaLista.ordenacaoPorCodigo();

        try {
            minhaLista.gravaLista(ARQUIVO_INDEXADO_CODIGO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nLISTA ORDENADA POR CODIGO:");
        minhaLista.imprime();

        // ORDENACAO DA LISTA DUPLAMENTE ENCADEADA PELO NOME E GRAVACAO NO ARQUIVO
        minhaLista.ordenacaoPorNome();

        try {
            minhaLista.gravaLista(ARQUIVO_INDEXADO_NOME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nLISTA ORDENADA POR NOME:");
        minhaLista.imprime();
    }
}
