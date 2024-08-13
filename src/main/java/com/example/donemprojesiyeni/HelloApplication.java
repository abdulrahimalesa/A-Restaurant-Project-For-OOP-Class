package com.example.donemprojesiyeni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class HelloApplication extends Application {

    static Stage window;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/donemprojesiyeni/ilksayfa.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 440);
        window.setTitle("Abdulrahim.com");
        window.setScene(scene);
        window.show();

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

    }

    public static void closeProgram() {

        Boolean answer = ConfirmBox.display("Abdulrahim.com", "Programı kapatmak istiyor musunuz?");
        if (answer) {

            try {
                new FileWriter("C:\\Users\\Abdulrahim\\IdeaProjects\\Test\\DonemProjesiYeni\\siparis.txt", false).close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            window.close();
        }

    }
}