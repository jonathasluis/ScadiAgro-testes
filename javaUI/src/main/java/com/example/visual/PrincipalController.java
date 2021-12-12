package com.example.visual;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrincipalController {

    @FXML
    void acaoInsert(ActionEvent e) {
        Principal.change(2);
    }

    @FXML
    void acaoUpdate() {
        Principal.change(3);
        System.out.println("update");
    }

    @FXML
    void acaoSelect() {
        Principal.change(4);
        System.out.println("select");
    }

}