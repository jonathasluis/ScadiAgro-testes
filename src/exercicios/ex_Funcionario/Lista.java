package exercicios.ex_Funcionario;

import java.io.*;
import java.time.LocalDate;

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

    public Funcionario buscarNaLista(int cod) {
        Funcionario auxiliar = primeiro;
        int posicao = 0;

        while (auxiliar != null) {
            if (auxiliar.getCodFuncionario() == cod) {
                System.out.println(auxiliar + " " + posicao);
                break;
            } else {
                auxiliar = auxiliar.getProximo();
                posicao++;
            }
        }
        if (auxiliar == null) {
            System.out.println("nao encontrado");
        }
        return auxiliar;
    }

    public Funcionario acessarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Invalid position");
        }
        Funcionario auxiliar = primeiro;
        int localizacao = 0;

        while (posicao > localizacao) {
            auxiliar = auxiliar.getProximo();
            localizacao++;
        }
        return auxiliar;
    }

    public void remove(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            if (posicao == 0) {
                removeInicio();
            } else if (posicao == tamanho - 1) {
                removeFim();
            } else {
                removePosicao(posicao);
            }
        } else {
            throw new IllegalArgumentException("Index " + posicao + " out of bounds for length " + tamanho);
        }
    }

    public void removeInicio() {
        Funcionario auxiliar = primeiro;
        primeiro = auxiliar.getProximo();
        auxiliar.setProximo(null);

        if (tamanho > 1) {
            primeiro.setAnterior(null);
        }

        tamanho--;

        if (vazia()) {
            ultimo = null;
        }
    }

    public void removeFim() {
        Funcionario auxiliar = ultimo;
        ultimo = auxiliar.getAnterior();
        auxiliar.setAnterior(null);
        ultimo.setProximo(null);
        ultimo.setProximo(null);

        tamanho--;

        if (vazia()) {
            ultimo = null;
        }
    }

    public void removePosicao(int posicao) {
        Funcionario auxiliar = acessarPosicao(posicao);
        auxiliar.getProximo().setAnterior(auxiliar.getAnterior());
        auxiliar.getAnterior().setProximo(auxiliar.getProximo());

        tamanho--;
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
                String[] formatado = Format.formatarDaLeitura(linha);

                int codigo = Integer.parseInt(formatado[0]);
                String nome = formatado[1];
                String salario = formatado[2];
                LocalDate data = LocalDate.parse(formatado[3]);

                this.insereFim(codigo, nome, salario, data);
            } else
                break;
        }
        buffRead.close();
    }
}
