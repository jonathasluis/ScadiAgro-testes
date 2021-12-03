package exercicios.ex_Funcionario;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Lista {

    private Funcionario primeiro;
    private Funcionario ultimo;

    private int tamanho;

    public Lista() {
        tamanho = 0;
        primeiro = null;
        ultimo = null;
    }

    public Funcionario getPrimeiro() {
        return primeiro;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return (tamanho == 0);
    }

    public void insereFim(int codFunc, String nome, String salario, LocalDate admissao) {
        Funcionario novo = new Funcionario(codFunc, nome, salario, admissao);

        if (vazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
        }
        ultimo = novo;
        tamanho++;
    }

    public void imprime() {
        Funcionario aux = primeiro;

        while (aux != null) {
            System.out.println(aux);
            aux = aux.getProximo();
        }
    }

    public void imprimeReverso() {
        Funcionario aux = ultimo;

        while (aux != null) {
            System.out.println(aux);
            aux = aux.getAnterior();
        }
    }

    public void ordenacaoPorCodigo() {
        Funcionario atual = primeiro, index;

        Funcionario temp = new Funcionario();

        while (atual != null) {
            index = atual.getProximo();

            while (index != null) {
                if (atual.getCodFuncionario() > index.getCodFuncionario()) {
                    temp.replace(atual);
                    atual.replace(index);
                    index.replace(temp);
                }
                index = index.getProximo();
            }
            atual = atual.getProximo();
        }
    }

    public void ordenacaoPorNome() {
        Funcionario atual = primeiro, index;

        Funcionario temp = new Funcionario();

        while (atual != null) {
            index = atual.getProximo();

            while (index != null) {

                if (atual.getNomeFuncionario().compareToIgnoreCase(index.getNomeFuncionario()) > 0) {
                    temp.replace(atual);
                    atual.replace(index);
                    index.replace(temp);
                }
                index = index.getProximo();
            }
            atual = atual.getProximo();
        }
    }

    public void gravaLista(String nomeArquivo) throws IOException {
        Funcionario aux = primeiro;
        String dados;
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomeArquivo));
        while (aux != null) {
            dados = Format.formatarParaEscrita(aux);
            buffWrite.append(dados).append("\n");
            aux = aux.getProximo();
        }
        buffWrite.close();
    }

    public void leArquivo(String nomeArquivo) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivo));
        String linha;
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formatado = Format.formatarDaLeitura(linha);
                String[] formatadoSplit = formatado.split("\\|");

                int codigo = Integer.parseInt(formatadoSplit[0]);
                String nome = formatadoSplit[1];
                Double salario = Double.parseDouble(formatadoSplit[2]);
                LocalDate data = LocalDate.parse(formatadoSplit[3], formatoData);

                this.insereFim(codigo, nome, String.format("%.2f",
                        salario).replace(",", "."), data);
            } else
                break;
        }
        buffRead.close();

    }
}
