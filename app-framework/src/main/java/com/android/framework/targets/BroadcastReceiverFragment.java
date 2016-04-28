package com.android.framework.targets;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.framework.R;
//
///**
// *
// * Created by xuhuanchao on 2015/11/19.
// */
public class BroadcastReceiverFragment extends Fragment {
//
//    private static final String TAG = "BroadcastReceiverFragment";
//
//
    View root;
//    private Button sendStaticBtn, sendDynamicBtn, sendSystemBtn;
//
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.broadcast_receiver_fragment_layout, container, false);
    }

//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        initView();
//        bindListener();
//    }
//
//    void initView(){
//        sendStaticBtn = (Button) root.findViewById(R.id.sendStaticBtn);
//        sendDynamicBtn = (Button) root.findViewById(R.id.sendDynamicBtn);
//        sendSystemBtn = (Button) root.findViewById(R.id.sendSystemBtn);
//    }
//
//    void bindListener() {
//        sendStaticBtn.setOnClickListener(new OnBtnClickListener());
//        sendDynamicBtn.setOnClickListener(new OnBtnClickListener());
//        sendSystemBtn.setOnClickListener(new OnBtnClickListener());
//    }
//
//
//    class OnBtnClickListener implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.sendStaticBtn:
//                    sendStaticBroadcast();
//                    break;
//                case R.id.sendDynamicBtn:
//                    sendDynamicBroadcast();
//                    break;
//                case R.id.sendSystemBtn:
//                    sendSystemBroadcast();
//                    break;
//            }
//        }
//    }
//
//    void sendStaticBroadcast() {
//        Log.w("StaticBroadcast", "发送自定义静态注册广播消息");
//        Intent intent = new Intent();
//        intent.setAction(STATIC_ACTION);
//        intent.putExtra("msg", "接收静态注册广播成功！");
//        getActivity().sendBroadcast(intent);
//    }
//
//    void sendDynamicBroadcast() {
//        Log.w("DynamicBroadcast", "发送自定义动态注册广播消息");
//        Intent intent = new Intent();
//        intent.setAction(DYNAMIC_ACTION);
//        intent.putExtra("msg", "接收动态注册广播成功");
//        getActivity().sendBroadcast(intent);
//    }
//
//    void sendSystemBroadcast() {
//        Log.w("SystemBroadcast", "发送系统广播消息");
//        Intent intent = new Intent();
//        intent.setAction(SYSTEM_ACTION);
//        intent.putExtra("msg", "接收系统广播成功！");
//        getActivity().sendBroadcast(intent);
//    }
//
//
//
}
