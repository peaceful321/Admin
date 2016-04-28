package com.android.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.framework.R;
import com.android.framework.model.NewsBean;
import com.android.framework.tool.ImageLoader;

import java.util.List;

/**
 * Created by Ryan Xu on 2016/2/26.
 */
public class NewsAdapter extends BaseAdapter implements AbsListView.OnScrollListener{

    private List<NewsBean> mList;
    private LayoutInflater mInflater;
    private ImageLoader mImageLoader;
    private int mStart, mEnd;
    public static String[] URLS;
    private boolean mFirstIn;

    public NewsAdapter(Context context, List<NewsBean> data, ListView listView) {
        mList = data;
        mInflater = LayoutInflater.from(context);
        mImageLoader = new ImageLoader(listView);
        URLS = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            URLS [i] = data.get(i).getIconUrl();
        }
        mFirstIn = true;
        listView.setOnScrollListener(this);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.news_item_layout, null);
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //设置显示数据
        String url = mList.get(position).getIconUrl();
        viewHolder.ivIcon.setImageResource(R.mipmap.ic_launcher);
        viewHolder.ivIcon.setTag(url);
//        new ImageLoader().showImageByThread(viewHolder.ivIcon, url);
        mImageLoader.showImageByAsyncTask(viewHolder.ivIcon, url);
        viewHolder.tvTitle.setText(mList.get(position).getTitle());
        viewHolder.tvContent.setText(mList.get(position).getContent());
        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {//初始化的时候不会调用
        if (scrollState == SCROLL_STATE_IDLE) { //停止状态 ， 加载可见项
            mImageLoader.loadImages(mStart, mEnd);

        } else { //其他状态，停止加载任务
            mImageLoader.cancelAllTasks();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mStart = firstVisibleItem;
        mEnd = firstVisibleItem + visibleItemCount;
        if (mFirstIn && visibleItemCount > 0) {
            mImageLoader.loadImages(mStart, mEnd);
            mFirstIn = false;
        }
    }

    class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle, tvContent;
    }

}
