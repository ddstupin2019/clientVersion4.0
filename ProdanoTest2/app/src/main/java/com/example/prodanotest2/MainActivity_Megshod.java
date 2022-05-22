package com.example.prodanotest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_Megshod extends AppCompatActivity {
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_megshod);
        bt=findViewById(R.id.sled);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.sled){
                    Intent intent = new Intent(MainActivity_Megshod.this,MainActivity3.class);
                    startActivity(intent);
                }
            }
        });
    }
}