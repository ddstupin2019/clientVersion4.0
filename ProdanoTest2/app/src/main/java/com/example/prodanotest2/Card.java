package com.example.prodanotest2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Card {
    Boolean status;
    Bitmap cartinca;
    Integer col;

    public Card(Boolean status, Integer col, Bitmap cartinca) {
        this.status = status;
        this.cartinca = cartinca;
        this.col = col;
    }
}
