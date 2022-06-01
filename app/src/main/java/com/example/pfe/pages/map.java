package com.example.pfe.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pfe.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link map#newInstance} factory method to
// * create an instance of this fragment.
// */
public class map extends Fragment   {



    //    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public map() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment map.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static map newInstance(String param1, String param2) {
//        map fragment = new map();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
private GoogleMap mMap;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDbRef = mDatabase.getReference("stations");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    LatLng cityLatLng = new LatLng(27.1500,-13.1991);
                LatLngBounds ADELAIDE = new LatLngBounds(
                        new LatLng(-35.0, 138.58), new LatLng(-34.9, 138.61));
// Constrain the camera target to the Adelaide bounds.
                mMap.setLatLngBoundsForCameraTarget(ADELAIDE);

//                    mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(cityLatLng, 0));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityLatLng,14));
//                    mMap.clear(); //clear old markers
                    mMap.setMinZoomPreference(mMap.getCameraPosition().zoom);
                    mMap.getMapType();
                mDbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            String LongX = ds.child("0").getValue(String.class);
                            String LongY = ds.child("1").getValue(String.class);
                            Log.d("TAG", LongX + " | " + LongY);
                        }
//                        Map<String, Object> map = (Map<String, Object>) dataSnapshot.child("").getValue();
//                        System.out.println(map);
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w("Failed to read value.", error.toException());
                    }
                });
//                CameraPosition googlePlex = CameraPosition.builder()
//                        .target(new LatLng(27.1500, -13.1991))
//                        .zoom(15)
//                        .build();
//
//                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10, null);
//                final LatLngBounds Laayoune = new LatLngBounds(
//                        new LatLng(27.1500, -13.1991) , new LatLng(27.1500, -13.1991));
//                mMap.setLatLngBoundsForCameraTarget(Laayoune);
//                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(Laayoune, 0));

            }
        });
        return rootView;
    }


}