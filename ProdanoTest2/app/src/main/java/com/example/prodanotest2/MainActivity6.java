package com.example.prodanotest2;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {
    static Igra1 igra1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Canvas canvas = null;
        igra1=new Igra1();
        if (igra1.ojidanie()){
            Intent intent=new Intent(MainActivity6.this,MainActivity7.class);
            startActivity(intent);
        }
    }
}
