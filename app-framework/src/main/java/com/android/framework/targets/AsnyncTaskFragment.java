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
import com.android.framework.adapter.NewsAdapter;
import com.android.framework.model.NewsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Xu on 2016/2/25.
 */
public class AsnyncTaskFragment extends Fragment {

    private static String URL = "http://www.imooc.com/api/teacher?type=4&num=30";

    View root;
    ListView mListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.asynctask_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        loadData();
    }

    void initView() {
        mListView = (ListView) root.findViewById(R.id.lv_content);
    }

    void loadData() {
        new NewsAsyncTask().execute(URL);
    }


    private List<NewsBean> getJsonData(String url) {
        List<NewsBean> newsBeanList = new ArrayList<NewsBean>();
        try {
            String jsonString = readStream(new URL(url).openStream());
            JSONObject jsonObject;
            NewsBean bean;
            jsonObject = new JSONObject(jsonString);
            JSONArray array = jsonObject.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                bean = new NewsBean();
                jsonObject = array.getJSONObject(i);
                bean.setIconUrl(jsonObject.getString("picSmall"));
                bean.setTitle(jsonObject.getString("name"));
                bean.setContent(jsonObject.getString("description"));
                newsBeanList.add(bean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsBeanList;
    }

    private String readStream(InputStream inputStream) {
        InputStreamReader isr = null;
        String result = "";
        try {
            String line = "";
            isr = new InputStreamReader(inputStream, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null ) {
                result += line;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    class NewsAsyncTask extends AsyncTask<String, Void, List<NewsBean>> {

        @Override
        protected List<NewsBean> doInBackground(String... params) {//处理后台执行的任务，在后台线程执行
            return getJsonData(params[0]);
        }

        @Override
        protected void onPostExecute(List<NewsBean> newsBeans) {//后台任务执行完之后被调用，在ui线程执行
            super.onPostExecute(newsBeans);
            NewsAdapter adapter = new NewsAdapter(getActivity(), newsBeans, mListView);
            mListView.setAdapter(adapter);
        }

        @Override
        protected void onPreExecute() {//在 doInBackground(Params...)之前被调用，在ui线程执行
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {//在调用publishProgress之后被调用，在ui线程执行
            super.onProgressUpdate(values);
        }
    }
}
