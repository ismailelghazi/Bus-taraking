package com.example.pfe.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.pfe.R;
import com.example.pfe.controller.custmerAdapter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class search extends Fragment {
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDbRef = mDatabase.getReference("Bus");

    String bus[]= {"bus1","bus2","bus3","g"};
    int busim[]={R.drawable.bus_serch,R.drawable.bus_serch1,R.drawable.bus_serch2};
    ListView listView;
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public search() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment search.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static search newInstance(String param1, String param2) {
//        search fragment = new search();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_search, container, false);

        mDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> busId = new ArrayList<String>();
                List<String> fromId= new ArrayList<String>();
                List<String> toId= new ArrayList<String>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    busId.add(ds.child("ID").getValue(String.class));
                    fromId.add(ds.child("PlaceA").getValue(String.class));
                    toId.add(ds.child("PlaceB").getValue(String.class));
                    Log.d("TAG", busId + " / " + fromId);
                }
                List<Integer> images = new ArrayList<Integer>();
                int j = 0;
                for (int i = 0; i < busId.size(); i++) {
                    images.add(busim[i]);
                    j=j+1;
                    if(j==3){
                        j=0;
                    }
                }

                listView = (ListView) v.findViewById(R.id.List);
                custmerAdapter adapter = new custmerAdapter(getActivity(), images , busId , fromId , toId);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("Failed to read value.", error.toException());
            }
        });
        // Inflate the layout for this fragment

        return v;

    }
}