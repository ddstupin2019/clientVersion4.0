package com.example.prodanotest2;

import android.graphics.Canvas;

import java.util.ArrayList;

public class Igra2 {
    Canvas canvas;
    BdRet database;
    ArrayList<Integer> nedcol;
    Integer maxPlayer;

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Igra2(BdRet database, Integer inp) {
        this.database = database;
        maxPlayer=inp;
    }

    public void stadia1(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                nedcol=coloda();
                for (int i = 0; i < 30 / maxPlayer; i++) {
                    ArrayList<Integer> cart = new ArrayList<>();
                    for (int j = 0; j < maxPlayer; j++) {
                        cart.add(nedcol.get(i * maxPlayer + j));
                    }
                    for (int j = 0; j < maxPlayer; j++) {


                    }
                }



            }
        }.start();

    }
    private ArrayList<Integer> coloda() {
        ArrayList<Integer> sd = new ArrayList<>();
        final Integer max = 30, min = 1;
        for (int i = 0; i < 30; i++) {
            Integer a = (int) (Math.random() * ((max - min) + 1)) + min;
            while (true) {
                if (ty(a, sd)) {
                    a = (int) (Math.random() * ((max - min) + 1)) + min;
                } else {
                    sd.add(a);
                    break;
                }
            }
        }
        return sd;
    }

    private boolean ty(int a, ArrayList<Integer> sd) {
        for (int i = 0; i < sd.size(); i++) {
            if (sd.get(i) == a) {
                return true;
            }
        }
        return false;
    }
}
