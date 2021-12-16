package com.example.visual;

import backEnd.Dados;
import backEnd.Funcionario;
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

public class InsertController implements Initializable {

    private final LinkedList<Funcionario> listaNaoIndexada = new LinkedList<>();

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSalario;

    @FXML
    private TextField tfData;

    @FXML
    private TextField tfCodigo;

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

    /*
     * Inicializa a tela com a tabela preenchida
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dados.recupera(listaNaoIndexada);
        Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, listaNaoIndexada);
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        Dados.salvar(listaNaoIndexada);
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
    private void adicionar() {

        if (Auxiliar.verificaCampos(tfCodigo, tfNome, tfSalario, tfData, listaNaoIndexada, "insert")) {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            int codigo = Integer.parseInt(tfCodigo.getText());
            String nome = tfNome.getText();
            String salario = tfSalario.getText();
            LocalDate data = LocalDate.parse(tfData.getText(), formatoData);

            listaNaoIndexada.add(new Funcionario(codigo, nome, salario, data));
            Auxiliar.montaTabela(tableFuncionario, columnCod, columnNome, columnSalario, columnData, listaNaoIndexada);
            limpar();
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
        stage.show();
    }
}
