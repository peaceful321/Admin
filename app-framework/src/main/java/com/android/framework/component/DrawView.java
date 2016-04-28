package com.android.framework.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.android.framework.R;

/**
 * Created by xuhuanchao on 2015/11/19.
 */
public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

        Paint paint_blue = new Paint();
        paint_blue.setColor(Color.BLUE);
        paint_blue.setStyle(Paint.Style.STROKE);
        paint_blue.setStrokeWidth(10);
        paint_blue.setAntiAlias(true);
        canvas.drawCircle(110, 150, 60, paint_blue);

        Paint paint_yellow = new Paint();
        paint_yellow.setColor(Color.YELLOW);
        paint_yellow.setStyle(Paint.Style.STROKE);
        paint_yellow.setStrokeWidth(10);
        canvas.drawCircle(Float.parseFloat("175.5"), 210, 60, paint_yellow);

        Paint paint_black = new Paint();
        paint_black.setColor(Color.BLACK);
        paint_black.setStyle(Paint.Style.STROKE);
        paint_black.setStrokeWidth(10);
        canvas.drawCircle(245, 150, 60, paint_black);

        Paint paint_green = new Paint();
        paint_green.setColor(Color.GREEN);
        paint_green.setStyle(Paint.Style.STROKE);
        paint_green.setStrokeWidth(10);
        canvas.drawCircle(311, 210, 60, paint_green);

        Paint paint_red = new Paint();
        paint_red.setColor(Color.RED);
        paint_red.setStyle(Paint.Style.STROKE);
        paint_red.setStrokeWidth(10);
        canvas.drawCircle(380, 150, 60, paint_red);

        Paint paint_str = new Paint();
        paint_str.setColor(Color.RED);
        paint_str.setTextSize(20);
        canvas.drawText("Welcome come to Beijing", 245, 310, paint_str);

        Paint paint_line = new Paint();
        paint_line.setColor(Color.BLUE);
        canvas.drawLine(240, 310, 425, 310, paint_line);

        Paint paint_text = new Paint();
        paint_text.setColor(Color.BLUE);
        paint_text.setTextSize(20);
        canvas.drawText("北京欢迎你", 275, 330, paint_text);

        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rating_important), 35, 340, paint_line);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rating_important), 85, 340, paint_line);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rating_important), 135, 340, paint_line);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rating_important), 185, 340, paint_line);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rating_important), 235, 340, paint_line);

        //画矩形
        Paint paint_rect = new Paint();
        paint_rect.setColor(Color.BLUE);
        paint_rect.setStyle(Paint.Style.STROKE);
        paint_rect.setStrokeWidth(10);
        canvas.drawRect(15, 10, 600, 800, paint_rect);
    }

}
