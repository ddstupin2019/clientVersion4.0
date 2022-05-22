package com.example.prodanotest2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity4 extends AppCompatActivity {
ImageView c1,c2,c3,c4,c5,c6;
TextView name;
ListView listView;
Integer id;
static Integer triger;
ArrayList<Integer> cart, razdacha;
ArrayList<Card> nedCol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
        nedCol=ned();

    }
    private void init(){
        name=findViewById(R.id.textView1);

        c1=findViewById(R.id.cart1);
        c2=findViewById(R.id.cart2);
        c3=findViewById(R.id.cart3);
        c4=findViewById(R.id.cart4);
        c5=findViewById(R.id.cart5);
        c6=findViewById(R.id.cart6);
    }

    public void otrCart(ArrayList<Integer> input) {//сколько игроков карт
        ArrayList<Card> ned = ned();
        for (int i = 0; i < input.size(); i++) {
            switch (i) {
                case 1:
                    c1.setImageBitmap(sup(ned,input.get(i)));
                    break;
                case 2:
                    c2.setImageBitmap(sup(ned,input.get(i)));
                    break;
                case 3:
                    c3.setImageBitmap(sup(ned,input.get(i)));
                    break;
                case 4:
                    c4.setImageBitmap(sup(ned,input.get(i)));
                    break;
                case 5:
                    c5.setImageBitmap(sup(ned,input.get(i)));
                    break;
                case 6:
                    c6.setImageBitmap(sup(ned,input.get(i)));
                    break;
            }
        }
    }
    private Bitmap sup(ArrayList<Card> inp, Integer znach){
        for (int i = 0; i < 30; i++) {
            if(inp.get(i).col==znach){
                return inp.get(i).cartinca;
            }
        }
        return null;
    }

    public void addList(ArrayList<Integer> inp){
        ArrayList<Card> cards=new ArrayList<>();
        for (int i = 0; i < inp.size(); i++) {
            cards.add(nedCol.get(inp.get(i)));
        }

        final CardAdapter adapter;
        adapter = new CardAdapter(this,cards);
        // Привяжем массив через адаптер к ListView
        listView.setAdapter(adapter);
    }
    private void stadia2() {
        Integer maxPlayer = MainActivity2.database.getMaxPlayer();
        ArrayList<Integer> moncolI = coloda();
        for (int i = 0; i < 30 / maxPlayer; i++) {
            cart = new ArrayList<>();
            for (int j = 0; j < maxPlayer; j++) {
                cart.add(moncolI.get(i * maxPlayer + j));
            }
            Collections.sort(cart);
            otrCart(cart);
            Integer playingame = maxPlayer;
            for (int j = 1; j <= maxPlayer; j++) {
                id=j;
                addList(MainActivity2.database.getPlayer(id).getNedcol());
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        while (true){
                            if (triger!=0){
                                razdacha.add(triger);
                                Output o=MainActivity2.database.getPlayer(id);
                                ArrayList<Integer> a=o.getNedcol();
                                razdacha.add(a.get(triger));
                                a.remove(triger);
                                o.setNedcol(a);
                                MainActivity2.database.ubdate(o,id);
                                triger=0;
                                break;
                            }
                        }
                    }
                }.start();
            }

        }
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
    private ArrayList<Card> ned() {
        ArrayList<Card> c = new ArrayList<>();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.img_1);
        Card z = new Card(true, 1, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_2);
        z = new Card(true, 2, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_3);
        z = new Card(true, 3, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_4);
        z = new Card(true, 4, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_5);
        z = new Card(true, 5, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_6);
        z = new Card(true, 6, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_7);
        z = new Card(true, 7, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_8);
        z = new Card(true, 8, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_9);
        z = new Card(true, 9, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_10);
        z = new Card(true, 10, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_11);
        z = new Card(true, 11, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_12);
        z = new Card(true, 12, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_13);
        z = new Card(true, 13, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_14);
        z = new Card(true, 14, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_15);
        z = new Card(true, 15, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_16);
        z = new Card(true, 16, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_17);
        z = new Card(true, 17, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_18);
        z = new Card(true, 18, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_19);
        z = new Card(true, 19, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_20);
        z = new Card(true, 20, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_21);
        z = new Card(true, 21, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_22);
        z = new Card(true, 22, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_23);
        z = new Card(true, 23, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_24);
        z = new Card(true, 24, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_25);
        z = new Card(true, 25, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_26);
        z = new Card(true, 26, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_27);
        z = new Card(true, 27, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_28);
        z = new Card(true, 28, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_29);
        z = new Card(true, 29, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_30);
        z = new Card(true, 30, b);
        c.add(z);
        return c;
    }
    private ArrayList<Card> mon() {
        ArrayList<Card> c = new ArrayList<>();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_0);
        Card z = new Card(true, 0, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_0_2);
        z = new Card(true, 0, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_2);
        z = new Card(true, 2, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_2_2);
        z = new Card(true, 2, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_3);
        z = new Card(true, 3, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_3_2);
        z = new Card(true, 3, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_4);
        z = new Card(true, 4, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_4);
        z = new Card(true, 4, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_5);
        z = new Card(true, 5, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_5_2);
        z = new Card(true, 5, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_6);
        z = new Card(true, 6, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_6_2);
        z = new Card(true, 6, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_7);
        z = new Card(true, 7, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_7_2);
        z = new Card(true, 7, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_8);
        z = new Card(true, 8, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_8_2);
        z = new Card(true, 8, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_9);
        z = new Card(true, 9, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_9_2);
        z = new Card(true, 9, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_10);
        z = new Card(true, 10, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_10_2);
        z = new Card(true, 10, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_11);
        z = new Card(true, 11, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_11_2);
        z = new Card(true, 11, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_12);
        z = new Card(true, 12, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_12_2);
        z = new Card(true, 12, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_13);
        z = new Card(true, 13, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_13_2);
        z = new Card(true, 13, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_14);
        z = new Card(true, 14, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_14_2);
        z = new Card(true, 14, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_15);
        z = new Card(true, 15, b);
        c.add(z);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.img_cm_15_2);
        z = new Card(true, 15, b);
        c.add(z);
        return c;
    }

}