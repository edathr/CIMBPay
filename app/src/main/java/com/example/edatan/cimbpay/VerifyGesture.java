package com.example.edatan.cimbpay;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerifyGesture extends AppCompatActivity {
    private ImageView image;
    GestureLibrary lib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_gesture);

        image = findViewById(R.id.verifygesturepic);

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

        lib = GestureLibraries.fromRawResource(this, R.raw.gesture);
        if (!lib.load()) {
            finish();
        }
        final GestureOverlayView gesture = findViewById(R.id.gesture);
        gesture.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
                ArrayList<Prediction> predictionArrayList = lib.recognize(gesture);
                for (Prediction prediction: predictionArrayList) {
                    if (prediction.score > 1.0) {
                        //txtResult.setText(prediction.name);
                        //txtResult.setText("Success");
                        Toast.makeText(VerifyGesture.this, "Successfully verified!", Toast.LENGTH_LONG).show();
    }
}
