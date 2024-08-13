package com.example.donemprojesiyeni;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class FXUtil {

    public void yonlendirmek(ActionEvent e, String path) throws IOException {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene ().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        stage.setScene (scene);
        stage.show() ;

    }
}
