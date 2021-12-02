package exercicios.ex5_6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Funcionario {
    private static double somaSalario = 0;

    private int codFuncionario;
    private String nomeFuncionario;
    private String valorSalario;
    private LocalDate dataAdmissao;

    private Funcionario proximo;
    private Funcionario anterior;

    public Funcionario(int codFunc, String nome, String salario, LocalDate admissao) {
        this.codFuncionario = codFunc;
        this.nomeFuncionario = nome;
        this.valorSalario = salario;
        this.dataAdmissao = admissao;

        proximo = null;
        anterior = null;

        somaSalario += Double.parseDouble(salario);
    }

    public Funcionario() {
        this.codFuncionario = 0;
        this.nomeFuncionario = null;
        this.valorSalario = null;
        this.dataAdmissao = null;

        proximo = null;
        anterior = null;
    }

    public static double calculaMedia(int quantidadeFuncionario) {
        return somaSalario / quantidadeFuncionario;
    }

    public double convertSalario() {
        return Double.parseDouble(getValorSalario());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.codFuncionario + " - " + this.nomeFuncionario + " - R$" +
                this.valorSalario + " - " + this.dataAdmissao.format(formatoData);
    }

    public String difDate(LocalDate atual) {
        long diferencaEmDias = ChronoUnit.DAYS.between(getDataAdmissao(), atual);

        return " - tempo de empresa: " + diferencaEmDias + " dias";
    }

    public static double getSomaSalario() {
        return somaSalario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getValorSalario() {
        return valorSalario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public Funcionario getProximo() {
        return proximo;
    }

    public void setProximo(Funcionario proximo) {
        this.proximo = proximo;
    }

    public Funcionario getAnterior() {
        return anterior;
    }

    public void setAnterior(Funcionario anterior) {
        this.anterior = anterior;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setValorSalario(String valorSalario) {
        this.valorSalario = valorSalario;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void replace(Funcionario func) {
        this.setCodFuncionario(func.getCodFuncionario());
        this.setNomeFuncionario(func.getNomeFuncionario());
        this.setDataAdmissao(func.getDataAdmissao());
        this.setValorSalario(func.getValorSalario());
    }
}


