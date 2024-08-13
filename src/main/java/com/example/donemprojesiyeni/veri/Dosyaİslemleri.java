package com.example.donemprojesiyeni.veri;

import com.example.donemprojesiyeni.model.data;
import com.example.donemprojesiyeni.model.menuInterface;
import com.example.donemprojesiyeni.model.siparis;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Scanner;

public class Dosyaİslemleri implements menuInterface {

    @Override
    public void kaydet(data model, String type) {
        dosyaOluştur(type);
        dosyaYaz(model, type);
    }

    @Override
    public void silme(String type, int index) {

        try
        {
            BufferedReader br=new BufferedReader(new FileReader(getFileName(type)));

            StringBuffer sb=new StringBuffer("");

            int linenumber=1;
            String line;

            while((line=br.readLine())!=null)
            {
                if(linenumber<index||linenumber>=index+1)
                    sb.append(line+"\n");
                linenumber++;
            }
            if(index+1>linenumber)
                System.out.println("Dosyanın sonuna ulaşıldı.");
            br.close();

            FileWriter fw=new FileWriter(new File(getFileName(type)));
            fw.write(sb.toString());
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("Bir şeyler korkunç derecede ters gitti: "+e.getMessage());
        }

    }

    public ObservableList<data> Okumak(String type) {
        ObservableList<data> list = FXCollections.observableArrayList();
        try {
            File myObj = new File(getFileName(type));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String arr[] = data.split("&&");
                if(arr.length == 3){
                    data model = new data(new SimpleStringProperty(arr[0]), new SimpleStringProperty(arr[1]), new SimpleStringProperty(arr[2]));
                    list.add(model);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bir hata oluştu.");
            e.printStackTrace();
        }
        return list;
    }

    public void dosyaOluştur(String type) {
        String f = getFileName(type);
        File file = new File(f);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void dosyaYaz(data model, String type) {
        StringBuilder sb = new StringBuilder();
        sb.append(model.getUrunAdi()).append("&&");
        sb.append(model.getUrunAciklama()).append("&&");
        sb.append(model.getFiyat()).append("\n");
        try {
            String fileName = getFileName(type);
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(sb.toString());
            fw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SiparisiYazmak(siparis model, String type) {
        StringBuilder sb = new StringBuilder();
        sb.append(model.getUrunAdi()).append("&&");
        sb.append(model.getAdet()).append("&&");
        sb.append(model.getUcret()).append("\n");
        try {
            String fileName = getFileName(type);
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(sb.toString());
            fw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getFileName(String type) {
        if (type.equals("yemek")) {
            return System.getProperty("user.dir") + File.separator + "yemek.txt";
        } else if (type.equals("pizaa")) {
            return System.getProperty("user.dir") + File.separator + "pizaa.txt";
        } else if (type.equals("tatli")) {
            return System.getProperty("user.dir") + File.separator + "tatli.txt";
        } else if (type.equals("icecek")) {
            return System.getProperty("user.dir") + File.separator + "icecek.txt";
        } else if(type.equals("siparis")){
            return System.getProperty("user.dir") + File.separator + "siparis.txt";
        }else if(type.equals("burger")){
            return System.getProperty("user.dir") + File.separator + "burger.txt";
        }else if(type.equals("dorum")){
            return System.getProperty("user.dir") + File.separator + "dorum.txt";
        } else {
            return "";
        }
    }


}
