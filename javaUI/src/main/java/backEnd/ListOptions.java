package backEnd;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class ListOptions {

    public static Funcionario contem(List<Funcionario> lista, int codigo) {
        for (Funcionario aux : lista) {
            if (aux.getCodFuncionario() == codigo) {
                return aux;
            }
        }
        return null;
    }

    public static double getSomaSalarios(List<Funcionario> lista) {
        double soma = 0d;

        for (Funcionario funcionario : lista) {
            soma += funcionario.convertSalario();
        }
        return soma;
    }

    public static Funcionario menorSalario(List<Funcionario> lista) {
        Funcionario funcMenorSalario = lista.get(0);

        for (int i = 1; i < lista.size(); i++) {
            if (funcMenorSalario.convertSalario() > lista.get(i).convertSalario()) {
                funcMenorSalario = lista.get(i);
            }
        }

        return funcMenorSalario;
    }

    public static Funcionario maiorSalario(List<Funcionario> lista) {
        Funcionario funcMaiorSalario = lista.get(0);

        for (int i = 1; i < lista.size(); i++) {
            if (funcMaiorSalario.convertSalario() < lista.get(i).convertSalario()) {
                funcMaiorSalario = lista.get(i);
            }
        }
        return funcMaiorSalario;
    }

    public static void gravaLista(String nomeArquivo, List<Funcionario> lista) throws IOException {
        String dados;
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomeArquivo));

        for (Funcionario funcionario : lista) {
            dados = Format.formatarParaEscrita(funcionario);
            buffWrite.append(dados).append("\n");
        }
        buffWrite.close();
    }

    public static void leArquivo(String nomeArquivo, List<Funcionario> lista) throws IOException {
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
            } else
                break;
        }
        buffRead.close();
    }
}
