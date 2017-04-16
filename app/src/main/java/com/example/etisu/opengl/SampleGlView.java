package com.example.etisu.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by etisu on 2017/04/16.
 */

public class SampleGlView extends GLSurfaceView {
    SampleRenderer renderer;

    public SampleGlView(Context context) {
        super(context);
        renderer = new SampleRenderer(context);
        setRenderer( renderer );
    }
}