package backEnd;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;

/*
 * Classe com as operações feitas com as listas
 */
public class ListOptions {

    /*
     * Verifica se possui o codigo na lista, se possuir, retorna o objeto que o contem
     */
    public static Funcionario buscaCod(LinkedList<Funcionario> lista, int codigo) {
        for (Funcionario aux : lista) {
            if (aux.getCodFuncionario() == codigo) {
                return aux;
            }
        }
        return null;
    }

    /*
     * Retorna a soma dos salarios na lista
     */
    public static double getSomaSalarios(LinkedList<Funcionario> lista) {
        double soma = 0d;

        for (Funcionario funcionario : lista) {
            soma += funcionario.convertSalario();
        }
        return soma;
    }

    /*
     * Retorna o funcionario com o menor salario
     */

    public static Funcionario menorSalario(LinkedList<Funcionario> lista) {
        Funcionario funcMenorSalario = lista.get(0);
        Funcionario aux;

        for (int i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            if (funcMenorSalario.convertSalario() > aux.convertSalario()) {
                funcMenorSalario = aux;
            }
        }
        return funcMenorSalario;
    }

    /*
     * Retorna o funcionario com o maior salario
     */
    public static Funcionario maiorSalario(LinkedList<Funcionario> lista) {
        Funcionario funcMaiorSalario = lista.get(0);
        Funcionario aux;

        for (int i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            if (funcMaiorSalario.convertSalario() < aux.convertSalario()) {
                funcMaiorSalario = aux;
            }
        }
        return funcMaiorSalario;
    }

    /*
     * Grava a lista no arquivo
     */
    public static void gravaLista(String nomeArquivo, LinkedList<Funcionario> lista) throws IOException {
        String dados;
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomeArquivo));

        for (Funcionario funcionario : lista) {
            dados = Format.formatarParaEscrita(funcionario);
            buffWrite.append(dados).append("\n");
        }
        buffWrite.close();
    }

    /*
     * Lê arquivo e controi lista
     */
    public static void leArquivo(String nomeArquivo, LinkedList<Funcionario> lista) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                String[] formatado = Format.formatarDaLeitura(linha);

                int codigo = Integer.parseInt(formatado[0]);
                String nome = formatado[1];
                String salario = formatado[2];
                LocalDate data = LocalDate.parse(formatado[3]);

                lista.add(new Funcionario(codigo, nome, salario, data));
            } else {
                break;
            }
        }
        buffRead.close();
    }
}
