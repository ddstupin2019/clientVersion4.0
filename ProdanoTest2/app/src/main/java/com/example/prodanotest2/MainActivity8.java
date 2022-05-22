package com.example.prodanotest2;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity8 extends AppCompatActivity implements View.OnClickListener  {

    static ListView listView;
    private static Help.Help1 help1;
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainActivity8.DrawView(this));
        listView=findViewById(R.id.listView);
        button=findViewById(R.id.imageButton);
        button.setOnClickListener(this);
        help1=new Help.Help1();
        help1.setContext(this);
        Igra1 i=MainActivity6.igra1;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (i.triger2){ }
                Intent intent = new Intent(MainActivity8.this,MainActivity8.class);
                startActivity(intent);
            }
        }.run();




    }

    public static void end(){
        //тут надо прейти на 5
    }
    public static void addList(ArrayList<Integer> inp){
        ArrayList<Card> cards=new ArrayList<>();
        for (int i = 0; i < inp.size(); i++) {
            cards.add(DrawView.ned.get(inp.get(i)));
        }

        final CardAdapter adapter;
        adapter = new CardAdapter(help1.getContext(),cards);
        // Привяжем массив через адаптер к ListView
        listView.setAdapter(adapter);
    }




    @Override
    public void onClick(View view) {

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
            ned=init();
            mon=init1();
            MainActivity6.igra1.setCanvas(canvas);
            MainActivity6.igra1.gameStadia2();

            //Bitmap i = BitmapFactory.decodeResource(getResources(), R.drawable.img_30);
            //Bitmap i1= BitmapFactory.decodeResource(getResources(), R.drawable.img_30);
            //canvas.drawBitmap();
            //canvas.drawBitmap(i1, 0,0,paint);
        }
    }
}
