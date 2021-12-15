package backEnd;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Funcionario {

    private int codFuncionario;
    private String nomeFuncionario;
    private String valorSalario;
    private LocalDate dataAdmissao;
    private String tempoEmpresa;

    public Funcionario(int codFunc, String nome, String salario, LocalDate admissao) {
        this.codFuncionario = codFunc;
        this.nomeFuncionario = nome;

        salario = salario.replace(",", ".");

        if (!salario.contains(".")) {
            salario += ".00";
        }

        this.valorSalario = salario;
        this.dataAdmissao = admissao;
        this.tempoEmpresa = null;

    }

    public Funcionario() {
        this.codFuncionario = 0;
        this.nomeFuncionario = null;
        this.valorSalario = null;
        this.dataAdmissao = null;

    }

    public double convertSalario() {
        return Double.parseDouble(getValorSalario());
    }

    @Override
    public String toString() {

        return this.codFuncionario + " - " + this.nomeFuncionario + " - R$" +
                this.valorSalario;
    }

    public void difDate() {
        LocalDate atual = LocalDate.now();
        long diferencaEmDias = ChronoUnit.DAYS.between(getDataAdmissao(), atual);

        this.setTempoEmpresa(diferencaEmDias + " dias");
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


    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setValorSalario(String valorSalario) {
        this.valorSalario = valorSalario;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getTempoEmpresa() {
        return tempoEmpresa;
    }

    public void setTempoEmpresa(String tempoEmpresa) {
        this.tempoEmpresa = tempoEmpresa;
    }

}


