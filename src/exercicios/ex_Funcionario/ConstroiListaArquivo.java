package exercicios.ex_Funcionario;

import java.io.IOException;

public class ConstroiListaArquivo {


    public static void main(String[] args) {
        Lista listaNaoIndexada = new Lista();
        Lista listaIndexadaCod = new Lista();
        Lista listaIndexadaNome = new Lista();

        //LISTA NAO INDEXADA
        try {
            listaNaoIndexada.leArquivo("src/exercicios/ex_Funcionario/funcionario.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLISTA NAO INDEXADA");
        listaNaoIndexada.imprime();


        // LISTA INDEXADA POR CODIGO
        try {
            listaIndexadaCod.leArquivo("src/exercicios/ex_Funcionario/funcionario_idx01.idx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLISTA INDEXADA CODIGO");
        listaIndexadaCod.imprime();

        // LISTA INDEXADA POR NOME
        try {
            listaIndexadaNome.leArquivo("src/exercicios/ex_Funcionario/funcionario_idx02.idx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLISTA INDEXADA NOME");
        listaIndexadaNome.imprime();


    }
}
