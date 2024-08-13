package com.example.donemprojesiyeni.model;

import javafx.beans.property.StringProperty;

public abstract class menu {

    private StringProperty urunAdi;
    private StringProperty urunAciklama;
    private StringProperty fiyat;

    public menu(StringProperty urunAdi, StringProperty urunAciklama, StringProperty fiyat) {
        this.urunAdi = urunAdi;
        this.urunAciklama = urunAciklama;
        this.fiyat = fiyat;
    }

    public menu(){

    }
    public String getUrunAdi() {
        return urunAdi.get();
    }

    public String getUrunAciklama() {
        return urunAciklama.get();
    }


    public String getFiyat() {
        return fiyat.get();
    }
    public void setFiyat(String fiyat) {
        this.fiyat.set(fiyat);
    }
}
