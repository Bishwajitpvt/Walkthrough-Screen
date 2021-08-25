package com.example.walkthroughscreen.Password;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.walkthroughscreen.R;

public class PasswordActivity extends AppCompatActivity {

    EditText pass_code, pass_code2, pass_code3, pass_code4;
    Button verify_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        pass_code = findViewById(R.id.input_password_code);
        pass_code2 = findViewById(R.id.input_password_code2);
        pass_code3 = findViewById(R.id.input_password_code3);
        pass_code4 = findViewById(R.id.input_password_code4);
        verify_pass = findViewById(R.id.passCode_verify);


    }
}