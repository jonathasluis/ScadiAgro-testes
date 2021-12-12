package ex_Funcionario;

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

    public int buscarNaLista(int cod) {
        Funcionario auxiliar = this.primeiro;
        int posicao = 0;

        while (auxiliar != null) {
            if (auxiliar.getCodFuncionario() == cod) {
                break;
            } else {
                auxiliar = auxiliar.getProximo();
                posicao++;
            }
        }
        if (auxiliar == null) {
            posicao = -1;
        }
        return posicao;
    }

    public Funcionario acessarPosicao(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Index " + posicao + " out of bounds for length " + this.tamanho);
        }
        Funcionario auxiliar = this.primeiro;
        int localizacao = 0;

        while (posicao > localizacao) {
            auxiliar = auxiliar.getProximo();
            localizacao++;
        }
        return auxiliar;
    }

    public void remove(int posicao) {
        if (posicao >= 0 && posicao < this.tamanho) {
            if (posicao == 0) {
                removeInicio();
            } else if (posicao == this.tamanho - 1) {
                removeFim();
            } else {
                removePosicao(posicao);
            }
        } else {
            throw new IndexOutOfBoundsException("Index " + posicao + " out of bounds for length " + this.tamanho);
        }
    }

    public void removeInicio() {
        Funcionario auxiliar = this.primeiro;
        primeiro = auxiliar.getProximo();
        auxiliar.setProximo(null);


        if (this.tamanho > 1) {
            this.primeiro.setAnterior(null);
        }

        tamanho--;

        System.out.println("Removido: " + auxiliar);

        if (vazia()) {
            ultimo = null;
        }
    }

    public void removeFim() {
        Funcionario auxiliar = this.ultimo;
        ultimo = auxiliar.getAnterior();
        auxiliar.setAnterior(null);
        this.ultimo.setProximo(null);
        this.ultimo.setProximo(null);

        tamanho--;

        System.out.println("Removido: " + auxiliar);

        if (vazia()) {
            ultimo = null;
        }
    }

    public void removePosicao(int posicao) {
        Funcionario auxiliar = acessarPosicao(posicao);
        auxiliar.getProximo().setAnterior(auxiliar.getAnterior());
        auxiliar.getAnterior().setProximo(auxiliar.getProximo());

        tamanho--;
        System.out.println("Removido: " + auxiliar);
    }

    public double getSomaSalarios() {
        double soma = 0;
        Funcionario auxiliar = this.primeiro;

        while (auxiliar != null) {
            soma += auxiliar.convertSalario();
            auxiliar = auxiliar.getProximo();
        }

        return soma;
    }

    public double mediaSalarios(double somaSalarios) {
        return somaSalarios / this.tamanho;
    }

    public Funcionario menorSalario() {
        Funcionario funcMenorSalario = primeiro;

        Funcionario funcMenorAux = funcMenorSalario.getProximo();

        for (int i = 1; i < tamanho; i++) {
            if (funcMenorSalario.convertSalario() > funcMenorAux.convertSalario()) {
                funcMenorSalario = funcMenorAux;
            }

            funcMenorAux = funcMenorAux.getProximo();
        }

        return funcMenorSalario;
    }

    public Funcionario maiorSalario() {
        Funcionario funcMaiorSalario = primeiro;

        Funcionario funcMaiorAux = funcMaiorSalario.getProximo();

        for (int i = 1; i < tamanho; i++) {
            if (funcMaiorSalario.convertSalario() < funcMaiorAux.convertSalario()) {
                funcMaiorSalario = funcMaiorAux;
            }

            funcMaiorAux = funcMaiorAux.getProximo();
        }

        return funcMaiorSalario;
    }

    public void imprime() {
        Funcionario aux = this.primeiro;

        while (aux != null) {
            System.out.println(aux);
            aux = aux.getProximo();
        }
    }

    public void imprimeReverso() {
        Funcionario aux = this.ultimo;

        while (aux != null) {
            System.out.println(aux);
            aux = aux.getAnterior();
        }
    }

    public void diferencaDataTodosFunc() {
        Funcionario funcionario = this.primeiro;

        for (int i = 0; i < this.tamanho; i++) {
            LocalDate dataAtual = LocalDate.now();
            String diferencaDataDias;

            diferencaDataDias = funcionario.difDate(dataAtual);
            System.out.println(funcionario + diferencaDataDias);

            funcionario = funcionario.getProximo();
        }
    }

    public void ordenacaoPorCodigo() {
        Funcionario atual = this.primeiro;
        Funcionario index;

        Funcionario temp = new Funcionario();

        while (atual != null) {
            index = atual.getProximo();

            while (index != null) {
                if (atual.getCodFuncionario() > index.getCodFuncionario()) {

                    temp.replace(atual.getCodFuncionario(), atual.getNomeFuncionario(),
                            atual.getDataAdmissao(), atual.getValorSalario());

                    atual.replace(index.getCodFuncionario(), index.getNomeFuncionario(),
                            index.getDataAdmissao(), index.getValorSalario());

                    index.replace(temp.getCodFuncionario(), temp.getNomeFuncionario(),
                            temp.getDataAdmissao(), temp.getValorSalario());
                }
                index = index.getProximo();
            }
            atual = atual.getProximo();
        }
    }

    public void ordenacaoPorNome() {
        Funcionario atual = this.primeiro;
        Funcionario index;

        Funcionario temp = new Funcionario();

        while (atual != null) {
            index = atual.getProximo();

            while (index != null) {

                if (atual.getNomeFuncionario().compareToIgnoreCase(index.getNomeFuncionario()) > 0) {
                    temp.replace(atual.getCodFuncionario(), atual.getNomeFuncionario(),
                            atual.getDataAdmissao(), atual.getValorSalario());

                    atual.replace(index.getCodFuncionario(), index.getNomeFuncionario(),
                            index.getDataAdmissao(), index.getValorSalario());

                    index.replace(temp.getCodFuncionario(), temp.getNomeFuncionario(),
                            temp.getDataAdmissao(), temp.getValorSalario());
                }
                index = index.getProximo();
            }
            atual = atual.getProximo();
        }
    }

    public void gravaLista(String nomeArquivo) throws IOException {
        Funcionario aux = this.primeiro;
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
