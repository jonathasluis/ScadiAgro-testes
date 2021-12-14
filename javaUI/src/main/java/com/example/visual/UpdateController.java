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
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    private TextField txtData;

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

    private List<Funcionario> lista = new LinkedList<>();

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
        txtNome.setText("");
        txtSalario.setText("");
        txtCodigo.setText("");
        txtData.setText("");
    }


    @FXML
    private void pegaDadosTabela() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Funcionario func = tableFuncionario.getSelectionModel().getSelectedItem();

        try {
            txtCodigo.setText(String.valueOf(func.getCodFuncionario()));
            txtNome.setText(func.getNomeFuncionario());
            txtSalario.setText(func.getValorSalario());
            txtData.setText(func.getDataAdmissao().format(formatoData));

        } catch (NullPointerException e) {
            txtCodigo.setText("");
            txtNome.setText("");
            txtSalario.setText("");
            txtData.setText("");
        }
    }

    @FXML
    private void alterar() {

        if (Auxiliar.verificaCampos(txtCodigo, txtNome, txtSalario, txtData, lista, "update")) {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nome = txtNome.getText();
            String salario = txtSalario.getText();
            LocalDate data = LocalDate.parse(txtData.getText(), formatoData);

            Funcionario aux = ListOptions.contem(lista, codigo);

            aux.setNomeFuncionario(nome);
            aux.setValorSalario(salario);
            aux.setDataAdmissao(data);

            Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, lista);
        }
    }

    @FXML
    private void deletar() {

        if (Auxiliar.verificaCampos(txtCodigo, txtNome, txtSalario, txtData, lista, "update")) {

            int codigo = Integer.parseInt(txtCodigo.getText());
            Funcionario aux = ListOptions.contem(lista, codigo);
            lista.remove(aux);
            Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, lista);
            limpar();
        }
    }

    public void switchToPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
