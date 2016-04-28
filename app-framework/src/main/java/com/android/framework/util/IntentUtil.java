package com.android.framework.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Ryan Xu on 2016/1/11.
 */
public class IntentUtil {

    public static void invokeWebBrowser(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    public static void invokeWebSearch(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    public static void dial(Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        context.startActivity(intent);
    }

//    public static void call(Context context, String tel) {
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        intent.setData(Uri.parse(tel));
//        context.startActivity(intent);
//    }

    public static void showMapAtLatLong(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?z=4&q=business+near+city"));
        context.startActivity(intent);
    }
}
