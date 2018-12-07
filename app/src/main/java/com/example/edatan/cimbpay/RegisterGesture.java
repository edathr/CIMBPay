package com.example.edatan.cimbpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterGesture extends AppCompatActivity {
    private Button regGestureBtn, exitRegButton;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_gesture);
        regGestureBtn = findViewById(R.id.registerRegButton);
        exitRegButton = findViewById(R.id.exitRegButton);
        image = findViewById(R.id.registergesturepic);

        regGestureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterGesture.this, Finish.class));
            }
        });

        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    image.setVisibility(View.GONE);
                    return true;
                }
                return false;
            }

        });


    }
}
