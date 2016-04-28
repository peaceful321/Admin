package com.android.framework.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.framework.R;
import com.android.framework.model.TargetItem;

import java.util.List;

/**
 * Created by xuhuanchao on 2015/11/3.
 */
public class TargetItemAdapter extends BaseAdapter {

    Context context;
    List<TargetItem> targetItemList;
    OnTargetClickListener onTargetClickListener;

    public TargetItemAdapter(Context context, List<TargetItem> targetItemList) {
        this.context = context;
        this.targetItemList = targetItemList;
    }

    public void setOnTargetClickListener(OnTargetClickListener onTargetClickListener) {
        this.onTargetClickListener = onTargetClickListener;
    }


    @Override
    public int getCount() {
        return targetItemList.size();
    }

    @Override
    public TargetItem getItem(int position) {
        return targetItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.target_item_layout, parent, false);
            /**得到各个控件对象**/
            holder = new ViewHolder();
            holder.iv_target = (ImageView) convertView.findViewById(R.id.iv_target);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_fragment = (TextView) convertView.findViewById(R.id.tv_fragment);
            holder.target_link = (LinearLayout) convertView.findViewById(R.id.target_link);
            /**绑定ViewHolder对象**/
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag(); /**取出ViewHolder对象**/
        }
        /**设置各个控件对象要显示的内容**/
        Drawable drawable = context.getResources().getDrawable(getItem(position).getTargetImg());
        holder.iv_target.setImageDrawable(drawable);
        holder.tv_title.setText(getItem(position).getTargetTitle());
        holder.tv_fragment.setText(getItem(position).getTargetFragment());
        /**接口回调**/
        holder.target_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTargetClickListener.onClick(getItem(position));
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView iv_target;
        TextView tv_title, tv_fragment;
        LinearLayout target_link;
    }

    public static interface OnTargetClickListener {
        public void onClick(TargetItem item);
    }
}
