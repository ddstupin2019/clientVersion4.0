package com.example.prodanotest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Db1 {
    private static String DATABASE_NAME = "simple.db";
    private static String TABLE_NAME = "Prodano";
    private static int DATABASE_VERSION = 7;

    private String COLUMN_ID = "_id";
    private String COLUMN_playname = "play1name";
    private String COLUMN_playbalance= "play1balance";
    private String COLUMN_playstavka = "play1stavka";
    private String COLUMN_nedcol="nedcol";
    private String COLUMN_moncol="moncol";

    private int NUM_COLUMN_ID = 0;
    private int NUM_COLUMN_playname = 1;
    private int NUM_COLUMN_playbalance = 2;
    private int NUM_COLUMN_playstavka = 3;
    private int NUM_COLUMN_nedcol = 4;
    private int NUM_COLUMN_moncol = 5;

    private SQLiteDatabase databace;

    public Db1(Context context) {
        OpenHelper mOpenHelper = new OpenHelper(context);
        databace = mOpenHelper.getWritableDatabase();
    }

    public Output select(Integer id){
        Cursor cursor = databace.query(TABLE_NAME, null, COLUMN_ID+"="+id, null, null, null, null);
        Output output;
        Log.d("ny", "select"+id);
        if (cursor.moveToFirst()) {
            output = new Output();
            output.setName(cursor.getString(NUM_COLUMN_playname));
            output.setBalance(cursor.getInt(NUM_COLUMN_playbalance));
            output.setStavka(cursor.getInt(NUM_COLUMN_playstavka));
            output.setNedcol(cursor.getString(NUM_COLUMN_nedcol));
            output.setMoncol(cursor.getString(NUM_COLUMN_moncol));
            cursor.close();
            Log.d("ny", "Select  "+output.toString());
            return output;
        }
        cursor.close();
        Log.d("Main","null");
        return null;
    }
    public long insertM(Output output){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_playname, output.getName());
        contentValues.put(COLUMN_playbalance, output.getBalance());
        contentValues.put(COLUMN_playstavka, output.getStavka());
        contentValues.put(COLUMN_nedcol, output.getNedcolStr());
        contentValues.put(COLUMN_moncol, output.getMoncolStr());
        Log.d("ny", "insert  "+output.toString());
        return databace.insert(TABLE_NAME, null, contentValues);
    }

    public long ubdate(Output output, int id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_playname, output.getName());
        contentValues.put(COLUMN_playbalance, output.getBalance());
        contentValues.put(COLUMN_playstavka, output.getStavka());
        contentValues.put(COLUMN_nedcol, output.getNedcolStr());
        contentValues.put(COLUMN_moncol, output.getMoncolStr());
        return databace.update(TABLE_NAME, contentValues, "_id = ?", new String[]{String.valueOf(id)});
    }

    class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "create table " + TABLE_NAME + " (" +
                    COLUMN_ID + " integer primary key autoincrement not null, " +
                    COLUMN_playname + " text not null, " +
                    COLUMN_playbalance + " integer not null, " +
                    COLUMN_playstavka + " integer, "+
                    COLUMN_nedcol + " text, " +
                    COLUMN_moncol + " text );";
            Log.d("ny","on Create");
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + TABLE_NAME);
            onCreate(db);
        }
    }
    public static void setDatabaseVersion(int databaseVersion) { DATABASE_VERSION = databaseVersion; }
    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }
}
