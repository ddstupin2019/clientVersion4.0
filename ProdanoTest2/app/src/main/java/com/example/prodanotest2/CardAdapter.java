package com.example.prodanotest2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<Card> {
    ArrayList<Card> list;
    public CardAdapter(@NonNull Context context, @NonNull ArrayList<Card> objects) {
        super(context, R.layout.cartdlylou, objects);
        list = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cartdlylou, null);
        }

        ImageButton imageButton=convertView.findViewById(R.id.imageButton);
        imageButton.setImageBitmap(list.get(position).cartinca);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity6.igra1.pozitionl=position;
            }
        });

        return convertView;
    }

}
