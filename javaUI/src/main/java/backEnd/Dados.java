package backEnd;

import backEnd.compare.CompareCodigo;
import backEnd.compare.CompareNome;

import java.io.IOException;
import java.util.List;

public class Dados { // Salva e recupera os dados dos arquivos

    private static final String ARQUIVO_NAO_INDEXADO = "src/main/java/backEnd/data/funcionario.dat";
    private static final String ARQUIVO_INDEXADO_CODIGO = "src/main/java/backEnd/data/funcionario_idx01.idx";
    private static final String ARQUIVO_INDEXADO_NOME = "src/main/java/backEnd/data/funcionario_idx02.idx";

    /*
     * Ordena e salva a lista nos arquivos;
     */
    public static void salvar(List<Funcionario> lista) {

        try {
            ListOptions.gravaLista(ARQUIVO_NAO_INDEXADO, lista);

            lista.sort(new CompareCodigo());
            ListOptions.gravaLista(ARQUIVO_INDEXADO_CODIGO, lista);

            lista.sort(new CompareNome());
            ListOptions.gravaLista(ARQUIVO_INDEXADO_NOME, lista);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Salva nos arquivos listas ja odenadas
     */
    public static void salvar(List<Funcionario> listaOriginal, List<Funcionario> listaCod, List<Funcionario> listaNome) {

        try {
            ListOptions.gravaLista(ARQUIVO_NAO_INDEXADO, listaOriginal);

            ListOptions.gravaLista(ARQUIVO_INDEXADO_CODIGO, listaCod);

            ListOptions.gravaLista(ARQUIVO_INDEXADO_NOME, listaNome);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Recupera os dados dos arquivos
     */
    public static void recupera(List<Funcionario> listaNaoOrdenada) {
        try {
            ListOptions.leArquivo(ARQUIVO_NAO_INDEXADO, listaNaoOrdenada);
        } catch (IOException e) {
            //continua
        }
    }
}
