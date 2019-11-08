package com.qhealth.corefield.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qhealth.corefield.R;

public class LoginActivity extends AppCompatActivity {

    private EditText mUserNameEditText;
    private EditText mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        mUserNameEditText = findViewById(R.id.username_edittext);
        mPassword = findViewById(R.id.password_edittext);
        mLogin = findViewById(R.id.login_button);
        TextView signUp_text = findViewById(R.id.signUp_text);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(mUserNameEditText.getText().toString(), mPassword.getText().toString());
            }
        });
       signUp_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
                finish();
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

            startActivity(intent);
        } else {
            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_LONG).show();
        }
    }
}