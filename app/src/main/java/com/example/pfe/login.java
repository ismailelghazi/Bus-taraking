package com.example.pfe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText email;
    TextInputEditText password;
    Button login;
    TextInputLayout emailError;
    boolean isEmailValid;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        color_text();
        start();
        Back();
        email = (EditText) findViewById(R.id.emailLogin);
        login = (Button) findViewById(R.id.btn_week);
        password = findViewById(R.id.PasswordLogin);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
                userLogin();
            }
        });
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
    void color_text()
    {

        TextView Forgot = findViewById(R.id.Forgot);
        String loginStyle= "<strong><font color='#fa376c'>Forgot Password</font></strong>";
        Forgot.setText(Html.fromHtml(loginStyle),TextView.BufferType.SPANNABLE);
        TextView Sign_Up = findViewById(R.id.Sign_up);
        String loginStyles= "<strong><font color='#fa376c'>Sign Up</font></strong>.";
        Sign_Up.setText(Html.fromHtml(loginStyles),TextView.BufferType.SPANNABLE);
    }
    public void openActivity2() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    public void start()
    {
        TextView Sign_Up = findViewById(R.id.Sign_up);
        Sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void SetValidation() {
        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            emailError.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            emailError.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }

    }
    void userLogin()
    {
        String Lemail = email.getText().toString().trim();
        String Lpassword = password.getText().toString().trim();
        if(Lemail.isEmpty() && Lpassword.isEmpty())
        {
//            email.setError("entre your name");
            password.setError("enter your password");
//            email.requestFocus();
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(Lemail,Lpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(login.this,home_map.class));
                }
                else {
                    Toast.makeText(login.this,"bad",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}