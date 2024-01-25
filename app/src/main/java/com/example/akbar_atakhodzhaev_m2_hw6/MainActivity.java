package com.example.akbar_atakhodzhaev_m2_hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button button;
    TextView vhod;
    TextView enter;
    TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        button = findViewById(R.id.checkButton);
        vhod=findViewById(R.id.vhod);
        enter=findViewById(R.id.Enter);
        forgot=findViewById(R.id.forgot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameCheck();
            }
        });
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changeColor();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changeColor();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void usernameCheck() {
        String enteredUsername = username.getText().toString();
        String enteredPassword = password.getText().toString();
        if (enteredUsername.equals("admin")&&enteredPassword.equals("admin")) {
            vhod.setVisibility(View.GONE);
            enter.setVisibility(View.GONE);
            forgot.setVisibility(View.GONE);
            username.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
            Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
        }
    }
    private void changeColor(){
        if(username.getText().toString().trim().length()>0||password.getText().toString().trim().length()>0){
            button.setBackgroundResource(R.drawable.bg_button);
        }
    }
}