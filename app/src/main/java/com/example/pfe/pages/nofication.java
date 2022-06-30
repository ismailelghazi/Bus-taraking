package com.example.pfe.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pfe.R;
import com.example.pfe.controller.CustmerAdapter1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class nofication extends Fragment {


    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDbRef = mDatabase.getReference("notifications");
    int busim[]={R.drawable.fg,R.drawable.sd,R.drawable.sd};
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_nofication, container, false);
        mDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Integer> id = new ArrayList<Integer>();
                List<String> Text= new ArrayList<String>();
                List<String> day= new ArrayList<String>();

                for(DataSnapshot ds : snapshot.getChildren()) {
                    //id.add(ds.child("id").getValue(Integer.class));
                    Text.add(ds.child("day").getValue(String.class));
                    day.add(ds.child("text").getValue(String.class));
                    Log.d("TAG", id + " / " + Text+" / "+day);
                }
                List<Integer> images = new ArrayList<Integer>();
                int j = 0;
                for (int i = 0; i < Text.size(); i++) {
                    images.add(busim[j]);
                    j=j+1;
                    if(j==3){
                        j=0;
                    }
                }
                listView = (ListView) v.findViewById(R.id.List1);
                CustmerAdapter1 adapter0 = new CustmerAdapter1(getActivity(),Text,day,images);
                listView.setAdapter(adapter0);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Failed to read value.", error.toException());

            }
        });
        return v;
    }

}