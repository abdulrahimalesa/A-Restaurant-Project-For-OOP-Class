package com.example.donemprojesiyeni;

import com.example.donemprojesiyeni.model.data;
import com.example.donemprojesiyeni.model.siparis;
import com.example.donemprojesiyeni.veri.Dosyaİslemleri;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

import java.io.IOException;

public class PizzaMusteriControl {

    private FXUtil fxUtil;

    @FXML
    private GridPane dataList;

    @FXML
    public void initialize() {
        fxUtil = new FXUtil();
        Dosyaİslemleri service = new Dosyaİslemleri();
        ObservableList<data> dList = service.Okumak("pizaa");

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

            TextField adet = new TextField();
            adet.setFont(Font.font("Verdana", FontPosture.REGULAR , 15));
            adet.setPromptText("Adet");

            Button siparisEt = new Button("Siparis Et");
            siparisEt.setStyle("-fx-background-radius: 5 ; -fx-background-color: #ffffff; -fx-text-fill: red;  /*-fx-border-color: #ffffff*/ ");
            siparisEt.setFont(Font.font("Verdana", FontPosture.REGULAR , 10));
            Dialog<String> dialog = new Dialog<String>();
            siparisEt.setOnAction(event -> {
                Dosyaİslemleri service = new Dosyaİslemleri();
                siparis s = new siparis();
                s.setUrunAdi(d.getUrunAdi());
                s.setAdet(adet.getText());
                String ucret = String.valueOf(Double.parseDouble(d.getFiyat()) * Integer.parseInt(adet.getText()));
                s.setUcret(ucret);
                service.SiparisiYazmak(s, "siparis");

                dialog.setTitle("Siparis");
                ButtonType type = new ButtonType("Tamam", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("Sipariş Oluşturuldu.");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            });



            box.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            box.setAlignment(Pos.CENTER);
            box.setStyle("-fx-border-color: #ffffff; -fx-border-width : 1px  ");
            box.getChildren().addAll(ad, aciklama, fiyat, adet, siparisEt);
            dataList.addRow(row, box);
            col++;
            if(col == 4){
                row++;
                col = 0;
            }
        }
    }


    @FXML
    public void geri(ActionEvent e) throws IOException {

        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/ilksayfa.fxml" );

    }

}
