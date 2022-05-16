package com.example.pfe.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pfe.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

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
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityLatLng,14));
                    mMap.clear(); //clear old markers
                    mMap.setMinZoomPreference(mMap.getCameraPosition().zoom);





//                CameraPosition googlePlex = CameraPosition.builder()
//                        .target(new LatLng(27.1500, -13.1991))
//                        .zoom(15)
//                        .build();
//
//                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10, null);
//                final LatLngBounds Laayoune = new LatLngBounds(
//                        new LatLng(27.1500, -13.1991) , new LatLng(27.1500, -13.1991));
////                mMap.setLatLngBoundsForCameraTarget(Laayoune);
//                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(Laayoune, 0));

            }
        });
        return rootView;
    }


}