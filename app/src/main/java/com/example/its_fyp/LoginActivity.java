package com.example.its_fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes6.dex */
public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etPassword;
    private EditText etUsername;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        Button button = (Button) findViewById(R.id.btnLogin);

        if (BuildConfig.DEBUG) {
            etUsername.setText("Hussain");
            etPassword.setText("pass123");
        }
        this.btnLogin = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.example.its_fyp.LoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String username = LoginActivity.this.etUsername.getText().toString().trim();
                String password = LoginActivity.this.etPassword.getText().toString().trim();
                boolean isUserValid = LoginActivity.this.authenticateUser(username, password);
                if (isUserValid) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);
                    LoginActivity.this.finish();
                    return;
                }
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean authenticateUser(String username, String password) {
        return username.equals("Hussain") && password.equals("pass123");
    }
}