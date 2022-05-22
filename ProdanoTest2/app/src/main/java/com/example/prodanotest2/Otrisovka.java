package com.example.prodanotest2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Otrisovka {
    Canvas canvas;
    Path path;
    Paint paint;
    ArrayList<Card> ned;
    ArrayList<Card> mon;
    Button pas;



    public Otrisovka(Canvas canvas) {
        this.canvas = canvas;
        paint = new Paint();
        path = new Path();
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        ArrayList<Card> ned=MainActivity7.DrawView.ned;
        ArrayList<Card> mon=MainActivity7.DrawView.mon;
    }

    //для отрисовки карт и интерфейса
    public void otrCart(ArrayList<Integer> input){//сколько игроков карт
        ArrayList<Bitmap> carts=new ArrayList<>();
        Integer shir=canvas.getWidth()-600;
        Integer heit=canvas.getHeight();
        double h=20;
        Integer t=0;
        for (int i = 0; i < input.size(); i++) {
            Bitmap cart = ned.get(i).cartinca;
            cart = Bitmap.createScaledBitmap(cart,shir/3, (int) (shir/3*1.5),true);
            canvas.drawBitmap(cart,t,(int)h,paint);
            Log.d("BY", i+" "+t+" "+h);
            if(i==3) {
                h+=shir/3*1.5;
                t=0;
            }else {
                t+=shir/3;
            }
        }
    }
    public void otrCart0(ArrayList<Integer> input){//сколько игроков карт
        ArrayList<Bitmap> carts=new ArrayList<>();
        Integer shir=canvas.getWidth();
        Integer heit=canvas.getHeight();
        double h=0;
        Integer t=0;
        for (int i = 0; i < input.size(); i++) {
            Bitmap cart = ned.get(i).cartinca;
            cart = Bitmap.createScaledBitmap(cart, shir / 5, (int) (shir / 5 * 1.5), true);
            canvas.drawBitmap(cart, (int) h, t, paint);


            Log.d("BY", i + " " + t + " " + h);
            h += shir / 5;

        }
        }
    public void unClic(){
        //отключить кнопки
        MainActivity7.onClic();
    }

    public Integer Tun(Player player){
        MainActivity7.vklClick();
        MainActivity7.st=100;
        while (MainActivity7.st==100){ }
        if (MainActivity7.st<0){MainActivity7.st=0;}
        if (MainActivity7.st<=player.getBalance()) {
            if (MainActivity7.st==0){
                player.setBalance(MainActivity7.st/2+MainActivity7.st%2+player.getBalance());
                return 0;
            }
            return MainActivity7.st;
        }else {
            MainActivity7.st=player.getBalance();
            player.setBalance(0);
            return MainActivity7.st;
        }

    }

    public void ubratSmallcart(){

    }
    public void pas(int num){

    }

    public void setStavka(int num, int stavka){


    }

}
