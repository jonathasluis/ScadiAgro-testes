package backEnd;

import java.io.IOException;
import java.util.List;

public class Dados { // Salva e recupera os dados dos arquivos

    private static final String ARQUIVO_NAO_INDEXADO = "src/main/java/backEnd/funcionario.dat";


    public static void salvar(List<Funcionario> lista) {

        final String ARQUIVO_INDEXADO_CODIGO = "src/main/java/backEnd/funcionario_idx01.idx";
        final String ARQUIVO_INDEXADO_NOME = "src/main/java/backEnd/funcionario_idx02.idx";

        try {
            ListOptions.gravaLista(ARQUIVO_NAO_INDEXADO,lista);

            /*lista.ordenacaoPorCodigo();
            lista.gravaLista(ARQUIVO_INDEXADO_CODIGO);

            lista.ordenacaoPorNome();
            lista.gravaLista(ARQUIVO_INDEXADO_NOME);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recupera(List<Funcionario> lista) {
        try {
            ListOptions.leArquivo(ARQUIVO_NAO_INDEXADO,lista);
        } catch (IOException e) {
            //continua
        }
    }
}
