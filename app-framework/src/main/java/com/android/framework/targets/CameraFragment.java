package com.android.framework.targets;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.framework.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Android 照相机 相关
 */
public class CameraFragment extends Fragment {

    View root;
    SurfaceView photo;
    private Camera camera;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.camera_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    void initView(){
        photo = (SurfaceView) root.findViewById(R.id.photo);
        SurfaceHolder mSurfaceHolder = photo.getHolder();
        mSurfaceHolder.addCallback(new SurfaceViewCallBack());
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        //调用系统相机，返回结果
        root.findViewById(R.id.bySelf).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (camera != null) {
                    camera.autoFocus(new AutoFocusCallbackImpl());
                }
            }
        });
    }

    private boolean previewRuning = true;
    class SurfaceViewCallBack implements SurfaceHolder.Callback {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            //现在智能机可能会有多个镜头：一般前置为１；后置为０
            CameraFragment.this.camera = Camera.open(0);
            //设置参数
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPictureFormat(PixelFormat.JPEG);
            parameters.set("jpeg-quality", 85);
            parameters.setPreviewFormat(5);
            camera.setParameters(parameters);

            try {
                camera.setPreviewDisplay(holder);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //开始预览
            camera.startPreview();
            previewRuning = true;
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            if (camera != null) {
                if (previewRuning) {
                    camera.stopPreview();
                    previewRuning = false;
                }
                camera.release();
            }
        }
    }

    private String path = "";
    public Camera.PictureCallback picture = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
            //判断外部储存卡是否存在
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                Toast.makeText(getActivity(), "读取失败，SD存储卡不存在", Toast.LENGTH_SHORT).show();
                return;
            }
            path = Environment.getExternalStorageDirectory().toString() + File.separator + "camera_diy" + File.separator +
                    System.currentTimeMillis() + ".jpg";
            File file = new File(path);
            if (!file.exists()) {
                File vDirPath = file.getParentFile();
                vDirPath.mkdirs();
                Toast.makeText(getActivity(), "photo.jpg文件不存在！", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                bmp.compress(Bitmap.CompressFormat.JPEG, 80, bos);
                bos.flush();
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            camera.stopPreview();
            camera.startPreview();
        }
    };

    class AutoFocusCallbackImpl implements Camera.AutoFocusCallback {

        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            camera.takePicture(shutter, null, picture);
            camera.stopPreview();
        }
    }

    public Camera.ShutterCallback shutter = new Camera.ShutterCallback() {
        @Override
        public void onShutter() {

        }
    };

}
