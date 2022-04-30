package com.example.pfe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;


    public void start_activity(){
        Intent main = new Intent( MainActivity.this,layout_2.class);
        startActivity(main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        new CountDownTimer(900,1000){
            ImageView img_circle = findViewById(R.id.whiteCircleImg);
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                img_circle.animate().scaleX(500f).setDuration(11000).scaleY(500f).setDuration(11000);}
        }.start();

        new CountDownTimer(2000,1000){
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                mAuth = FirebaseAuth.getInstance();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mAuth.getCurrentUser() != null){
                            startActivity(new Intent(MainActivity.this, home_map.class));
                        }else {
                            start_activity();
                        }
                        finish();
                    }
                }, 0);

            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}