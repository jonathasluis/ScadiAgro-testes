package exercicios.ex_Funcionario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InsertFuncionario {

    public static void insert() {
        Lista minhaListaOriginal = new Lista();
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

            minhaListaOriginal.insereFim(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao);
        }

        //TOTAL DE FUNCIONARIOS
        quantidadeFunc = minhaListaOriginal.getTamanho();
        System.out.println("\nTotal de funcionarios: " + quantidadeFunc + "\n");

        //LISTA COMPLETA DE FUNCIONÁRIOS MOSTRANDO O TEMPO DE EMPRESA DE CADA UM DELES (NAO ORDENADO)
        minhaListaOriginal.diferencaDataTodosFunc();

        //SOMA DOS SALARIO
        double somaSalarios = minhaListaOriginal.getSomaSalarios();
        System.out.println("\nSoma dos salarios: R$" + somaSalarios);

        //MEDIA DOS SALARIO
        System.out.println("\nMedia dos salarios: R$" + minhaListaOriginal.mediaSalarios(somaSalarios));

        //DADOS DO MAIOR E DO MENOR SALARIO
        System.out.println("\nMenor Salario: " + minhaListaOriginal.menorSalario().getValorSalario());
        System.out.println("\nMaior Salario: " + minhaListaOriginal.maiorSalario().getValorSalario());

        // GRAVA A LISTA NA ORDEM DE INSERCAO
        Lista listaCompleta = new Lista();
        try {
            minhaListaOriginal.gravaLista(ARQUIVO_NAO_INDEXADO, true);
            listaCompleta.leArquivo(ARQUIVO_NAO_INDEXADO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nLISTA ORIGINAL NAO ORDENADA:");
        minhaListaOriginal.imprime();

        minhaListaOriginal.ordenacaoPorCodigo();
        System.out.println("\nLISTA ORIGINAL ORDENADA POR CODIGO:");
        minhaListaOriginal.imprime();

        minhaListaOriginal.ordenacaoPorNome();
        System.out.println("\nLISTA ORIGINAL ORDENADA POR NOME:");
        minhaListaOriginal.imprime();

        // ORDENACAO DA LISTA COMPLETA E GRAVACAO NO ARQUIVO
        try {
            listaCompleta.ordenacaoPorCodigo();
            listaCompleta.gravaLista(ARQUIVO_INDEXADO_CODIGO, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ORDENACAO DA LISTA COMPLETA PELO NOME E GRAVACAO NO ARQUIVO
        try {
            listaCompleta.ordenacaoPorNome();
            listaCompleta.gravaLista(ARQUIVO_INDEXADO_NOME, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n");
    }
}
