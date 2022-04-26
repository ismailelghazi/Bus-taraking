package com.example.pfe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pfe.models.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class home extends AppCompatActivity {

    EditText email,etRegPassword,phone_number,name;
    Button login,btn_week;
    TextInputLayout emailError;
    boolean isEmailValid;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        color_text();
        start();
        emailError = findViewById(R.id.emailError);
        email = findViewById(R.id.email);
        etRegPassword = findViewById(R.id.etRegPassword);
        phone_number = findViewById(R.id.phone_number);
        login = findViewById(R.id.btn_week);
        name = findViewById(R.id.name);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
                register();

            }
        });



    }
    void color_text()
    {
        TextView textView =  findViewById(R.id.texts);
        String styledText = "Create an account to access all the features of <strong><font color='#fa376c'>Tracking!</font></strong>.";
        textView.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

        CheckBox radioButton= findViewById(R.id.radio_button_1);
        String stylebutton="I agree with the <u><font color='#fca1ba'>Terms of Service</font></u> & <u><font color='#fca1ba'>Privacy Policy</font></u>";
        radioButton.setText(Html.fromHtml(stylebutton),RadioButton.BufferType.SPANNABLE);
        TextView login = findViewById(R.id.login);
        String loginStyle= "<strong><font color='#fa376c'>Login</font></strong>.";
        login.setText(Html.fromHtml(loginStyle),TextView.BufferType.SPANNABLE);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void start()
    {
        TextView login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
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
    public void register() {
        String remail = email.getText().toString().trim();
        String fullName = name.getText().toString();
        String phone = phone_number.getText().toString();
        String rpassword = etRegPassword.getText().toString().trim();
        Log.d("myTag", "This is my message");
        if(remail.isEmpty() && rpassword.isEmpty())
        {
//            email.setError("entre your name");
            etRegPassword.setError("enter your password");
//            email.requestFocus();
            etRegPassword.requestFocus();
            return;
        }
            mAuth.createUserWithEmailAndPassword(remail, rpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        user User = new user(fullName, remail,phone);
                        FirebaseDatabase.getInstance().getReference("User").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser())
                                .getUid()).setValue(User).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(home.this, "good", Toast.LENGTH_LONG).show();

                                }
                            }
                        });
                    }
                }
            });
    }

    }
