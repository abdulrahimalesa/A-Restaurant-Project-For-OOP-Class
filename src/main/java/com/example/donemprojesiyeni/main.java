package com.example.donemprojesiyeni;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class main {


    private FXUtil fxUtil;

    @FXML
    public void initialize()
    {
        fxUtil = new FXUtil();
    }



    @FXML
    public void evyemekler(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/evyemekmusteri.fxml");
    }
    @FXML
    public void burger(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/burger.fxml");
    }
    @FXML
    public void icecek(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/icecek.fxml" );
    }
    @FXML
    public void tatli(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/tatli.fxml" );
    }
    @FXML
    public void pizza(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/pizza.fxml");
    }
    public void durum(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/durum.fxml");
    }

    @FXML
    public void admingiris
            (ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/admingiris.fxml" );
    }

    @FXML
    public void hesap(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/siparis.fxml");
    }

}