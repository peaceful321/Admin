package com.android.framework.targets;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.framework.R;
import com.android.framework.model.FileInfo;
import com.android.framework.service.DownloadService;

/**
 * Created by Ryan Xu on 2016/3/17.
 * 多线程续传下载
 */
public class ServiceFragment extends Fragment {

    View root;
    private TextView mTvFileName = null;
    private ProgressBar mPbProgress = null;
    private Button btnStop = null,
                   btnStart = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.service_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        //创建一个文件信息对象
        String url = "";
        FileInfo fileInfo = new FileInfo(0, url, "", 0, 0);
        //绑定监听事件
        bindClickListener(fileInfo);

        //注册广播接收器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadService.ACTION_UPDATE);
        getActivity().registerReceiver(mReceiver, intentFilter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(mReceiver);
    }

    void initView(){
        //初始化view控件
        mTvFileName = (TextView) root.findViewById(R.id.tv_loadFileName);
        mPbProgress = (ProgressBar) root.findViewById(R.id.pbProgress);
        mPbProgress.setMax(100);
        btnStart = (Button) root.findViewById(R.id.btnStart);
        btnStop = (Button) root.findViewById(R.id.btnStop);
    }

    void bindClickListener(FileInfo fileInfo) {
        btnStart.setOnClickListener(new OnBtnClickListener(fileInfo));
        btnStop.setOnClickListener(new OnBtnClickListener(fileInfo));
    }


    class OnBtnClickListener implements View.OnClickListener {

        private FileInfo fileInfo;

        public OnBtnClickListener(FileInfo fileInfo) {
            this.fileInfo = fileInfo;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnStart) {
                Intent intent = new Intent(getActivity(), DownloadService.class);
                intent.setAction(DownloadService.ACTION_START);
                intent.putExtra("fileInfo", fileInfo);
                getActivity().startService(intent);
            }

            if (v.getId() == R.id.btnStop) {
                Intent intent = new Intent(getActivity(), DownloadService.class);
                intent.setAction(DownloadService.ACTION_STOP);
                intent.putExtra("fileInfo", fileInfo);
                getActivity().startService(intent);
            }
        }
    }

    /**
     * 帮助更新UI的广播接收器
     */
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (DownloadService.ACTION_UPDATE.equals(intent.getAction())) {
                int finished = intent.getIntExtra("finished", 0);
                mPbProgress.setProgress(finished);
            }
        }
    };

}
