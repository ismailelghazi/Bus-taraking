package com.example.pfe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public void start_activity(){
        Intent main = new Intent(this,layout_2.class);
        startActivity(main);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                start_activity();
            }
        }.start();
    }
}