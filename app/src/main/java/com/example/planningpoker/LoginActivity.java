package com.example.planningpoker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public static final String MY_SHARED_PREFERENCES = "LoginData";

    private EditText et_userName, et_password;
    private CheckBox ckb_rememberMe;
    private Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intentMenu = new Intent(this, MenuActivity.class);

        et_userName = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
        ckb_rememberMe = findViewById(R.id.ckb_remember_me);
        btn_login = findViewById(R.id.btn_login);

        SharedPreferences sharedPreferences = getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE);
        String chkbox_value = sharedPreferences.getString("rememberMe", "no");

        if (chkbox_value.contentEquals("yes")){
            et_userName.setText(sharedPreferences.getString("name","Enter your name"));
            et_password.setText(sharedPreferences.getString("password","password"));
            ckb_rememberMe.setChecked(true);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ckb_rememberMe.isChecked()){
                    SharedPreferences.Editor sharedPreferences = getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE).edit();
                    sharedPreferences.putString("name",et_userName.getText().toString());
                    sharedPreferences.putString("password", et_password.getText().toString());
                    sharedPreferences.putString("rememberMe","yes");
                    sharedPreferences.apply();
                } else {
                    SharedPreferences.Editor sharedPreferences = getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE).edit();
                    sharedPreferences.putString("name","");
                    sharedPreferences.putString("password", "");
                    sharedPreferences.putString("rememberMe","");
                    sharedPreferences.apply();
                }

                startActivity(intentMenu);
            }
        });
    }
}
