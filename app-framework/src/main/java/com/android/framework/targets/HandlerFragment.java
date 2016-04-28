package com.android.framework.targets;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.framework.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by xuhuanchao on 2015/11/4.
 */
public class HandlerFragment extends Fragment {

    Context context;
    View root = null;
    Resources resources;
    private Handler mHandler;
    private Button readBtn, toastBtn;
    private TextView tvContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.handler_fragment_layout, container, false);
        context = getActivity().getApplicationContext();
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHandler();
        initView();
    }



    void initHandler(){

        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        Bundle b = msg.getData();
                        tvContext.setText(b.getString("content"));
                        break;
                }
                return true;
            }
        });
    }

    void initView(){
        resources = getResources();
        tvContext = (TextView) root.findViewById(R.id.tv_content);
        toastBtn = (Button) root.findViewById(R.id.toastBtn);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "测试5秒", Toast.LENGTH_SHORT).show();
            }
        });
        readBtn = (Button) root.findViewById(R.id.readBtn);
        readBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                asyncReadFileContent();
            }
        });
    }


    /**
     * 异步读取文件
     */
    void asyncReadFileContent(){
        new Thread(){
            @Override
            public void run() {
                String content = "";
                Message msg = mHandler.obtainMessage();
                try{
                    InputStream is = getResources().getAssets().open("content.txt");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader bufferedReader = new BufferedReader(isr);
                    sleep(3000);
                    do {
                        content = content + bufferedReader.readLine();
                    }while (bufferedReader.read() != -1);
                    bufferedReader.close();
                    isr.hashCode();
                    is.close();
                    msg.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("content", content);
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }


}
