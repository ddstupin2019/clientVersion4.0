package com.example.prodanotest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    TextView pl1na, pl2na, pl3na, pl4na, pl5na, pl6na, pl2st, pl3st, pl4st, pl5st, pl6st, balance;
    EditText setstavka;
    Button bal, nedB, pas, bt_st;
    ArrayList<Integer> nedCol;
    Boolean st=false, bt_otr=false;
    Integer mystavka,mybalance,id,mydadstavka,backplayerstavka;
    ImageView c1,c2,c3,c4,c5,c6;
    ArrayList<Integer> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
init();
stadia1();
    }

    public void init() {

        pl1na = findViewById(R.id.textView11);
        pl2na = findViewById(R.id.textView7);
        pl3na = findViewById(R.id.textView1);
        pl4na = findViewById(R.id.textView2);
        pl5na = findViewById(R.id.textView3);
        pl6na = findViewById(R.id.textView8);

        pl2st = findViewById(R.id.textView9);
        pl3st = findViewById(R.id.textView4);
        pl4st = findViewById(R.id.textView5);
        pl5st = findViewById(R.id.textView6);
        pl6st = findViewById(R.id.textView10);

        c1=findViewById(R.id.cart1);
        c2=findViewById(R.id.cart2);
        c3=findViewById(R.id.cart3);
        c4=findViewById(R.id.cart4);
        c5=findViewById(R.id.cart5);
        c6=findViewById(R.id.cart6);

        balance=findViewById(R.id.balance);
        setstavka = findViewById(R.id.edittext1);

        nedB = findViewById(R.id.nedcolB);
        pas = findViewById(R.id.pas);
        bt_st = findViewById(R.id.pods);

        pas.setOnClickListener(this);
        bt_st.setOnClickListener(this);
        nedB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_medCol:
                if(bt_otr){
                    bt_otr=false;
                    otrCart(cart);
                }else{
                    bt_otr=true;
                    otrCart(MainActivity2.database.getNedCol(id));
                }
                break;
            case R.id.pas:
                mybalance=mystavka/2+mystavka%2;
                mystavka=0;
                st=true;
                break;
            case R.id.pods:
                mystavka=Integer.valueOf(String.valueOf(setstavka.getText()));
                if(mydadstavka>mystavka && mybalance-(mystavka-mydadstavka)>0 && mystavka>backplayerstavka){
                    mybalance-=(mystavka-mydadstavka);
                    st=true;
                }else{
                    Toast.makeText(this, "Некорректные данные", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private Output otr(ArrayList<Output> inp, int maxPlayer){
        Log.d("ny", "otr");
        Log.d("lol", String.valueOf(inp.size()));
        for (int i = 0; i < maxPlayer; i++) {
            switch (i){
                case 0:
                    pl1na.setText(inp.get(i).getName());
                    balance.setText(String.valueOf(inp.get(i).getBalance()));
                    break;
                case 1:
                    pl2na.setText(inp.get(i).getName());
                    pl2st.setText(String.valueOf(inp.get(i).getStavka()));
                    break;
                case 2:
                    pl3na.setText(inp.get(i).getName());
                    pl3st.setText(String.valueOf(inp.get(i).getStavka()));
                    break;
                case 3:
                    pl4na.setText(inp.get(i).getName());
                    pl4st.setText(String.valueOf(inp.get(i).getStavka()));
                    break;
                    case 4:
                    pl5na.setText(inp.get(i).getName());
                    pl5st.setText(String.valueOf(inp.get(i).getStavka()));
                    break;
                case 5:
                    pl6na.setText(inp.get(i).getName());
                    pl6st.setText(String.valueOf(inp.get(i).getStavka()));
                    break;
            }
        }
        Output o=inp.get(0);
        mybalance=o.getBalance();
        mystavka=o.getStavka();
        mydadstavka=mystavka;
        backplayerstavka=inp.get(maxPlayer-1).getStavka();
            while (true){
                if(st){
                    st=false;
                    o.setStavka(mystavka);
                    o.setBalance(mybalance);
                    return o;
                }else{
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
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

        public void otrCart(ArrayList<Integer> input) {//сколько игроков карт
            ArrayList<Card> ned = ned();
            for (int i = 0; i < input.size(); i++) {
                switch (i) {
                    case 1:
                        c1.setImageBitmap(ned.get(input.get(i)).cartinca);
                        break;
                    case 2:
                        c2.setImageBitmap(ned.get(input.get(i)).cartinca);
                        break;
                    case 3:
                        c3.setImageBitmap(ned.get(input.get(i)).cartinca);
                        break;
                    case 4:
                        c4.setImageBitmap(ned.get(input.get(i)).cartinca);
                        break;
                    case 5:
                        c5.setImageBitmap(ned.get(input.get(i)).cartinca);
                        break;
                    case 6:
                        c6.setImageBitmap(ned.get(input.get(i)).cartinca);
                        break;

                }
            }
        }
        public void stadia1(){
                    Integer maxPlayer=MainActivity2.database.getMaxPlayer();
                    ArrayList<Integer>nedcolI=coloda();
                    for (int i = 0; i < 30 / maxPlayer; i++) {
                        cart = new ArrayList<>();
                        for (int j = 0; j < maxPlayer; j++) {
                            cart.add(nedcolI.get(i * maxPlayer + j));
                        }
                        Collections.sort(cart);
                        ArrayList<Output> bds=MainActivity2.database.getNames();
                        Integer playingame=maxPlayer;
                        Log.d("lol", "lo"+maxPlayer);
                        Log.d("lol", "lolo"+bds.get(0).getStavka());
                        for (int j =1; j <= maxPlayer; j++) {
                            id=j;
                            Log.d("My", "lolol"+j);
                            if(bds.get(1).getStavka()!=0){
                                otrCart(cart);
                                Output play=otr(bds, maxPlayer);
                                if(play.getStavka()==0){
                                    ArrayList<Integer> a=play.getNedcol();
                                    a.add(cart.get(0));
                                    cart.remove(0);
                                }
                                MainActivity2.database.ubdate(play,j);
                                bds.add(0,bds.get(maxPlayer-1));
                                bds.remove(maxPlayer);
                            }
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
    }