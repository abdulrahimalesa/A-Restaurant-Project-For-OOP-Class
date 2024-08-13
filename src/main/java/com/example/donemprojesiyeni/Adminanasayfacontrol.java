package com.example.donemprojesiyeni;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Adminanasayfacontrol {

    private FXUtil fxUtil;

    @FXML
    public void geri(ActionEvent e) throws IOException {

        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/admingiris.fxml" );
    }

    @FXML
    public void initialize()
    {
        fxUtil = new FXUtil();
    }

    @FXML
    public void evyemeklerekle(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/evyemek.fxml");
    }
    @FXML
    public void pizzaekle(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/pizzaadmin.fxml");
    }
    @FXML
    public void icecekekle(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/icecekadmin.fxml" );
    }
    @FXML
    public void tatliekle(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/tatliadmin.fxml" );
    }
    @FXML
    public void burgerekle(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/burgeradmin.fxml" );
    }
    @FXML
    public void durumekle(ActionEvent e) throws IOException {
        fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/durumadmin.fxml");
    }

}
