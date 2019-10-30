package com.example.projectpkl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnCancel;
    EditText etName, etPassword;

    TextView txAttemptsLeft;
    int loginAttemptsCounter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.activity_main_btn_login);
        btnCancel = findViewById(R.id.activity_main_btn_cancel);
        etName = findViewById(R.id.activity_main_et_nama);
        etPassword = findViewById(R.id.activity_main_et_password);
        txAttemptsLeft = findViewById(R.id.activity_main_tv_attempts_left);

        txAttemptsLeft.setVisibility(View.GONE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().equals("admin") &&
                    etPassword.getText().toString().equals("admin")) {
                    Intent moveToDestinationActivity;
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    moveToDestinationActivity = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(moveToDestinationActivity);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

                    txAttemptsLeft.setVisibility(View.VISIBLE);
                    txAttemptsLeft.setBackgroundColor(Color.RED);
                    loginAttemptsCounter--;
                    txAttemptsLeft.setText(Integer.toString(loginAttemptsCounter));

                    if (loginAttemptsCounter == 0) {
                        btnLogin.setEnabled(false);
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
