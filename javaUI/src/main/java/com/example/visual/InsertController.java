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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class InsertController implements Initializable {

    private List<Funcionario> lista = new LinkedList<>();

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtCodigo;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dados.recupera(lista);
        montaTabela();
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        switchToPrincipal(event);
    }

    @FXML
    private void limpar(ActionEvent event) {
        txtNome.setText("");
        txtSalario.setText("");
        txtCodigo.setText("");
        txtData.setText("");
    }

    @FXML
    private void adicionar(ActionEvent event) {

        if (verificaCampos()) {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            int codigo = Integer.parseInt(txtCodigo.getText());
            String nome = txtNome.getText();
            String salario = txtSalario.getText();
            LocalDate data = LocalDate.parse(txtData.getText(), formatoData);

            lista.add(new Funcionario(codigo, nome, salario, data));
            montaTabela();
            Dados.salvar(lista);
        }
    }

    private void montaTabela() {
        columnCod.setCellValueFactory(new PropertyValueFactory<>("codFuncionario"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
        columnSalario.setCellValueFactory(new PropertyValueFactory<>("valorSalario"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));

        tableFuncionario.getItems().setAll(lista);
    }


    private boolean verificaCampos() {

        if (!txtCodigo.getText().trim().matches("^\\d*[0-9]$") || txtCodigo.getText().equals("0")) {
            alerta("Codigo Invalido!");
            txtCodigo.requestFocus();
            return false;
        }

        if (txtNome.getText().trim().equals("")) {
            alerta("Nome Invalido!");
            txtNome.requestFocus();
            return false;
        }

        if (!txtSalario.getText().trim().matches("^\\d*[0-9](,|.\\d*[0-9])?$")) {
            alerta("Salario Invalido!");
            txtSalario.requestFocus();
            return false;
        }

        if (!txtData.getText().trim().matches("^(0[1-9]|[1,2][0-9]|3[0,1])/(0[1-9]|1[0,1,2])/\\d{4}$")) {
            alerta("Data Invalida!");
            txtCodigo.requestFocus();
            return false;
        }

        if (ListOptions.contem(lista, Integer.parseInt(txtCodigo.getText()))) {
            alerta("Ja existe esse codigo!");
            txtData.requestFocus();
            return false;
        }

        return true;
    }

    private void alerta(String header) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setHeaderText(header);
        alert.show();
    }

    public void switchToPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
