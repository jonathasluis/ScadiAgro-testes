package com.example.visual;

import backEnd.Funcionario;
import backEnd.ListOptions;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.LinkedList;

/*
 * classe auxiliar para a verificaçao de campos e criaçao das tabelas
 */
public class Auxiliar {

    public static boolean verificaCampos(TextField tfCodigo, TextField tfNome, TextField tfSalario, TextField tfData,
                                         LinkedList<Funcionario> lista, String classe) {

        if (!tfCodigo.getText().trim().matches("^\\d*[0-9]$") || tfCodigo.getText().equals("0")) {
            alerta("Codigo Invalido!");
            tfCodigo.requestFocus();
            return false;
        }

        if (tfNome.getText().trim().equals("")) {
            alerta("Nome Invalido!");
            tfNome.requestFocus();
            return false;
        }

        if (!tfSalario.getText().trim().matches("^(\\d*[0-9])(([,.])[0-9][0-9])?$")) {
            alerta("Salario Invalido!");
            tfSalario.requestFocus();
            return false;
        }

        if (!tfData.getText().trim().matches("^(0[1-9]|[1,2][0-9]|3[0,1])/(0[1-9]|1[0-2])/\\d{4}$")) {
            alerta("Data Invalida!");
            tfData.requestFocus();
            return false;
        }

        // Se for a classe InsertController faz a verificação
        if (ListOptions.buscaCod(lista, Integer.parseInt(tfCodigo.getText())) != null && classe.equals("insert")) {
            alerta("Ja existe esse codigo!");
            tfCodigo.requestFocus();
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

    /*
     * Monta as tabelas do Insert e Update, SEM a coluna tempo de empresa (columnDifData).
     */
    static void montaTabela(TableView<Funcionario> tableFuncionario, TableColumn<Funcionario, Integer> columnCod,
                            TableColumn<Funcionario, String> columnNome, TableColumn<Funcionario, String> columnSalario,
                            TableColumn<Funcionario, LocalDate> columnData, LinkedList<Funcionario> lista) {

        columnCod.setCellValueFactory(new PropertyValueFactory<>("codFuncionario"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
        columnSalario.setCellValueFactory(new PropertyValueFactory<>("valorSalario"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));

        tableFuncionario.getItems().setAll(lista);
    }

    /*
     * Monta as tabelas do Select, COM a coluna tempo de empresa (columnDifData).
     */
    static void montaTabela(TableView<Funcionario> tableFuncionario, TableColumn<Funcionario, Integer> columnCod,
                            TableColumn<Funcionario, String> columnNome, TableColumn<Funcionario, String> columnSalario,
                            TableColumn<Funcionario, LocalDate> columnData, TableColumn<Funcionario, String> columnDifData,
                            LinkedList<Funcionario> lista) {

        columnCod.setCellValueFactory(new PropertyValueFactory<>("codFuncionario"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
        columnSalario.setCellValueFactory(new PropertyValueFactory<>("valorSalario"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));
        columnDifData.setCellValueFactory(new PropertyValueFactory<>("tempoEmpresa"));

        tableFuncionario.getItems().setAll(lista);
    }
}
