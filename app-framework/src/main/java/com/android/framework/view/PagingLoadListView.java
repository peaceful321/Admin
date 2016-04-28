package com.android.framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.android.framework.R;

/**
 * Created by Ryan Xu on 2016/3/21.
 */
public class PagingLoadListView extends ListView implements AbsListView.OnScrollListener{

    View footer;
    int totalItemCount, lastVisibleItem;
    boolean isLoading;//正在加载
    ILoadListener loadListener;

    public void setLoadListener(ILoadListener loadListener) {
        this.loadListener = loadListener;
    }

    public PagingLoadListView(Context context) {
        super(context);
        initView(context);
    }

    public PagingLoadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PagingLoadListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 添加底部加载提示布局到listview
     * @param context
     */
    void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.footer_layout, null);
        footer.findViewById(R.id.load_layout).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    /**
     * 加载完毕
     */
    public void loadComplete() {
        isLoading = false;
        footer.findViewById(R.id.load_layout).setVisibility(View.GONE);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.lastVisibleItem = firstVisibleItem + visibleItemCount;
        this.totalItemCount = totalItemCount;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (lastVisibleItem == totalItemCount && scrollState == SCROLL_STATE_IDLE) {
            if(!isLoading) {
                isLoading = true;
                //加载更多数据
                footer.findViewById(R.id.load_layout).setVisibility(View.VISIBLE);
                //接口回掉
                loadListener.onLoad();
            }
        }
    }

    public interface ILoadListener {
        public void onLoad();
    }

}
