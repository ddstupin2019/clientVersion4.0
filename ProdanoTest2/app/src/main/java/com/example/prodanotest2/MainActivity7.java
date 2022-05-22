package com.example.prodanotest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity7 extends AppCompatActivity implements View.OnClickListener {
    static Button pas, podstavka, but_nedCol, but_monCol;
    static EditText stavkainp;
    static TextView balans, pl1st, pl1n, pl2st, pl2n, pl3st, pl3n, pl4st, pl4n, pl5st, pl5n;
    public static Canvas c;
    public static int st;
    Boolean nedcolbol=false,moncolbol=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
        Log.d("BY", "0");
        intit2();
        Igra1 i=MainActivity6.igra1;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (i.triger1){ }
                lol();
            }
        }.run();


    }

    private void intit2() {

        but_monCol=findViewById(R.id.but_monCol);
        but_nedCol=findViewById(R.id.but_medCol);
        pas = findViewById(R.id.pas);
        podstavka = findViewById(R.id.pods);

        stavkainp = findViewById(R.id.edittext1);
        balans = findViewById(R.id.balance);

        pl4st = findViewById(R.id.textView9);
        pl4n = findViewById(R.id.textView7);
        pl5st = findViewById(R.id.textView10);
        pl5n = findViewById(R.id.textView8);

        pl1n = findViewById(R.id.textView1);
        pl2n = findViewById(R.id.textView2);
        pl3n = findViewById(R.id.textView3);

        pl1st = findViewById(R.id.textView4);
        pl2st = findViewById(R.id.textView5);
        pl3st = findViewById(R.id.textView6);

        //pas.setOnClickListener(this);
        //podstavka.setOnClickListener(this);
        //but_nedCol.setOnClickListener(this);
        //but_monCol.setOnClickListener(this);

    }
    public void lol(){
        Intent intent = new Intent(MainActivity7.this,MainActivity8.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pas:
                st=0;
                break;
            case R.id.pods:
                st=Integer.valueOf(String.valueOf(stavkainp.getText()));
                break;
            case R.id.but_medCol:
                if(nedcolbol){
                    nedcolbol=false;
                    MainActivity6.igra1.getNEdCols();
                }else{
                    nedcolbol=true;
                    MainActivity6.igra1.getCarts();
                }
                break;
        }
    }

    public static void onClic() {
        pas.setClickable(false);
        stavkainp.setClickable(false);
        podstavka.setClickable(false);
    }

    public static void vklClick() {
        pas.setClickable(true);
        stavkainp.setClickable(true);
        podstavka.setClickable(true);
    }

    public static void setstavka(int inp, int stav){
        switch (inp){
            case 1:
                pl1st.setText(stav);
                break;
            case 2:
                pl2st.setText(stav);
                break;
            case 3:
                pl3st.setText(stav);
                break;
            case 4:
                pl4st.setText(stav);
                break;
            case 5:
                pl5st.setText(stav);
                break;
        }
    }
    static class DrawView extends View  {
        Paint paint;
        Path path;
        Integer shir, kolplaer, heit, colCartN = 6, colCartM = 0, kolIkr;
        Boolean gamestad;

        static ArrayList<Card> ned;
        static ArrayList<Card> mon;
        static Canvas c;

        public DrawView(Context context) {
            super(context);
            kolIkr = kolplaer;
            Log.d("BY", "1");
            paint = new Paint();
            path = new Path();
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLACK);
        }




        private ArrayList<Card> init() {
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

        private ArrayList<Card> init1() {
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

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Log.d("BY", "2");
            MainActivity6.igra1.setCanvas(canvas);
            ned=init();
            mon=init1();

            shir = canvas.getWidth();
            heit = canvas.getHeight();

            path.moveTo(shir/3,0);
            path.lineTo(shir/3,40);
            path.moveTo(shir/3*2,0);
            path.lineTo(shir/3*2,40);
            path.moveTo(0,40);
            path.lineTo(shir,40);
            path.moveTo(shir,heit-80);
            path.lineTo(shir,heit-20);
            path.moveTo(0,heit-60);
            path.lineTo(shir,heit-60);
            canvas.drawPath(path,paint);

            MainActivity6.igra1.gameStadia1();

            //Bitmap i = BitmapFactory.decodeResource(getResources(), R.drawable.img_30);
            //Bitmap i1= BitmapFactory.decodeResource(getResources(), R.drawable.img_30);
            //canvas.drawBitmap();
            //canvas.drawBitmap(i1, 0,0,paint);
        }
    }
}
