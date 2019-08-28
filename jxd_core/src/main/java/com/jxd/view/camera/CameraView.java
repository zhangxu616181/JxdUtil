package com.jxd.view.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * @author : JXD
 * @date : 2019/8/28 星期三
 */
public class CameraView extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback {

    Context mContext;
    SurfaceHolder mSurfaceHolder;//surface的控制器
    Camera mCamera;//相机类
    FrameCallback mCb;//数据回调接口

    public void setPreBack(FrameCallback mCb) {
        this.mCb = mCb;
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
    }

    private Camera getCamera() {
        Camera camera = null;
        try {
            camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
        } catch (Exception ignored) {
        }
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setExposureCompensation(1);
            parameters.setPreviewSize(1280, 720);
            camera.setParameters(parameters);
        }
        return camera;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mCamera = getCamera();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        setStartPreview(mCamera, mSurfaceHolder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        releaseCamera();
    }

    //开启相机预览
    private void setStartPreview(Camera camera, SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.setPreviewCallback(this);
            camera.startPreview();
        } catch (IOException ignored) {
        }
    }

    //释放Camera
    public void releaseCamera() {
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();// 停掉摄像头的预览
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        if (mCb != null) {
            mCb.onPreview(data);
        }
    }

    public interface FrameCallback {
        void onPreview(byte[] data);
    }
}
