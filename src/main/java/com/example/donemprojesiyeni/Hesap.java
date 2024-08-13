package com.example.donemprojesiyeni;

import com.example.donemprojesiyeni.model.data;
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

public class Hesap{

    private FXUtil fxUtil;

    @FXML
    private GridPane dataList;

    @FXML
    public void initialize() {
        fxUtil = new FXUtil();
        Dosyaİslemleri service = new Dosyaİslemleri();
        ObservableList<data> dList = service.Okumak("siparis");

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

            Label ad = new Label("Yemeğin adı: " + d.getUrunAdi());
            ad.setStyle(" -fx-text-fill: #ffffff;  /*-fx-border-color: #ffffff*/ ");
            ad.setFont(Font.font("Verdana", FontPosture.REGULAR , 15));

            Label aciklama = new Label("Adet: "+d.getUrunAciklama());
            aciklama.setStyle(" -fx-text-fill: #ffffff;  /*-fx-border-color: #ffffff*/ ");
            aciklama.setFont(Font.font("Verdana", FontPosture.REGULAR , 15));

            Label fiyat = new Label("Toplam fiatı: " + d.getFiyat()+"tl");
            fiyat.setStyle(" -fx-text-fill: #ffffff;  /*-fx-border-color: #ffffff*/ ");
            fiyat.setFont(Font.font("Verdana", FontPosture.REGULAR , 15));


            Button Odemek = new Button("Öde");
            Odemek.setStyle("-fx-background-radius: 5 ; -fx-background-color: #ffffff; -fx-text-fill: red;  /*-fx-border-color: #ffffff*/ ");
            Odemek.setFont(Font.font("Verdana", FontPosture.REGULAR , 10));

            int finalIndex = index;
            Odemek.setOnAction(event -> {
                Dosyaİslemleri service = new Dosyaİslemleri();
                service.silme("siparis", finalIndex+1);
                dataList.getChildren().clear();
                fillData(service.Okumak("siparis"));


                Dialog<String> dialog = new Dialog<String>();

                dialog.setTitle("Ödeme");
                ButtonType type = new ButtonType("Tamam", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("Ödemeniz yapıldı.");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            });




            box.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            box.setAlignment(Pos.CENTER);
            box.setStyle("-fx-border-color: #ffffff; -fx-border-width : 1px  ");
            box.getChildren().addAll(ad, aciklama, fiyat, Odemek);
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
