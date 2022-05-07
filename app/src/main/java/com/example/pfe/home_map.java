package com.example.pfe;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_map extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottom_navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_map);

        bottom_navigation = findViewById(R.id.bottom_navigation);

        bottom_navigation.setOnNavigationItemSelectedListener(this);
        //bottom_navigation.setSelectedItemId(R.id.navigation_map);
        }
    map firstFragment = new map();
    nofication thirdFragment = new nofication();
    search secondFragment  = new search();
    profile fourtFragment = new profile();
//    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("ana hna1");

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
//    public void start()
//    {
//        //logout = findViewById(R.id.loguot);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent main = new Intent( home_map.this,login.class);
//                startActivity(main);
//
//            }
//        });
//    }
}