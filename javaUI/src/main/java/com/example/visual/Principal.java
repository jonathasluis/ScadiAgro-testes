package com.example.visual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Principal extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principal.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("PRINCIPAL");
        stage.getIcons().add(new Image("https://cdn.iconscout.com/icon/free/png-256/javascript-2752148-2284965.png")); // JS - Jonathas Sousa
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}