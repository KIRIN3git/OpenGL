package com.example.etisu.opengl;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SampleGlView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        glView = new SampleGlView(this);
        setContentView(glView);
    }


    @Override
    protected void onResume(){
        super.onResume();
        glView.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        glView.onPause();
    }
}
