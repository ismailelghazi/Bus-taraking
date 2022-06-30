package com.example.pfe.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pfe.R;

import java.util.List;

public class CustmerAdapter1 extends BaseAdapter {
    Context context;
    List<String> day;
    List<String> Text;
    List<Integer> imgnotif;
    LayoutInflater inflater;

    public CustmerAdapter1(Context co, List<String> day, List<String> text, List<Integer> listnotif) {
        this.context = co;
        this.day = day;
        this.Text = text;
        this.imgnotif = listnotif;
        inflater = LayoutInflater.from(co);

    }




    @Override
    public int getCount() {
        return imgnotif.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        System.out.println(inflater);
        view= inflater.inflate(R.layout.activity_notification,null);
        TextView textN = view.findViewById(R.id.notif_text2);
        TextView dayN = view.findViewById(R.id.notif_day);
        ImageView ImagN = view.findViewById(R.id.image_notification);
        dayN.setText(day.get(i));
        textN.setText(Text.get(i));
        ImagN.setImageResource(imgnotif.get(i));
        return view;
    }
}
