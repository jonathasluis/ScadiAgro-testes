package exercicios.ex_Funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UpdateFuncionario {

    public static void update() {

        Dados dados = new Dados();
        Lista lista = new Lista();

        dados.recupera(lista);

        if (lista.vazia()) {
            System.out.println("SEM REGISTROS!");
            return;
        }

        int codigo;
        Scanner input = new Scanner(System.in);

        System.out.println("qual codigo deseja alterar: ");
        codigo = Integer.parseInt(input.nextLine());

        if (codigo != 0) {
            int posicao = lista.buscarNaLista(codigo);

            if (posicao != -1) {
                String nome, salario, dataAux;
                DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataAdmissao;

                Funcionario func = lista.acessarPosicao(posicao);
                System.out.println(func);

                System.out.println("novo nome:");
                nome = input.nextLine();

                System.out.println("novo salario:");
                salario = input.nextLine();

                salario = salario.replace(",", ".");

                if (!salario.contains(".")) {
                    salario += ".00";
                }

                System.out.println("nova data de admissao :");
                dataAux = input.nextLine();

                dataAdmissao = LocalDate.parse(dataAux, formatoData);

                func.replace(codigo, nome, dataAdmissao, salario);
            }
        }

        dados.salvar(lista);
    }
}
