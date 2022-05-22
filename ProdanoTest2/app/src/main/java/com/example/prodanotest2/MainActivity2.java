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
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button run;
    EditText pl1,pl2,pl3,pl4,pl5,pl6;
    static BdRet database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("BY", "5");
        init();
    }
    public void init(){
        pl1=findViewById(R.id.play1);
        pl2=findViewById(R.id.play2);
        pl3=findViewById(R.id.play3);
        pl4=findViewById(R.id.play4);
        pl5=findViewById(R.id.play5);
        pl6=findViewById(R.id.play6);

        run=findViewById(R.id.bt1);
        run.setOnClickListener(this);

    }
    private boolean notNull(String inp){
        if(inp.equals("")){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt1:
                ArrayList<String> name=new ArrayList<>();
                for (int i = 1; i < 7; i++) {
                    String plnam=null;
                    switch (i){
                        case 1:
                            if (notNull(String.valueOf(pl1.getText()))) {
                                plnam = String.valueOf(pl1.getText());
                            }
                            break;
                        case 2:
                            if (notNull(String.valueOf(pl2.getText()))) {
                                plnam = String.valueOf(pl2.getText());
                            }
                            break;
                        case 3:
                            if (notNull(String.valueOf(pl3.getText()))) {
                                plnam = String.valueOf(pl3.getText());
                            }
                            break;
                        case 4:
                            if (notNull(String.valueOf(pl4.getText()))) {
                                plnam = String.valueOf(pl4.getText());
                            }
                            break;
                        case 5:
                            if (notNull(String.valueOf(pl5.getText()))) {
                                plnam = String.valueOf(pl5.getText());
                            }
                            break;
                        case 6:
                            if (notNull(String.valueOf(pl6.getText()))) {
                                plnam = String.valueOf(pl6.getText());
                            }
                            break;
                    }
                    if (plnam!=null){
                        name.add(plnam);
                    }
                }
                if (name.size()<3){
                    Toast.makeText(this,"Слишком мало игроков", Toast.LENGTH_LONG).show();
                }else {
                    Db1 db1=new Db1(this);
                    database=new BdRet(db1);
                    database.setPlayer(name);
                    database.setMaxPlayer(name.size());
                    intent = new Intent(MainActivity2.this,MainActivity3.class);
                    startActivity(intent);
                }
                break;


        }
    }
}