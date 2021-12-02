package exercicios.ex5_6;

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

    public boolean vazia() {
        return (tamanho == 0);
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

    public Funcionario getPrimeiro() {
        return primeiro;
    }

    public int getTamanho() {
        return tamanho;
    }
}
