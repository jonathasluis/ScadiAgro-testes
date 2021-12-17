package com.example.visual;

import backEnd.Dados;
import backEnd.Funcionario;
import backEnd.ListOptions;
import backEnd.compare.CompareCodigo;
import backEnd.compare.CompareNome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class SelectController implements Initializable {

    private LinkedList<Funcionario> listaOrdemOriginal = new LinkedList<>();
    private LinkedList<Funcionario> listaOrdemCodigo = new LinkedList<>();
    private LinkedList<Funcionario> listaOrdemNome = new LinkedList<>();

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

    @FXML
    private TableColumn<Funcionario, String> columnDifData;

    @FXML
    private Label lblQuantidade;

    @FXML
    private Label lblSoma;

    @FXML
    private Label lblMedia;

    @FXML
    private Label lblMaior;

    @FXML
    private Label lblMenor;

    @FXML
    private ComboBox<String> cbOrdem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dados.recupera(listaOrdemOriginal);

        for (Funcionario aux : listaOrdemOriginal) {
            aux.difDate();
        }

        //noinspection unchecked
        listaOrdemNome = (LinkedList<Funcionario>) listaOrdemOriginal.clone();
        listaOrdemNome.sort(new CompareNome());

        //noinspection unchecked
        listaOrdemCodigo = (LinkedList<Funcionario>) listaOrdemOriginal.clone();
        listaOrdemCodigo.sort(new CompareCodigo());

        int quantidadeFuncionarios = listaOrdemOriginal.size();
        double somaSalarios = ListOptions.getSomaSalarios(listaOrdemOriginal);
        double mediaSalarios = somaSalarios / quantidadeFuncionarios;

        lblQuantidade.setText(String.valueOf(quantidadeFuncionarios));
        lblSoma.setText("R$" + somaSalarios);
        lblMedia.setText("R$" + mediaSalarios);
        try {
            lblMaior.setText(ListOptions.maiorSalario(listaOrdemOriginal).toString());
            lblMenor.setText(ListOptions.menorSalario(listaOrdemOriginal).toString());
        } catch (IndexOutOfBoundsException e) {
            lblMaior.setText("NaN");
            lblMenor.setText("NaN");
        }

        Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, columnDifData, listaOrdemOriginal);

        cbOrdem.getItems().addAll("Insercao", "Codigo", "Nome");
        cbOrdem.getSelectionModel().selectFirst();
    }

    @FXML
    private void removerTodos() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Atenção!");
        alert.setHeaderText("Tem certeza que deseja remover todos os dados?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            listaOrdemOriginal.clear();
            listaOrdemCodigo.clear();
            listaOrdemNome.clear();
            cbOrdem.getSelectionModel().select("Insercao");
            Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, columnDifData, listaOrdemOriginal);

            lblQuantidade.setText("0");
            lblSoma.setText("R$0.0");
            lblMedia.setText("R$NaN");
            lblMaior.setText("NaN");
            lblMenor.setText("NaN");
        }
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        Dados.salvar(listaOrdemOriginal, listaOrdemCodigo, listaOrdemNome);
        switchToPrincipal(event);
    }

    @FXML
    private void alterarComboBox() {
        String opcao = cbOrdem.getSelectionModel().getSelectedItem();

        switch (opcao) {
            case "Insercao" -> Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome,
                    columnSalario, columnData, columnDifData, listaOrdemOriginal);
            case "Codigo" -> Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario,
                    columnData, columnDifData, listaOrdemCodigo);
            case "Nome" -> Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario,
                    columnData, columnDifData, listaOrdemNome);
        }
    }

    /*
     * Carrega a tela inicial
     */
    private void switchToPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("PRINCIPAL");
        stage.show();
    }

}
