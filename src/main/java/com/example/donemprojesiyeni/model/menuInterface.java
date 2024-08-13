package com.example.donemprojesiyeni.model;

import javafx.collections.ObservableList;

public interface menuInterface {

    void kaydet(data model, String type);
    void silme(String type, int index);
}
