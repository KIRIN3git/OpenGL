package com.example.etisu.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
/**
 * Created by etisu on 2017/04/16.
 */

public class SampleRenderer implements Renderer{
    private Context context;

    //2次元スプライト
    SampleSprite tenshi_img = new SampleSprite();
    public SampleRenderer(Context _context){
        context = _context;
    }
    @Override
    public void onDrawFrame(GL10 gl) {
        // 描画用バッファをクリア
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        tenshi_img.draw(gl);
    }
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);//プロジェクションモードに設定
        GLU.gluOrtho2D(gl, 0.0f, width, 0.0f, height);//平行投影用のパラメータをセット
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //背景色をクリア
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        //ディザを無効化
        gl.glDisable(GL10.GL_DITHER);
        //深度テストを有効化
        gl.glEnable(GL10.GL_DEPTH_TEST);
        //テクスチャ機能ON
        gl.glEnable(GL10.GL_TEXTURE_2D);
        //透明可能に
        gl.glEnable(GL10.GL_ALPHA_TEST);
        //ブレンド可能に
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
        tenshi_img.setTexture(gl,context.getResources(),R.drawable.sample_img);
    }
}