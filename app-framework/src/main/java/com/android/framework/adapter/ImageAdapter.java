package com.android.framework.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by xuhuanchao on 2015/11/18.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private int[] resArray = null;
    private String[] title = null;

    public ImageAdapter(Context context, int[] resArray, String[] title) {
        this.context = context;
        this.resArray = resArray;
        this.title = title;
    }

    @Override
    public int getCount() {
        return resArray.length;
    }

    @Override
    public Integer getItem(int position) {
        return resArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linear = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linear.setOrientation(LinearLayout.VERTICAL);
        ImageView iv = new ImageView(context);
        iv.setImageBitmap(((BitmapDrawable)context.getResources().getDrawable(resArray[position])).getBitmap());
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params2.gravity=Gravity.CENTER;
        linear.addView(iv, params2);
        TextView tv = new TextView(context);
        tv.setText(title[position]);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params3.gravity=Gravity.CENTER;
        linear.addView(tv, params3);
        return linear;
    }
}
