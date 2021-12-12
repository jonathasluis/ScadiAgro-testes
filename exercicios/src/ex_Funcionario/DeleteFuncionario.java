package ex_Funcionario;

import java.util.Scanner;

public class DeleteFuncionario {

    public static void delete() {

        Dados dados = new Dados();
        Lista listaFuncionarios = new Lista();
        Scanner input = new Scanner(System.in);

        dados.recupera(listaFuncionarios);

        if (listaFuncionarios.vazia()) {
            System.out.println("SEM REGISTROS!");
            return;
        }

        listaFuncionarios.imprime();

        while (true) {
            int codigo, posicao;

            System.out.println("\nINSIRA O CODIGO DE QUAL DESEJA DELETAR: (0 para sair e salvar)");
            codigo = input.nextInt();

            if (codigo == 0) {
                break;
            }

            posicao = listaFuncionarios.buscarNaLista(codigo);

            if (posicao == -1) {
                System.out.println("SEM REGISTRO!");
                continue;
            }
            listaFuncionarios.remove(posicao);

            if (listaFuncionarios.vazia()) {
                break;
            }
        }
        dados.salvar(listaFuncionarios);
    }
}
