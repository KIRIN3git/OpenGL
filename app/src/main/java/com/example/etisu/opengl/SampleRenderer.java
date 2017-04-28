package com.example.etisu.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by etisu on 2017/04/16.
 */

public class SampleRenderer implements Renderer{
    private Context context;
    private float count;

    private float mBGD, mBGDD;
    FloatBuffer mVlist;


    public SampleRenderer(Context _context){
        context = _context;
    }

    @Override
    public void onDrawFrame(GL10 gl) {
		// 全体のクリア
		gl.glClearColor(mBGD, mBGD * mBGD, 1.0f - mBGD, 1.0f);

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		//三角形の背景色
//		gl.glColor4f(1.0f - mBGD, 1.0f - (mBGD * mBGD), mBGD, 1.0f);

		// 頂点データの設定
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVlist);
		// 図形の種類,頂点のオフセット,数を指定
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		// 頂点配列を有効化
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// 頂点をfloat配列に格納
		float[] vlist = new float[]{-0.5f, -0.5f, 0.0f, 0.0f, 0.5f, 0.0f, 0.5f, -0.5f, 0.0f};

		// 頂点データ格納用ByteBufferを作成
		ByteBuffer bbuf = ByteBuffer.allocateDirect(vlist.length * 4);

		// バイトオーダー設定
		bbuf.order(ByteOrder.nativeOrder());

		// ByteBufferからFloatBufferを作成
		mVlist = bbuf.asFloatBuffer();

		// 配列をバッファに転送
		mVlist.put(vlist);

		// 現在位置をバッファ先頭に設定
		mVlist.position(0);
    }
}