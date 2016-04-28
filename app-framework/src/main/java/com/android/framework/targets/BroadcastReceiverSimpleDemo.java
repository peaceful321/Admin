package com.android.framework.targets;

import android.app.Fragment;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.framework.R;
import com.android.framework.receiver.MyBroadcastReceiver;

/**
 *
 * Created by xuhuanchao on 2015/11/19.
 */
public class BroadcastReceiverSimpleDemo extends Fragment {

    private static final String TAG = "BroadcastReceiverFragment";

    View root;
    private Button sendBtn, regBtn, unRegBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.broadcast_receiver_fragment_layout, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        bindListener();
    }

    void initView(){
        sendBtn = (Button) root.findViewById(R.id.sendBtn);
        regBtn = (Button) root.findViewById(R.id.regBtn);
        unRegBtn = (Button) root.findViewById(R.id.unRegBtn);
    }

    void bindListener() {
        sendBtn.setOnClickListener(new OnBtnClickListener());
        regBtn.setOnClickListener(new OnBtnClickListener());
        unRegBtn.setOnClickListener(new OnBtnClickListener());
    }


    class OnBtnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sendBtn:
                    sendBroadcast();
                    break;
                case R.id.regBtn:
                    regBroadcast();
                    break;
                case R.id.unRegBtn:
                    unRegBroadcast();
                    break;
            }
        }
    }

    void sendBroadcast() {
        Log.w("Send Broadcast: ", "发送广播消息");
        Intent intent = new Intent();
        intent.setAction(MyBroadcastReceiver.ACTION);
        intent.putExtra("extraInfo", "发送广播消息成功");
        getActivity().sendBroadcast(intent);
    }

    void regBroadcast() {
        Log.w("DynamicBroadcast", "注册广播");
        Intent intent = new Intent();
        intent.setAction(MyBroadcastReceiver.ACTION);
        intent.putExtra("msg", "注册广播广播成功");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyBroadcastReceiver.ACTION);
        getActivity().registerReceiver(new MyBroadcastReceiver(), intentFilter);
    }

    void unRegBroadcast() {
        Log.w("SystemBroadcast", "注销广播");
        Intent intent = new Intent();
        intent.putExtra("msg", "注销广播广播成功！");
        getActivity().unregisterReceiver(new MyBroadcastReceiver());
    }

}
