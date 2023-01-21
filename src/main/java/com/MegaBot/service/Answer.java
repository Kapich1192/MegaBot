package com.MegaBot.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Answer {
    private String promo;
    private ArrayList<String> honor = new ArrayList<>();
    private ArrayList<String> apple = new ArrayList<>();
    private ArrayList<String> samsung = new ArrayList<>();
    private ArrayList<String> vivo = new ArrayList<>();
    private ArrayList<String> xiaomi = new ArrayList<>();
    private ArrayList<String> poco = new ArrayList<>();
    private ArrayList<String> tecno = new ArrayList<>();
    private ArrayList<String> realme = new ArrayList<>();

    public Answer() throws IOException{
        refreshPromo();
    }
    public String getCount() {
        return "honor: " + honor.size() + ";\n" +
                "apple: " + apple.size() + ";\n" +
                "samsung: " + samsung.size() + ";\n" +
                "vivo: " + vivo.size() + ";\n" +
                "xiaomi: " + xiaomi.size() + ";\n" +
                "poco: " + poco.size() + ";\n" +
                "tecno: " + tecno.size() + ";\n" +
                "realme: " + realme.size() + ";\n"
                ;
    }
    public void refreshPromo() {
        honor.clear();
        apple.clear();
        samsung.clear();
        vivo.clear();
        xiaomi.clear();
        poco.clear();
        tecno.clear();
        realme.clear();

        File file = new File("promo/honor.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                honor.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        file = new File("promo/apple.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                apple.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        file = new File("promo/realme.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                realme.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        file = new File("promo/tecno.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                tecno.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        file = new File("promo/poco.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                poco.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        file = new File("promo/samsung.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                samsung.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        file = new File("promo/vivo.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                vivo.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        file = new File("promo/xiaomi.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                xiaomi.add(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String nextPromo(String key) {
        if(key.equals("honor")) {
            if (honor.size() > 0) {
                promo = "honor - " + honor.get(0);
                honor.remove(0);
            } else {
                promo = "Промики на Honor закончились(((";
            }
        } else if (key.equals("apple")) {
            if (apple.size() > 0) {
                promo = "apple - " + apple.get(0);
                apple.remove(0);
            } else {
                promo = "Промики на Apple закончились(((";
            }
        } else if(key.equals("samsung")) {
            if (samsung.size() > 0) {
                promo = "samsung - " + samsung.get(0);
                samsung.remove(0);
            } else {
                promo = "Промики на Samsung закончились(((";
            }
        } else if (key.equals("realme") ) {
            if ( realme.size() > 0) {
                promo = "realme - " + realme.get(0);
                realme.remove(0);
            } else {
                promo = "Промики на Realme закончились(((";
            }
        } else if (key.equals("xiaomi") ) {
            if ( xiaomi.size() > 0) {
                promo = "xiaomi - " + xiaomi.get(0);
                xiaomi.remove(0);
            } else {
                promo = "Промики на Xiaomi закончились(((";
            }
        } else if (key.equals("poco") ) {
            if (poco.size() > 0) {
                promo = "poco - " + poco.get(0);
                poco.remove(0);
            } else {
                promo = "Промики на Poco закончились(((";
            }
        } else if (key.equals("vivo")) {
            if (vivo.size() > 0) {
                promo = "vivo - " + vivo.get(0);
                vivo.remove(0);
            } else {
                promo = "Промики на Vivo закончились(((";
            }
        } if (key.equals("tecno")) {
            if ( tecno.size() > 0) {
                promo = "tecno - " + tecno.get(0);
                tecno.remove(0);
            } else {
                promo = "Промики на Tecno закончились(((";
            }
        }
        return promo;
    }
/* Действия с промиками Honor */
    public void addPromoHonor(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                honor.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/honor.txt"));
            for (int i = 0; i < honor.size(); i++) {
                writer.write(honor.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }
    /* Действия с промиками Apple */
    public void addPromoApple(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                apple.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/apple.txt"));
            for (int i = 0; i < apple.size(); i++) {
                writer.write(apple.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }

    /* Действия с промиками Realme */
    public void addPromoRealme(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                realme.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/realme.txt"));
            for (int i = 0; i < realme.size(); i++) {
                writer.write(realme.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }

    /* Действия с промиками Samsung */
    public void addPromoSamsung(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                samsung.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/samsung.txt"));
            for (int i = 0; i < samsung.size(); i++) {
                writer.write(samsung.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }
    /* Действия с промиками Xiaomi */
    public void addPromoXiaomi(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
               xiaomi.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/xiaomi.txt"));
            for (int i = 0; i < xiaomi.size(); i++) {
                writer.write(xiaomi.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }
    /* Действия с промиками Poco */
    public void addPromoPoco(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                poco.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/poco.txt"));
            for (int i = 0; i < poco.size(); i++) {
                writer.write(poco.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }

    /* Действия с промиками Honor */
    public void addPromoVivo(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                vivo.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/vivo.txt"));
            for (int i = 0; i < vivo.size(); i++) {
                writer.write(vivo.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }

    /* Действия с промиками Tecno */
    public void addPromoTecno(String key) {
        String[] list = key.split(" ");
        if(list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                tecno.add(list[i]);
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("promo/tecno.txt"));
            for (int i = 0; i < tecno.size(); i++) {
                writer.write(tecno.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.refreshPromo();
    }
}
