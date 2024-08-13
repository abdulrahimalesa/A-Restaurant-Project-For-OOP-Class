package com.example.donemprojesiyeni;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean answer;

    public static boolean display(String title, String message){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);

        Label label1 = new Label();
        label1.setFont(Font.font("Calibri Light", FontWeight.NORMAL, 20));
        label1.setText(message);

        Button yesButton = new Button();
        yesButton.setText("Evet");
        yesButton.setStyle("-fx-background-radius: 50 ; -fx-background-color: linear-gradient(#E8E8E8, #b9fccd)");
        yesButton.setFont(Font.font("Calibri Light", FontWeight.NORMAL, 15));
        yesButton.setOnMouseClicked(e -> {
            answer = true;
            window.close();
        });

        Button noButton = new Button();
        noButton.setText("Hayır");
        noButton.setStyle("-fx-background-radius: 50 ; -fx-background-color: linear-gradient(#E8E8E8, #b9fccd)");
        noButton.setFont(Font.font("Calibri Light", FontWeight.NORMAL, 15));
        noButton.setOnMouseClicked(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(label1,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(5);
        layout.setBackground(new Background(new BackgroundFill(Color.rgb(252,217,164), new CornerRadii(0), Insets.EMPTY)));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;

    }
}
