package exercicios.ex_Funcionario;

import java.io.IOException;

public class ConstroiListaArquivo {


    public static void main(String[] args) {
        Lista listaNaoIndexada = new Lista();
        Lista listaIndexadaCod = new Lista();
        Lista listaIndexadaNome = new Lista();

        final String ARQUIVO_NAO_INDEXADO = "src/exercicios/ex_Funcionario/funcionario.dat";
        final String ARQUIVO_INDEXADO_CODIGO = "src/exercicios/ex_Funcionario/funcionario_idx01.idx";
        final String ARQUIVO_INDEXADO_NOME = "src/exercicios/ex_Funcionario/funcionario_idx02.idx";

        //LISTA NAO INDEXADA
        try {
            listaNaoIndexada.leArquivo(ARQUIVO_NAO_INDEXADO);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLISTA NAO INDEXADA");
        listaNaoIndexada.imprime();


        // LISTA INDEXADA POR CODIGO
        try {
            listaIndexadaCod.leArquivo(ARQUIVO_INDEXADO_CODIGO);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLISTA INDEXADA CODIGO");
        listaIndexadaCod.imprime();

        // LISTA INDEXADA POR NOME
        try {
            listaIndexadaNome.leArquivo(ARQUIVO_INDEXADO_NOME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLISTA INDEXADA NOME");
        listaIndexadaNome.imprime();


    }
}
