package com.android.framework.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by xuhuanchao on 2015/11/19.
 */
public class EmailUtil {

    private static final String TAG = "EmailUtil";

    /**
     * 调用系统的mail客户端进行发送
     * @param context
     * @param path
     * @param fileName
     */
    public static void sendEmail(Context context, String path, String fileName){
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(path, fileName);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra("subject", file.getName());
        intent.putExtra("body", fileName);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        if (file.getName().endsWith(".gz")) {
            intent.setType("application/x-gzip");
        } else if (file.getName().endsWith(".txt")) {
            intent.setType("text/plain");
        } else {
            intent.setType("application/octet-stream");
        }
        context.startActivity(intent);
    }


}
