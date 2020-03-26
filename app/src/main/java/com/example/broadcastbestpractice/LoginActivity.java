package com.example.broadcastbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;

    private EditText etPassword;

    private Button btnLogin;

    private CheckBox cbRememberPwd;

    private SharedPreferences.Editor editor;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        etAccount = findViewById(R.id.account);
        etPassword = findViewById(R.id.password);
        cbRememberPwd = findViewById(R.id.remember_pass);
        btnLogin = findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember){
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            etAccount.setText(account);
            etPassword.setText(password);
            cbRememberPwd.setChecked(true);
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                if (account.equals("admin") && password.equals("123456")){
                    editor = pref.edit();
                    if (cbRememberPwd.isChecked()){
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.putBoolean("remember_password", true);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
