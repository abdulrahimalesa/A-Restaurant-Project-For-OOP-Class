package com.example.donemprojesiyeni.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class siparis {

        private StringProperty urunAdi = new SimpleStringProperty();
        private StringProperty adet = new SimpleStringProperty();
        private StringProperty ucret = new SimpleStringProperty();


        public String getUrunAdi() {
            return urunAdi.get();
        }

        public void setUrunAdi(String urunAdi) {
            this.urunAdi.set(urunAdi);
        }

        public String getAdet() {
            return adet.get();
        }


        public void setAdet(String adet) {
            this.adet.set(adet);
        }

        public String getUcret() {
            return ucret.get();
        }


        public void setUcret(String ucret) {
            this.ucret.set(ucret);
        }
    }
