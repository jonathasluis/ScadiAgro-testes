package backEnd.compare;

import backEnd.Funcionario;

import java.util.Comparator;

public class CompareCodigo implements Comparator<Funcionario> {
    @Override
    public int compare(Funcionario o1, Funcionario o2) {
        return o1.getCodFuncionario() - o2.getCodFuncionario();
    }
}
