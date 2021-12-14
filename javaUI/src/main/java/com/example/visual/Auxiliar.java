package com.example.visual;

import backEnd.Funcionario;
import backEnd.ListOptions;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class Auxiliar {
    //classe auxiliar para a verificaçao de campos e criaçao de tabelas

    public static boolean verificaCampos(TextField txtCodigo, TextField txtNome, TextField txtSalario, TextField txtData,
                                   List<Funcionario> lista, String classe) {

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

        if (!txtData.getText().trim().matches("^(0[1-9]|[1,2][0-9]|3[0,1])/(0[1-9]|1[0-2])/\\d{4}$")) {
            alerta("Data Invalida!");
            txtData.requestFocus();
            return false;
        }

        if (ListOptions.contem(lista, Integer.parseInt(txtCodigo.getText())) != null && classe.equals("insert")) {
            alerta("Ja existe esse codigo!");
            txtCodigo.requestFocus();
            return false;
        }

        return true;
    }

    private static void alerta(String header) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setHeaderText(header);
        alert.show();
    }

    static void montaTabela(TableView<Funcionario> tableFuncionario, TableColumn<Funcionario, Integer> columnCod,
                             TableColumn<Funcionario, String> columnNome, TableColumn<Funcionario, String> columnSalario,
                             TableColumn<Funcionario, LocalDate> columnData,List<Funcionario> lista) {

        columnCod.setCellValueFactory(new PropertyValueFactory<>("codFuncionario"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
        columnSalario.setCellValueFactory(new PropertyValueFactory<>("valorSalario"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));

        tableFuncionario.getItems().setAll(lista);
    }

    static void montaTabela(TableView<Funcionario> tableFuncionario, TableColumn<Funcionario, Integer> columnCod,
                            TableColumn<Funcionario, String> columnNome, TableColumn<Funcionario, String> columnSalario,
                            TableColumn<Funcionario, LocalDate> columnData, TableColumn<Funcionario, String> columnDifData,
                            List<Funcionario> lista) {

        columnCod.setCellValueFactory(new PropertyValueFactory<>("codFuncionario"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
        columnSalario.setCellValueFactory(new PropertyValueFactory<>("valorSalario"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));
        columnDifData.setCellValueFactory(new PropertyValueFactory<>("tempoEmpresa"));
        tableFuncionario.getItems().setAll(lista);
    }
}
