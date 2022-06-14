package com.example.pfe.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.pfe.R;
import com.example.pfe.pages.search;

public class custmerAdapter extends BaseAdapter {
    Context context;
    String Listbus[];
    int Listbusim[];
    LayoutInflater inflater;
    public custmerAdapter(Context cnt,String[] bus,int[] busim){
        this.context=cnt;
        this.Listbus= bus;
        this.Listbusim= busim;
        inflater = LayoutInflater.from(cnt);
    }




    @Override
    public int getCount() {
        return Listbusim.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        System.out.println(inflater);
        view= inflater.inflate(R.layout.activity_custemer,null);
        ImageView Imagbus = view.findViewById(R.id.imagebus);
        Imagbus.setImageResource(Listbusim[i]);
        return view;
    }
}
