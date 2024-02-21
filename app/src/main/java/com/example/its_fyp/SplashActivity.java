package com.example.its_fyp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes6.dex */
public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() { // from class: com.example.its_fyp.SplashActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, 3000L);
    }
}