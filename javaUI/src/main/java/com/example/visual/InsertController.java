package com.example.visual;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class InsertController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtCodigo;

    @FXML
    private void voltar() {
        Principal.change(1);
        limpar();
    }

    @FXML
    private void limpar() {
        txtNome.setText("");
        txtSalario.setText("");
        txtCodigo.setText("");
        txtData.setText("");
    }

    private boolean verificaCampos() {

        if (!txtCodigo.getText().trim().matches("^\\d*[0-9]$") || txtCodigo.getText().equals("0")) {
            alerta("CODIGO");
            txtCodigo.requestFocus();
            return false;
        }

        if (txtNome.getText().trim().equals("")) {
            alerta("NOME");
            txtNome.requestFocus();
            return false;
        }

        if (!txtSalario.getText().trim().matches("^\\d*[0-9](,|.\\d*[0-9])?$")) {
            alerta("SALARIO");
            txtSalario.requestFocus();
            return false;
        }

        if (!txtData.getText().trim().matches("^(0[1-9]|[1,2][0-9]|3[0,1])/(0[1-9]|1[0,1,2])/\\d{4}$")) {
            alerta("DATA DE ADMISSAO");
            txtData.requestFocus();
            return false;
        }

        return true;
    }

    private void alerta(String assunto) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setHeaderText(assunto + " inválido(a)");
        alert.setContentText("insira um(a) " + assunto + " valido(a)!!!");
        alert.show();
    }

}
