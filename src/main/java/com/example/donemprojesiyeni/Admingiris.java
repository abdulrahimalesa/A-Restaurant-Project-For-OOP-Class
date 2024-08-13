package com.example.donemprojesiyeni;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Admingiris {

    private FXUtil fxUtil;


    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    public void initialize(){

        fxUtil = new FXUtil();
    }

    @FXML
    public void giris(ActionEvent e) throws IOException {
        String kulanıcıadı = username.getText();
        String pasord = password.getText();
        if (kulanıcıadı.equalsIgnoreCase("Admin") && pasord.equalsIgnoreCase("123")) {
            fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/adminanafayfa.fxml");
        } else {
            fxUtil.yonlendirmek(e, "/com/example/donemprojesiyeni/hatamesaj.fxml");

        }
    }

    @FXML
    public void geri(ActionEvent e) throws IOException {

        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/ilksayfa.fxml" );
    }

    @FXML
    public void openLogin(ActionEvent e) throws IOException {

        fxUtil.yonlendirmek(e,"/com/example/donemprojesiyeni/admingiris.fxml" );
    }

}
