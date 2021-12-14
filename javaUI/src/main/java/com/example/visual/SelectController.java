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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class SelectController implements Initializable {

    private final List<Funcionario> lista = new LinkedList<>();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dados.recupera(lista);

        for (Funcionario aux : lista) {
            aux.difDate();
        }

        int quantidadeFuncionarios = lista.size();
        double somaSalarios = ListOptions.getSomaSalarios(lista);
        double mediaSalarios = somaSalarios / quantidadeFuncionarios;

        lblQuantidade.setText(String.valueOf(quantidadeFuncionarios));
        lblSoma.setText("R$" + somaSalarios);
        lblMedia.setText("R$" + mediaSalarios);
        try {
            lblMaior.setText(ListOptions.maiorSalario(lista).toString());
            lblMenor.setText(ListOptions.menorSalario(lista).toString());
        } catch (IndexOutOfBoundsException e) {
            lblMaior.setText("NaN");
            lblMenor.setText("NaN");
        }

        Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, columnDifData, lista);
    }

    @FXML
    private void removerTodos() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Atenção!");
        alert.setHeaderText("Tem certeza que deseja remover todos os dados?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            lista.clear();
            Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, columnDifData, lista);

            lblQuantidade.setText("0");
            lblSoma.setText("R$0.0");
            lblMedia.setText("R$NaN");
            lblMaior.setText("NaN");
            lblMenor.setText("NaN");
        }
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        Dados.salvar(lista);
        switchToPrincipal(event);
    }

    public void switchToPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
