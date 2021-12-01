package exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {
    private static int quantidadeFuncionario = 0;
    private static double somaSalario = 0;

    public int codFuncionario;
    public String nomeFuncionario;
    public String valorSalario;
    public LocalDate dataAdmissao;

    public Funcionario(int codFunc, String nome, String salario, LocalDate admissao) {
        this.codFuncionario = codFunc;
        this.nomeFuncionario = nome;
        this.valorSalario = salario;
        this.dataAdmissao = admissao;

        quantidadeFuncionario++;
        somaSalario += Double.parseDouble(salario);
    }

    public static double calculaMedia() {
        return somaSalario / quantidadeFuncionario;
    }

    public double convertSalario() {
        return Double.parseDouble(this.valorSalario);
    }

    public void printFuncionario(String prefix, String sufix) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String output = prefix + this.codFuncionario + " - " + this.nomeFuncionario + " - R$" +
                this.valorSalario + " - " + this.dataAdmissao.format(formatoData) + sufix;

        System.out.println(output);
    }

    public String difDate(LocalDate atual) {
        long diferencaEmDias = ChronoUnit.DAYS.between(this.dataAdmissao, atual);

        return " - tempo de empresa: " + diferencaEmDias + " dias";
    }

    //DESNECESSARIOS, MAIN ESTA NA MESMA CLASSE
    public static int totalFunc() {
        return quantidadeFuncionario;
    }

    public static double salarios() {
        return somaSalario;
    }

    public static void main(String[] args) {

        ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();
        Funcionario funcMenorSalario, funcMaiorSalario;
        int quantidadeFunc;

        while (true) {
            int codFuncionario;
            String nomeFuncionario;
            String valorSalario;
            LocalDate dataAdmissao;

            System.out.println("\nCodigo funcionario: ");
            codFuncionario = Integer.parseInt(input.nextLine());

            if (codFuncionario == 0) {
                break;
            }

            System.out.println("Nome funcionario: ");
            nomeFuncionario = input.nextLine();

            System.out.println("Salario funcionario: ");
            valorSalario = input.nextLine();

            System.out.println("data de admissao do funcionario (dd/MM/yyyy): ");
            String dataAux = input.nextLine();
            dataAdmissao = LocalDate.parse(dataAux, formatoData);


            Funcionario funcionario = new Funcionario(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao);
            listaDeFuncionarios.add(funcionario);
        }

        //Total de funcionarios
        quantidadeFunc = Funcionario.totalFunc();
        System.out.println("\nTotal de funcionarios: " + quantidadeFunc + "\n");

        //Lista completa de funcionários mostrando o tempo de empresa de cada um deles
        for (int i = 0; i < quantidadeFunc; i++) {
            Funcionario funcionario;
            String diferencaDataDias;

            funcionario = listaDeFuncionarios.get(i);
            diferencaDataDias = funcionario.difDate(dataAtual);

            funcionario.printFuncionario("", diferencaDataDias);

        }

        //Soma dos Salário
        System.out.println("\nSoma dos salarios: R$" + Funcionario.salarios());

        //Média dos Salários
        System.out.println("\nMedia dos salarios: R$" + Funcionario.calculaMedia());

        //Dados do Maior e do Menor Salário
        funcMenorSalario = listaDeFuncionarios.get(0);
        funcMaiorSalario = listaDeFuncionarios.get(0);

        for (int i = 1; i < quantidadeFunc; i++) {
            if (funcMenorSalario.convertSalario() > listaDeFuncionarios.get(i).convertSalario()) {
                funcMenorSalario = listaDeFuncionarios.get(i);
            }
            if (funcMaiorSalario.convertSalario() < listaDeFuncionarios.get(i).convertSalario()) {
                funcMaiorSalario = listaDeFuncionarios.get(i);
            }
        }

        funcMenorSalario.printFuncionario("\nMenor Salario: ", "");
        funcMaiorSalario.printFuncionario("\nMaior Salario: ", "");

    }
}


