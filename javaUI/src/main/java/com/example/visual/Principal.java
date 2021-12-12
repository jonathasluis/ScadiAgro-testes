package com.example.visual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal extends Application {

    private static Stage stage;

    private static Scene visualPrincipal;
    private static Scene visualInsert;
    private static Scene visualUpdate;
    private static Scene visualSelect;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        FXMLLoader fxmlPrincipal = new FXMLLoader(Principal.class.getResource("principal.fxml"));
        visualPrincipal = new Scene(fxmlPrincipal.load(), 600, 500);

        FXMLLoader fxmlInsert = new FXMLLoader(Principal.class.getResource("insert.fxml"));
        visualInsert = new Scene(fxmlInsert.load(), 600, 500);

        FXMLLoader fxmlUpdate = new FXMLLoader(Principal.class.getResource("update.fxml"));
        visualUpdate = new Scene(fxmlUpdate.load(), 600, 500);

        FXMLLoader fxmlSelect = new FXMLLoader(Principal.class.getResource("select.fxml"));
        visualSelect = new Scene(fxmlSelect.load(), 600, 500);

        primaryStage.setTitle("Principal");

        primaryStage.setScene(visualPrincipal);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void change(int tela){
        switch (tela) {
            case 1 -> {
                stage.setScene(visualPrincipal);
                stage.setTitle("Principal");
            }
            case 2 -> {
                stage.setScene(visualInsert);
                stage.setTitle("Insert");
            }
            case 3 -> {
                stage.setScene(visualUpdate);
                stage.setTitle("Updat");
            }
            case 4 -> {
                stage.setScene(visualSelect);
                stage.setTitle("Select");
            }
        }
    }

}