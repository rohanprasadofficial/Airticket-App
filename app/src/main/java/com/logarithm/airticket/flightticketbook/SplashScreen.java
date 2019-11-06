package com.logarithm.airticket.flightticketbook;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();

            }
        },1500);


    }

    public void startNextActivity(){
        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),
                android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
        Intent intent = new Intent(SplashScreen.this, RoleChoose.class);
        startActivity(intent, bundle);
    }
}