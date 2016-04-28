package com.android.framework.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.framework.model.NewsBean;

import java.util.List;

/**
 * Created by Ryan Xu on 2016/3/21.
 */
public class NewsPagingAdapter extends BaseAdapter{

    Context context;
    List<NewsBean> datas;

    public NewsPagingAdapter(Context c, List<NewsBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public NewsBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
