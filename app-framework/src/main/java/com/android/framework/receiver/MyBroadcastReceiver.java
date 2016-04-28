package com.android.framework.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Ryan Xu on 2016/1/15.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String ACTION = "com.android.framework.receiver.intent.action.MyBroadcastReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(intent.getStringExtra("extraInfo"));
    }
}
