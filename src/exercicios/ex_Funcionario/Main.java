package exercicios.ex_Funcionario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\nEscolha uma opcao: (1) insert | (2) select | (0) sair");
            opcao = input.nextLine();

            switch (opcao) {
                case "0" -> System.out.println("saindo...");
                case "1" -> InsertFuncionario.insert();
                case "2" -> ConstroiListaArquivo.select();
                default -> System.out.println("opcao invalida");
            }

        } while (!opcao.equals("0"));

        input.close();
    }
}
