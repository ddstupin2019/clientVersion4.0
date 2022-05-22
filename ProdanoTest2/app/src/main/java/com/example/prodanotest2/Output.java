package com.example.prodanotest2;

import java.util.ArrayList;
import java.util.Scanner;

public class Output {
    private String name;
    private Integer stavka;
    private Integer balance;
    private ArrayList<Integer> nedcol,moncol;

    public Output(String name, Integer stavka, Integer balance) {
        this.name = name;
        this.stavka = stavka;
        this.balance = balance;
    }

    public Output() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStavka() {
        return stavka;
    }

    public void setStavka(Integer stavka) {
        this.stavka = stavka;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public ArrayList<Integer> getNedcol() {
        return nedcol;
    }

    public void setNedcol(ArrayList<Integer> nedcol) {
        this.nedcol = nedcol;
    }

    public ArrayList<Integer> getMoncol() {
        return moncol;
    }

    public void setMoncol(ArrayList<Integer> moncol) {
        this.moncol = moncol;
    }


    public String getNedcolStr() {
        return parserArray(nedcol);
    }

    public void setNedcol(String inp) {
        this.nedcol = parserString(inp);
    }

    public String getMoncolStr() {
        return parserArray(moncol);
    }

    public void setMoncol(String inp) {
        this.moncol = parserString(inp);
    }

    private ArrayList<Integer> parserString(String in){
        ArrayList<Integer> rez= new ArrayList<>();
        if(in!=null){
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextInt()) {
                rez.add(scanner.nextInt());
            }
        }
        return rez;
    }
    private String parserArray(ArrayList<Integer> inp){
        String rez = "";
        if(inp!=null){
            for (int i = 0; i < inp.size(); i++) {
                rez+=String.valueOf(inp.get(i))+' ';
            }
        }
        return rez;
    }

    @Override
    public String toString() {
        return "Output{" +
                "name='" + name + '\'' +
                ", stavka=" + stavka +
                ", balance=" + balance +
                ", nedcol=" + nedcol +
                ", moncol=" + moncol +
                '}';
    }
}
