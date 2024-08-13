package com.example.donemprojesiyeni;

import com.example.donemprojesiyeni.model.data;
import com.example.donemprojesiyeni.veri.Dosyaİslemleri;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TatliControl {

    private FXUtil fxUtil;


    private Stage dialogStage;

    @FXML
    private TextField tatliAdi;

    @FXML
    private TextField tatliAciklama;


    @FXML
    private TextField tatliFiyat;

    @FXML
    private GridPane dataList;

    @FXML
    public void initialize() {
        fxUtil = new FXUtil();
        Dosyaİslemleri service = new Dosyaİslemleri();
        ObservableList<data> dList = service.Okumak("tatli");

        if(dataList != null){

            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(500);
            dataList.getColumnConstraints().addAll(column1, column1, column1);

            RowConstraints row1 = new RowConstraints();
            row1.setPercentHeight(500);
            dataList.getRowConstraints().addAll(row1, row1, row1);

            fillData(dList);

        }
    }

    public void fillData(ObservableList<data> dList){
        int row = 0;
        int col = 0;
        int index = 0;
        for(data d : dList){

            VBox box = new VBox();

            Label ad = new Label(d.getUrunAdi());
            ad.setStyle(" -fx-text-fill: #ffffff;  /*-fx-border-color: #ffffff*/ ");
            ad.setFont(Font.font("Verdana", FontPosture.REGULAR , 15));

            Label aciklama = new Label(d.getUrunAciklama());
            aciklama.setStyle(" -fx-text-fill: #ffffff;  /*-fx-border-color: #ffffff*/ ");
            aciklama.setFont(Font.font("Verdana", FontPosture.REGULAR , 15));

            Label fiyat = new Label(d.getFiyat()+"tl");
            fiyat.setStyle(" -fx-text-fill: #ffffff;  /*-fx-border-color: #ffffff*/ ");
            fiyat.setFont(Font.font("Verdana", FontPosture.REGULAR , 15));

            Button sil = new Button("Sil");
            sil.setStyle("-fx-background-radius: 5 ; -fx-background-color: #ffffff; -fx-text-fill: red;  /*-fx-border-color: #ffffff*/ ");
            sil.setFont(Font.font("Verdana", FontPosture.REGULAR , 10));

            int finalIndex = index;
            sil.setOnAction(event -> {
                Dosyaİslemleri service = new Dosyaİslemleri();
                service.silme("tatli", finalIndex+1);
                dataList.getChildren().clear();
                fillData(service.Okumak("tatli"));
            });

            box.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            box.setAlignment(Pos.CENTER);
            box.setStyle("-fx-border-color: #ffffff; -fx-border-width : 1px  ");
            box.getChildren().addAll(ad, aciklama, fiyat, sil);
            dataList.addRow(row, box);
            col++;
            index++;
            if(col == 4){
                row++;
                col = 0;
            }
        }
    }

    @FXML
    void tatliKaydet(ActionEvent event){
        data d = new data(tatliAdi.textProperty(), tatliAciklama.textProperty(), tatliFiyat.textProperty());

        Dosyaİslemleri service = new Dosyaİslemleri();
        service.kaydet(d, "tatli");

        closeStage(event);
    }

    @FXML
    void tatliEkle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/donemprojesiyeni/tatliekle.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
        dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();

        Dosyaİslemleri service = new Dosyaİslemleri();
        dataList.getChildren().clear();
        fillData(service.Okumak("tatli"));
    }

    //Dialogu kapat
    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void geri(ActionEvent e) throws IOException {

        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/adminanafayfa.fxml" );

    }
}
