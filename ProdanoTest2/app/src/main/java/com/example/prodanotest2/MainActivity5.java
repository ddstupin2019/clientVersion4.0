package com.example.prodanotest2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    RadioButton b3,b4,b5,b6;
    EditText e;
    static Integer numgame=3;
    static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Log.d("BY", "5");
        init();
    }
    public void init(){
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.radio1);
        b4=findViewById(R.id.radio2);
        b5=findViewById(R.id.radio3);
        b6=findViewById(R.id.radio4);
        e=findViewById(R.id.edittext1);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button1:
                Log.d("BY", "5");
                name= String.valueOf(e.getText());
                if (name!=null){
                    intent = new Intent(MainActivity5.this,MainActivity6.class);
                    startActivity(intent);
                }

                break;
            case R.id.radio1:
                numgame=3;
                break;
            case R.id.radio2:
                numgame=4;
                break;
            case R.id.radio3:
                numgame=5;
                break;
            case R.id.radio4:
                numgame=6;
                break;


        }
    }
}