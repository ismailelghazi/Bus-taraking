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
import com.example.pfe.pages.search;

import java.util.List;

public class custmerAdapter extends BaseAdapter {
    Context context;
    List<Integer> Listbusim;
    List<String> busId;
    List<String>  fromId;
    List<String>  toId;
    LayoutInflater inflater;
    public custmerAdapter(Context cnt, List<Integer> busim , List<String>  busId,
                          List<String>  fromId,
                          List<String>  toId){
        this.busId = busId;
        this.fromId = fromId;
        this.toId= toId;
        this.context=cnt;
        this.Listbusim= busim;
        inflater = LayoutInflater.from(cnt);
    }




    @Override
    public int getCount() {
        return Listbusim.size();
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
        view= inflater.inflate(R.layout.activity_custemer,null);
        TextView busIdTV = view.findViewById(R.id.busId);
        TextView toIdTV = view.findViewById(R.id.toId);
        TextView fromIdTV = view.findViewById(R.id.fromid);
        ImageView Imagbus = view.findViewById(R.id.imagebus);
        fromIdTV.setText(fromId.get(i));
        busIdTV.setText(busId.get(i));
        toIdTV.setText(toId.get(i));
        Imagbus.setImageResource(Listbusim.get(i));
        return view;
    }
}
