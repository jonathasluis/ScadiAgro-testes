package exercicios.ex_Funcionario;

public class SelectFuncionario {

    public static void select() {

        Dados dados = new Dados();
        Lista lista = new Lista();

        int totalFuncionarios;
        double somaSalarios, mediaSalarios;
        Funcionario menorSalario, maiorSalario;

        dados.recupera(lista);

        if (lista.vazia()) {
            System.out.println("SEM REGISTROS!");
            return;
        }

        // LISTA NAO INDEXADA
        System.out.println("\nLISTA NAO INDEXADA");
        lista.diferencaDataTodosFunc();


        // LISTA INDEXADA POR CODIGO
        System.out.println("\nLISTA INDEXADA CODIGO");
        lista.ordenacaoPorCodigo();
        lista.imprime();

        // LISTA INDEXADA POR NOME
        lista.ordenacaoPorNome();
        System.out.println("\nLISTA INDEXADA NOME");
        lista.imprime();

        System.out.println("\n");

        totalFuncionarios = lista.getTamanho();
        somaSalarios = lista.getSomaSalarios();
        mediaSalarios = lista.mediaSalarios(somaSalarios);
        menorSalario = lista.menorSalario();
        maiorSalario = lista.maiorSalario();

        System.out.println("Quantidade de funcionarios: " + totalFuncionarios +
                " | Soma dos salarios: R$" + somaSalarios + " | Media dos salarios: R$" + mediaSalarios);

        System.out.println("Menor salario: " + menorSalario);
        System.out.println("Maior salario: " + maiorSalario);

    }
}
