package com.android.framework.targets;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xuhuanchao on 2015/11/20.
 *
 * 概念：
 * SurfaceView是View类的子类，可以直接从内存或者DMA等硬件接口取得图像数据，是个非常重要的绘图视图。
 * 它的特性是：可以在主线程之外的线程中向屏幕绘图上。这样可以避免画图任务繁重的时候造成主线程阻塞，从而提高了程序的反应速度。
 * 在游戏开发中多用到SurfaceView，游戏中的背景、人物、动画等等尽量在画布canvas中画出。
 */
public class SurfaceViewFragment extends Fragment {

    private static final String TAG = "SurfaceViewFragment";

    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = new MySurfaceView(getActivity());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    /**
     * 2.实现方法:
     * 1）实现步骤
     *  a．继承SurfaceView
     *  b．实现SurfaceHolder.Callback接口
     *
     * 2）需要重写的方法
     *  public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){}　　//在surface的大小发生改变时激发
     *  public void surfaceCreated(SurfaceHolder holder){}　　//在创建时激发，一般在这里调用画图的线程。
     *  public void surfaceDestroyed(SurfaceHolder holder) {}　　//销毁时激发，一般在这里将画图的线程停止、释放。
     *
     * 3）SurfaceHolder
     *  SurfaceHolder,surface的控制器，用来操纵surface。处理它的Canvas上画的效果和动画，控制表面，大小，像素等
     *
     *  几个需要注意的方法：
     *  (1)、abstract void addCallback(SurfaceHolder.Callback callback);// 给SurfaceView当前的持有者一个回调对象。
     *  (2)、abstract Canvas lockCanvas(); 锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操作了。
     *
     *  (3)、abstract Canvas lockCanvas(Rect dirty);
     *      锁定画布的某个区域进行画图等..因为画完图后，会调用下面的unlockCanvasAndPost来改变显示内容。
     *      相对部分内存要求比较高的游戏来说，可以不用重画dirty外的其它区域的像素，可以提高速度。
     *  (4)、abstract void unlockCanvasAndPost(Canvas canvas); 结束锁定画图，并提交改变。
     *
     *
     *  4）总结整个过程
     *  继承SurfaceView并实现SurfaceHolder.Callback接口 ---->
     *  SurfaceView.getHolder()获得SurfaceHolder对象 ---->
     *  SurfaceHolder.addCallback(callback)添加回调函数---->
     *  SurfaceHolder.lockCanvas()获得Canvas对象并锁定画布---->
     *  Canvas绘画 ---->
     *  SurfaceHolder.unlockCanvasAndPost(Canvas canvas)结束锁定画图，并提交改变，将图形显示。
     */
    class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

        private SurfaceHolder surfaceHolder;
        private MyThread myThread;

        public MySurfaceView(Context context) {
            super(context);
            this.surfaceHolder = this.getHolder();
            surfaceHolder.addCallback(this);
            myThread = new MyThread(surfaceHolder);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            myThread.isRun = true;
            myThread.start();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            myThread.isRun = false;
        }
    }


    class MyThread extends Thread {

        private SurfaceHolder holder;
        public boolean isRun;

        public MyThread(SurfaceHolder holder){
            this.holder = holder;
            isRun = true;
        }


        @Override
        public void run() {
            int count = 0;
            while (isRun) {
                Canvas canvas = null;
                try {
                    synchronized (holder) {
                        canvas = holder.lockCanvas();
                        canvas.drawColor(Color.BLACK);
                        Paint paint = new Paint();
                        paint.setColor(Color.WHITE);
//                        paint.setStyle(Paint.Style.STROKE);
//                        paint.setStrokeWidth(20);
                        Rect rect = new Rect(100, 50 , 300 ,250);
                        canvas.drawRect(rect, paint);
                        canvas.drawText("这是第" + count++ + "秒", 100, 300, paint);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (canvas != null) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }

}
