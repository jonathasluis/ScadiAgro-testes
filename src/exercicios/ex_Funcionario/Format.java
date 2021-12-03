package exercicios.ex_Funcionario;

import java.io.*;
import java.time.LocalDate;

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
            LocalDate dataFunc = func.getDataAdmissao();
            String dataFormatada;

            String ano = String.valueOf(dataFunc.getYear());
            String mes = String.valueOf(dataFunc.getMonthValue());
            String dia = String.valueOf(dataFunc.getDayOfMonth());

            if (mes.length() == 1){
                mes = "0"+mes;
            }

            if (dia.length() == 1){
                dia = "0"+dia;
            }

            dataFormatada = ano + "-" + mes + "-" + dia;

            formatado = codigo + "|" + nome + "|" + salario + "|" + dataFormatada;

        }
        return formatado;
    }

    public static String formatarDaLeitura(String valor){
        String formatado;
        String[] split = valor.split("\\|");
        String nome = split[1].trim();

        String data = split[3].trim();
        String[] dataSplit = data.split("-");
        data = dataSplit[2] + "/" + dataSplit[1] + "/" + dataSplit[0];

        formatado = split[0] + "|" + nome + "|" + split[2] + "|" + data;

        return formatado;
    }
}
