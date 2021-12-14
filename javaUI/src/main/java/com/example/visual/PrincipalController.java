package com.example.visual;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToInsert(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("insert.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUpdate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("update.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSelect(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("select.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}