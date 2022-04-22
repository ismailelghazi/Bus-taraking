package com.example.pfe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class home extends AppCompatActivity {

    EditText email;
    Button login;
    TextInputLayout emailError;
    boolean isEmailValid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        color_text();
        start();
        email = (EditText) findViewById(R.id.email);
        login = (Button) findViewById(R.id.btn_week);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
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
}