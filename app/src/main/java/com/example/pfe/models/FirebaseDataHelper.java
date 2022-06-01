package com.example.pfe.models;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class FirebaseDataHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencestation;
    private List<station> stations=new ArrayList<>();
    public interface DataStatus
    {
        void DataIsLoaded(List<station> stations,List<String> keys);
        void DataIsInserted();
        void DataIsUpdate();
        void DataIsDeleted();
    }
    public FirebaseDataHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferencestation = mDatabase.getReference("stations");
    }
    public void readStation(final DataStatus dataStatus )
    {
        mReferencestation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            stations.clear();
            List<String> keys = new ArrayList<>();
            for (DataSnapshot KeyNode : snapshot.getChildren() )

            {
                keys.add(KeyNode.getKey());
                station stationss = KeyNode.getValue(station.class);
                stations.add(stationss);
            }
                dataStatus.DataIsLoaded(stations,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
