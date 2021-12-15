package backEnd.compare;

import backEnd.Funcionario;

import java.util.Comparator;

public class CompareNome implements Comparator<Funcionario> {
    @Override
    public int compare(Funcionario o1, Funcionario o2) {
        return o1.getNomeFuncionario().compareToIgnoreCase(o2.getNomeFuncionario());
    }
}
