package com.android.framework.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import com.android.framework.R;

/**
 * Created by Ryan Xu on 2016/4/5.
 */
public class ArcMenu extends ViewGroup implements View.OnClickListener {

    private static final int POS_LEFT_TOP = 0;
    private static final int POS_LEFT_BOTTOM = 1;
    private static final int POS_RIGHT_TOP = 2;
    private static final int POS_RIGHT_BOTTOM = 3;

    private Position mPosition = Position.RIGHT_BOTTOM;
    private int mRadius;
    private Status mCurrentStatus = Status.CLOSE;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private View mCButton;

    /**
     * 菜单状态
     */
    public enum Status {
        OPEN, CLOSE
    }

    /**
     * 枚举类：菜单位置
     */
    public enum Position {
        LEFT_TOP, LEFT_BOTTOM, RIGHT_TOP, RIGHT_BOTTOM
    }

    /**
     * 子菜单项点击回掉接口
     */
    public interface OnMenuItemClickListener {
        void onClick(View view, int position);
    }

    public ArcMenu(Context context) {
        this(context, null);
    }

    public ArcMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        //获取自定义属性值
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ArcMenu, defStyleAttr, 0);
        int pos = typedArray.getInt(R.styleable.ArcMenu_position, POS_RIGHT_BOTTOM);
        switch(pos) {
            case POS_LEFT_TOP:
                mPosition = Position.LEFT_TOP;
                break;
            case POS_LEFT_BOTTOM:
                mPosition = Position.LEFT_BOTTOM;
                break;
            case POS_RIGHT_TOP:
                mPosition = Position.RIGHT_TOP;
                break;
            case POS_RIGHT_BOTTOM:
                mPosition = Position.RIGHT_BOTTOM;
                break;
        }
        mRadius = (int) typedArray.getDimension(R.styleable.ArcMenu_radius,
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics()));
        Log.d("TAG", "Position=" + mPosition + " Radius=" + mRadius);
        typedArray.recycle();
    }

    /**
     * 设置回掉接口
     * @param mOnMenuItemClickListener
     */
    public void setOnMenuItemClickListener(OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            //测量child
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            layoutCButton();//定位主菜单
            int count = getChildCount();
            for (int i = 0; i < count - 1; i++) {
                View child = getChildAt(i+1);
                child.setVisibility(View.GONE);
                int cl = (int) (mRadius * Math.sin(Math.PI / 2 / (count - 2) * i));
                int ct = (int) (mRadius * Math.cos(Math.PI / 2 / (count - 2) * i));
                int cw = child.getMeasuredWidth();
                int ch = child.getMeasuredHeight();

                //如果菜单位置在底部----坐下 或 右下
                if (mPosition == Position.LEFT_BOTTOM || mPosition == Position.RIGHT_BOTTOM) {
                    ct = getMeasuredHeight() - ch - ct;
                }
                //右上 或 右下
                if (mPosition == Position.RIGHT_TOP || mPosition == Position.RIGHT_BOTTOM) {
                    cl = getMeasuredWidth() - cw - cl;
                }
                child.layout(cl, ct, cl + cw, ct + ch);
            }
        }
    }

    @Override
    public void onClick(View v) {

    }


    /**
     * 定位主菜单按钮
     */
    private void layoutCButton() {
        mCButton = getChildAt(0);
        mCButton.setOnClickListener(this);

        int l = 0, t = 0;
        int width = mCButton.getMeasuredWidth();
        int height  = mCButton.getMeasuredHeight();
        switch(mPosition) {
            case LEFT_TOP:
                l = 0;
                t = 0;
                break;
            case LEFT_BOTTOM:
                l = 0;
                t = getMeasuredHeight() - height;
                break;
            case RIGHT_TOP:
                t = 0;
                l = getMeasuredWidth() - width;
                break;
            case RIGHT_BOTTOM:
                l = getMeasuredWidth() - width;
                t = getMeasuredHeight() - height;
                break;
        }
        mCButton.layout(l, t, l+width, t+width);
    }

    public boolean isOpen() {
        return mCurrentStatus == Status.OPEN;
    }

    private void changeStatus() {
        mCurrentStatus = mCurrentStatus == Status.CLOSE ? Status.OPEN : Status.CLOSE;
    }

}
