package com.example.edatan.cimbpay;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class WelcomePage extends AppCompatActivity{
    private LinearLayout welcomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        welcomePage = findViewById(R.id.welcomelayout);

        //Tap to make the page move to the registration page
        /*welcomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(WelcomePage.this, Registration.class));
            }
        });*/

        //Move the activity to Registration after a delay

        Runnable r = new Runnable() {

            @Override
            public void run() {
                // if you are redirecting from a fragment then use getActivity() as the context.
                startActivity(new Intent(WelcomePage.this, Registration.class));

            }
        };
        
        Handler h = new Handler();
        // The Runnable will be executed after the given delay time
        h.postDelayed(r, 2500); // will be delayed for 2.5 seconds
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
