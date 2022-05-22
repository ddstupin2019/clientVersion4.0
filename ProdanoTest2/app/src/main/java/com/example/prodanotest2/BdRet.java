package com.example.prodanotest2;

import android.util.Log;

import java.util.ArrayList;

public class BdRet {
    Db1 database;

    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    Integer maxPlayer;
    public BdRet(Db1 databse) { database=databse;}

    public void setPlayer(ArrayList<String> inp){
        Integer balance=18;
        switch (inp.size()){
            case 5:
                balance=14;
                //14
                break;
            case 6:
                balance=14;
                //14
                break;
        }
        for (int i = 0; i < inp.size(); i++) {
            Output output =new Output(inp.get(i),-1,balance);
            database.insertM(output);
            Log.d("My", output.toString());
        }
    }
    public ArrayList<Output> getNames(){
        ArrayList<Output> outputs=new ArrayList<>();
        for (int i = 1; i < maxPlayer+1; i++) {
            Output output=database.select(i);
            outputs.add(output);
        }
        return outputs;
    }
    public void setMaxPlayer(Integer inp){
        maxPlayer=inp;
    }
    public void ubdate(Output output, Integer id){
        database.ubdate(output,id);
    }
    public Integer getStavka(int id){
        return  database.select(id).getStavka();
    }
    public ArrayList<Integer> getNedCol(int id){
        return database.select(id).getNedcol();
    }
    public Output getPlayer(int id){return database.select(id);}
}
