package com.android.framework.util;

import android.util.Log;

/**
 * Created by xuhuanchao on 2015/11/19.
 */
public class LogUtil {

    private static final String DEFAULT_TAG = "app-framework";

    public static void d(String message){
        d(DEFAULT_TAG, message);
    }

    public static void d(String tag, String message){
        Log.d(tag, message);
    }




}
