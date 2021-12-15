package com.example.visual;

import backEnd.Dados;
import backEnd.Funcionario;
import backEnd.ListOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSalario;

    @FXML
    private TextField tfData;

    @FXML
    private TableView<Funcionario> tableFuncionario;
    @FXML
    private TableColumn<Funcionario, Integer> columnCod;
    @FXML
    private TableColumn<Funcionario, String> columnNome;
    @FXML
    private TableColumn<Funcionario, String> columnSalario;
    @FXML
    private TableColumn<Funcionario, LocalDate> columnData;

    private final LinkedList<Funcionario> lista = new LinkedList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dados.recupera(lista);
        Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, lista);
    }

    @FXML
    public void voltar(ActionEvent event) throws IOException {
        Dados.salvar(lista);
        switchToPrincipal(event);
    }

    @FXML
    private void limpar() {
        tfNome.setText("");
        tfSalario.setText("");
        tfCodigo.setText("");
        tfData.setText("");
    }

    @FXML
    private void pegaDadosTabela() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Funcionario func = tableFuncionario.getSelectionModel().getSelectedItem();

        try {
            tfCodigo.setText(String.valueOf(func.getCodFuncionario()));
            tfNome.setText(func.getNomeFuncionario());
            tfSalario.setText(func.getValorSalario());
            tfData.setText(func.getDataAdmissao().format(formatoData));

        } catch (NullPointerException e) {
            tfCodigo.setText("");
            tfNome.setText("");
            tfSalario.setText("");
            tfData.setText("");
        }
    }

    @FXML
    private void alterar() {

        if (Auxiliar.verificaCampos(tfCodigo, tfNome, tfSalario, tfData, lista, "update")) {

            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            int codigo = Integer.parseInt(tfCodigo.getText());
            String nome = tfNome.getText();
            String salario = tfSalario.getText();
            LocalDate data = LocalDate.parse(tfData.getText(), formatoData);

            Funcionario aux = ListOptions.buscaCod(lista, codigo);

            if (aux != null) {
                aux.setNomeFuncionario(nome);
                aux.setValorSalario(salario);
                aux.setDataAdmissao(data);
            }

            Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, lista);
        }
    }

    @FXML
    private void deletar() {

        if (Auxiliar.verificaCampos(tfCodigo, tfNome, tfSalario, tfData, lista, "update")) {

            int codigo = Integer.parseInt(tfCodigo.getText());
            Funcionario aux = ListOptions.buscaCod(lista, codigo);
            lista.remove(aux);
            Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, lista);
            limpar();
        }
    }

    /*
     * Carrega a tela inicial
     */
    public void switchToPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
