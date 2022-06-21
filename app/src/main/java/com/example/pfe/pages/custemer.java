package com.example.pfe.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pfe.R;

public class custemer extends AppCompatActivity {

    ImageButton imgButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custemer);
        imgButton = (ImageButton) findViewById(R.id.click);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgButton.setImageResource(R.drawable.kliybhmar);
            }
        });
    }

 }