package com.anupam.video;

import androidx.appcompat.app.AppCompatActivity ;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.MediaController;
import android.widget.VideoView;

public class Profile extends AppCompatActivity implements GestureDetector.OnGestureListener {


    private static final String TAG = "Swipe Position";
    private float x1, x2, y1, y2;
    private static int MIN_DISTANCE = 150;
    private GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        setContentView(R.layout.activity_profile);
        this.gestureDetector = new GestureDetector(Profile.this, this);
    }

    //Override


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1=event.getX();
                y1=event.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2=event.getX();
                y2=event.getY();

                float valueX = x2 - x1;
                float valueY = y2 - y1;

                if(Math.abs(valueX) > MIN_DISTANCE){
                    //detect left to right
                    if(x2>x1)
                    {
                        Intent intent = new Intent(this, Profile.class);
                        startActivity(intent);
                    }
                    else
                    //detect right to left
                    {
                        VideoView v = findViewById(R.id.v);
                        v.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.a);
                        MediaController m = new MediaController(this);
                        v.setMediaController(m);
                        m.setAnchorView(v);
                        v.start();
                    }
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
