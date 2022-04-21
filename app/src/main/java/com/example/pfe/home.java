package com.example.pfe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        color_text();

    }
    void color_text()
    {
        TextView textView = (TextView) findViewById(R.id.texts);
        String styledText = "Create an account to access all the features of <strong><font color='#fa376c'>Tracking!</font></strong>.";
        textView.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

        CheckBox radioButton= findViewById(R.id.radio_button_1);
        String stylebutton="I agree with the <u><font color='#fca1ba'>Terms of Service</font></u> & <u><font color='#fca1ba'>Privacy Policy</font></u>";
        radioButton.setText(Html.fromHtml(stylebutton),RadioButton.BufferType.SPANNABLE);
    }






}