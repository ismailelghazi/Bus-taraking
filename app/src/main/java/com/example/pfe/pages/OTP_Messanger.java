package com.example.pfe.pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pfe.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class OTP_Messanger extends AppCompatActivity {

    EditText Email;
    Button Btn;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_messanger);
        Email = findViewById(R.id.idEdtEmail);
        Btn = findViewById(R.id.idBtnGetOtp);
        Back();
        firebaseAuth = FirebaseAuth.getInstance();
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.sendPasswordResetEmail(Email.getText().toString()).addOnCompleteListener(
                            new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(OTP_Messanger.this,"Email send ",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(OTP_Messanger.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });
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
}