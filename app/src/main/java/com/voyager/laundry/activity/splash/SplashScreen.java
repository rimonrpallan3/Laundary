package com.voyager.laundry.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.signinpage.SignInPage;
import com.voyager.laundry.common.Helper;

/**
 * Created by User on 12-Dec-18.
 */

public class SplashScreen extends AppCompatActivity {
    private int SPLASH_DISPLAY_LENGTH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SignInPage.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}