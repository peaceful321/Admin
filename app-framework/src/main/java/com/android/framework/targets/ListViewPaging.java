package com.android.framework.targets;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.framework.R;
import com.android.framework.model.NewsBean;
import com.android.framework.view.PagingLoadListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Xu on 2016/3/21.
 * ListView分页查询
 */
public class ListViewPaging extends Fragment {

    private static final String URL = "http://www.imooc.com/api/teacher?type=4&num=30";//数据URL

    View root;
    PagingLoadListView pagingLoadListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.listview_paging_layout, container, false);
}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }


    void initView() {
        pagingLoadListView = (PagingLoadListView) root.findViewById(R.id.lv_content);
        pagingLoadListView.setLoadListener(new LoadMoreData());
    }

    void loadData() {
        new AsyncTaskLoadData().execute(URL);
    }



    class LoadMoreData implements PagingLoadListView.ILoadListener {

        @Override
        public void onLoad() {
            //加载数据

            //更新listview的显示

            //加载完了，隐藏footer_layout
        }
    }

    /**
     * 异步根据url去获取数据
     */
    class AsyncTaskLoadData extends AsyncTask<String, Void, List<NewsBean>> {

        @Override
        protected List<NewsBean> doInBackground(String... params) {
            //根据url去获取数据
            return getData(params[0]);
        }

        @Override
        protected void onPostExecute(List<NewsBean> newsBeans) {
            super.onPostExecute(newsBeans);
        }

        /**
         * 获取数据的具体实现
         * @param url
         * @return
         */
        private List<NewsBean> getData(String url) {
            List<NewsBean> result = new ArrayList<NewsBean>();


            return result;
        }
    }


}
