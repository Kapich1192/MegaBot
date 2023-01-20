package com.MegaBot.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Answer {
    String promo;
    ArrayList<String> honor = new ArrayList<>();
    ArrayList<String> apple = new ArrayList<>();
    ArrayList<String> samsung = new ArrayList<>();
    ArrayList<String> vivo = new ArrayList<>();
    ArrayList<String> xiaomi = new ArrayList<>();
    ArrayList<String> poco = new ArrayList<>();
    ArrayList<String> tecno = new ArrayList<>();

    public Answer() throws IOException{
        refreshPromo();
    }
    public String getCount() {
        return "honor: " + honor.size() + ";\n" +
                "apple: " + apple.size() + ";\n" +
                "samsung: " + samsung.size() + ";\n" +
                "vivo: " + honor.size() + ";\n" +
                "xiaomi: " + honor.size() + ";\n" +
                "poco: " + honor.size() + ";\n" +
                "tecno: " + honor.size() + ";\n"
                ;
    }
    public void refreshPromo() {
        File file = new File("promo/honor.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                honor.add(i);
                System.out.println(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String nextPromo(String key) {
        if(key.equals("honor") && honor.size() > 0){
            promo = "honor - " + honor.get(0);
            honor.remove(0);
        } else {
            promo = "Промики на Honor закончились(((";
        }
        return promo;
    }


}
