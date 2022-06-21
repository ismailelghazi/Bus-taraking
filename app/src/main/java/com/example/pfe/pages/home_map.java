package com.example.pfe.pages;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pfe.R;
import com.example.pfe.intrface.profileClickListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home_map extends AppCompatActivity implements profileClickListener {

    BottomNavigationView bottomNavigationView;
    map firstFragment = new map();
    nofication thirdFragment = new nofication();
    search secondFragment  = new search();
    profile fourtFragment = new profile();
    profile_edit profil = new profile_edit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_map);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,firstFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_map:
                        System.out.println("ana hna");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                        return true;

                    case R.id.navigation_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                        return true;

                    case R.id.navigation_notifications:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                        return true;
                    case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fourtFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }


    @Override
    public void onProfileClick() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, profil).commit();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}