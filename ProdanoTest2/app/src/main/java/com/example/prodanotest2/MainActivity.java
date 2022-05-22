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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button local, set;

    static BdRet database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("BY", "5");
        init();
    }
    public void init(){
        local=findViewById(R.id.local);
        local.setOnClickListener(this);

        set=findViewById(R.id.set);
        set.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.local:
                intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.set:
                intent = new Intent(MainActivity.this,MainActivity5.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mosigra.ru/prodano/rules/"));
                startActivity(intent);
                break;

        }
    }
}