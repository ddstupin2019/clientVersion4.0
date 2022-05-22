package com.example.prodanotest2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity9 extends AppCompatActivity {

    TextView p1,p2,p3,p4,p5,p6,b1,b2,b3,b4,b5,b6;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        init();
        ArrayList<Integer> list=MainActivity6.igra1.rezultat();
        Player player=MainActivity6.igra1.getPlayer();
        for (int i = 0; i < list.size(); i++) {
            if (player.getNam()==i){
                switch (i){
                    case 1:
                        p1.setText("Ваш результат");
                        break;
                    case 2:
                        p2.setText("Ваш результат");
                        break;
                    case 3:
                        p3.setText("Ваш результат");
                        break;
                    case 4:
                        p4.setText("Ваш результат");
                        break;
                    case 5:
                        p5.setText("Ваш результат");
                        break;
                    case 6:
                        p6.setText("Ваш результат");
                        break;

                }
            }
            switch (i){
                case 1:
                    b1.setText(list.get(i));
                    break;
                case 2:
                    b2.setText(list.get(i));
                    break;
                case 3:
                    b3.setText(list.get(i));
                    break;
                case 4:
                    b4.setText(list.get(i));
                    break;
                case 5:
                    b5.setText(list.get(i));
                    break;
                case 6:
                    b6.setText(list.get(i));
                    break;

            }

        }
    }
    private void init(){
        p1=findViewById(R.id.player1);
        p2=findViewById(R.id.player2);
        p3=findViewById(R.id.player3);
        p4=findViewById(R.id.player4);
        p5=findViewById(R.id.player5);
        p6=findViewById(R.id.player6);

        b1=findViewById(R.id.textView1);
        b2=findViewById(R.id.textView2);
        b3=findViewById(R.id.textView3);
        b4=findViewById(R.id.textView4);
        b5=findViewById(R.id.textView5);
        b6=findViewById(R.id.textView6);

        but=findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity9.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}