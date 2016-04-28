package com.android.framework.util;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

/**
 * Created by xuhuanchao on 2015/11/19.
 */
public class Base64Util {

    private static final String TAG = "Base64Util";

    public static String encode(String input, String charsetName) {
        String code = "";
        try {
            code = Base64.encodeToString(input.getBytes(charsetName), Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage());
        }
        return code;
    }

    public static String encode(String input) {
        return encode(input, "UTF-8");
    }

    public static String encode(byte[] byteArray) {
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    public static String decode(String input, String charsetName) {
        String code = "";
        try {
            code = new String(decode(input.getBytes(charsetName)));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage());
        }
        return code;
    }

    public static byte[] decode(byte[] byteArray){
        return Base64.decode(byteArray, Base64.DEFAULT);
    }


    public static String decode(String input) {
        return new String(Base64.decode(input, Base64.DEFAULT));
    }
//    public static byte[] decode(String input) {
//        return Base64.decode(input, Base64.DEFAULT);
//    }



}
