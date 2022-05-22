package com.example.prodanotest2;

import android.graphics.Canvas;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Igra1 {
    private Boolean statusGame = false;
    private Canvas canvas;
    private ZaprosRet server;
    private Player player;
    private Otrisovka otr;
    private Root root;
    public int pozitionl;
    public Boolean triger1=true, triger2=true;

    public Igra1() {
        server = new ZaprosRet();
        player = new Player();
        player.setMaxPlayer(MainActivity5.numgame);
        otr = new Otrisovka(canvas);
    }

    private void addPlayer() {
        root = new Root();
        root.muxPlayer = MainActivity5.numgame;
        root.name = MainActivity5.name;
        Gson gson = new Gson();
        String json = gson.toJson(root);
        ArrayList<Integer> rez = server.createPlayer(json);
        player.setId(rez.get(0));
        player.setNam(rez.get(1));
    }

    public Boolean ojidanie() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                addPlayer();
                while (!server.getStatus(player.getId())) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        }
            }
        }.start();
        return true;
    }
    private Integer oneStav(int max){
        switch (max){
            case 3:
                return 18;
            case 4:
                return 18;
            case 5:
                return 14;
            case 6:
                return 14;
        }
        return 0;
    }

    public void gameStadia1() {
        ArrayList<Integer> stavki = null;
        Gson gson = new Gson();
        String json;
        ArrayList<Integer> nedCol = server.getNedCol(player.getId());
        player.setBalance(oneStav(player.getMaxPlayer()));
        for (int i = 0; i < 30 / player.getMaxPlayer(); i++) {

            ArrayList<Integer> cart = new ArrayList<>();
            for (int j = 0; j < player.getMaxPlayer(); j++) {
                cart.add(nedCol.get(i * player.getMaxPlayer() + j));
            }
            Collections.sort(cart);
            player.setCarts(cart);
            otr.otrCart(cart);
            while (true) {
                stavki = server.getNumPlayer(player.getId());
                if (stavki.get(player.getMaxPlayer() + 1) == player.getNam()) {
                    root.stavka = otr.Tun(player);
                    json = gson.toJson(root);
                    server.setStavka(json);
                    if (root.stavka == 0) {
                        root.nedCol = cart.get(0);
                        ArrayList<Integer> a=player.getNedCol();
                        a.add(cart.get(0));
                        player.setNedCol(a);
                        cart.remove(0);
                        json = gson.toJson(root);
                        server.setNedColPlayer(json);
                        otr.unClic();
                        break;
                    }
                } else {
                    for (int j = 0; j < stavki.size() - 1; j++) {
                        if (stavki.get(j) == 0) {
                            cart.remove(0);
                        }
                            MainActivity7.setstavka(j,stavki.get(j));
                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();

                        }
                            break;
                    }
                }
            }

        }
        triger1=true;
    }
    public void getNEdCols(){
        otr.otrCart(player.getNedCol());
    }
    public void getCarts(){
        otr.otrCart(player.getCarts());
    }

    public void gameStadia2(){
        ArrayList<Integer> moncol=server.getMonCol(player.getId());
        ArrayList<Integer> mnedcol=player.getNedCol();
        root.num=player.getNam();
        String json;
        Gson gson=new Gson();
        for (int i = 0; i < 30 / player.getMaxPlayer(); i++) {
            ArrayList<Integer> cart = new ArrayList<>();
            for (int j = 0; j < player.getMaxPlayer(); j++) {
                cart.add(moncol.get(i * player.getMaxPlayer() + j));
            }
            otr.otrCart(cart);
            MainActivity8.addList(mnedcol);
            while (true){
                if (pozitionl<=30){
                    root.monCol=mnedcol.get(pozitionl);
                    mnedcol.remove(pozitionl);
                    pozitionl=31;
                    json = gson.toJson(root);
                    server.setMonColDlylud(json);
                    MainActivity8.addList(mnedcol);
                    break;
                }
            }

            while (true){
                ArrayList<Integer> moncoldrug=server.getMonColDlylud(player.getId());
                if(moncoldrug.size()== player.getMaxPlayer()){
                    boolean a=true;
                    for (int j = 0; j < moncoldrug.size(); j++) {
                        if (moncoldrug.get(j)==0){
                            a=false;
                        }
                    }
                    if (a) {
                        otr.otrCart0(moncoldrug);
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }else {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }else {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        triger2=false;
    }

    public void setCanvas(Canvas canva){
        canvas=canva;
    }



    public ArrayList<Integer> rezultat(){
        String json;
        Gson gson=new Gson();
        root.balance=player.getBalance();
        server.setBalans(gson.toJson(root));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> rez=server.getBalance(player.getId());
        return rez;
    }
    public Player getPlayer(){
        return player;
    }
}
