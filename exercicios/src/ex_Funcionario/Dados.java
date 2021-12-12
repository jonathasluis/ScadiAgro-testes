package ex_Funcionario;

import java.io.IOException;

public class Dados { // Salva e recupera os dados dos arquivos

    private final String ARQUIVO_NAO_INDEXADO = "src/exercicios/ex_Funcionario/data/funcionario.dat";


    void salvar(Lista lista) {

        final String ARQUIVO_INDEXADO_CODIGO = "src/exercicios/ex_Funcionario/data/funcionario_idx01.idx";
        final String ARQUIVO_INDEXADO_NOME = "src/exercicios/ex_Funcionario/data/funcionario_idx02.idx";

        try {
            lista.gravaLista(this.ARQUIVO_NAO_INDEXADO);

            lista.ordenacaoPorCodigo();
            lista.gravaLista(ARQUIVO_INDEXADO_CODIGO);

            lista.ordenacaoPorNome();
            lista.gravaLista(ARQUIVO_INDEXADO_NOME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void recupera(Lista lista) {
        try {
            lista.leArquivo(this.ARQUIVO_NAO_INDEXADO);
        } catch (IOException e) {
            //continua
        }
    }
}
