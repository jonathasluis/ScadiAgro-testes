package exercicios.ex_Funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InsertFuncionario {

    public static void insert() {

        Dados dados = new Dados();
        Lista lista = new Lista();

        dados.recupera(lista);

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
            if (lista.buscarNaLista(codFuncionario) != -1) {
                System.out.println("ja possui esse codigo!!");
                continue;
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

            lista.insereFim(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao);
        }

        dados.salvar(lista);
    }
}
