package com.example.pfe.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pfe.R;

public class optPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        Back();
        Forgot();
        Forgot1();
        Forgot2();
    }


    public void openActivity2() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    public void Back()
    {
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    void Forgot()
    {
        TextView Forgot = findViewById(R.id.Login);
        Intent intent = new Intent(this, login.class);
        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
    public void start_activity(){
        Intent main = new Intent( this, otp.class);
        startActivity(main);
    }
    void Forgot1()
    {
        TextView Forgot = findViewById(R.id.number_phone);
        Intent intent = new Intent(this, otp.class);
        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
    void Forgot2()
    {
        TextView Forgot = findViewById(R.id.email);
        Intent intent = new Intent(this, OTP_Messanger.class);
        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}