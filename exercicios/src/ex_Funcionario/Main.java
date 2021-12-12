package ex_Funcionario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\nEscolha uma opcao: (1) insert | (2) select | (3) update | (4) delete | (0) sair");
            opcao = input.nextLine();

            switch (opcao) {
                case "0" -> System.out.println("saindo...");
                case "1" -> InsertFuncionario.insert();
                case "2" -> SelectFuncionario.select();
                case "3" -> UpdateFuncionario.update();
                case "4" -> DeleteFuncionario.delete();
                default -> System.out.println("opcao invalida");
            }

        } while (!opcao.equals("0"));

    }
}