package exercicios.ex_Funcionario;

public class Format {

    public static String formatarParaEscrita(Funcionario func){
        String formatado = "";

        if (func != null) {
            // CODIGO
            String codigo = String.valueOf(func.getCodFuncionario());
            int diferenca = 6 - codigo.length();
            String complemento = "";

            for (int i = 0; i < diferenca; i++){
                complemento = complemento.concat("0");
            }
            codigo = complemento + codigo;

            // NOME
            String nome = func.getNomeFuncionario();
            diferenca = 100 - nome.length();
            complemento = "";

            for (int i = 0; i < diferenca; i++){
                complemento = complemento.concat(" ");
            }
            nome += complemento;

            // SALARIO
            String salario = func.getValorSalario();
            diferenca = 13 - salario.split("\\.")[0].length();
            complemento = "";

            for (int i = 0; i < diferenca; i++){
                complemento = complemento.concat("0");
            }

            salario = complemento + salario;

            // DATA
            String dataFormatada = func.getDataAdmissao().toString();

            formatado = codigo + "|" + nome + "|" + salario + "|" + dataFormatada;

        }
        return formatado;
    }

    public static String[] formatarDaLeitura(String valor){
        String[] formatado = new String[4];
        String[] split = valor.split("\\|");

        formatado[0] = split[0];
        formatado[1] = split[1].trim();
        formatado[2] = split[2].replaceFirst("^0+(?!$)", "");
        formatado[3] = split[3].trim();

        return formatado;
    }
}
