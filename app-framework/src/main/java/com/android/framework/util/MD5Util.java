package com.android.framework.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xuhuanchao on 2015/11/19.
 */
public class MD5Util {

    private static final String TAG = "MD5Util";

    public static String encode(String info){
        return encode(info, "MD5");
    }

    public static String encode(String info, String type){
        return encode(info, "UTF-8", type);
    }

    private static String encode(String str, String encoding, String type){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(type);
            messageDigest.reset();
            messageDigest.update(str.getBytes(encoding));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                sb.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                sb.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return sb.toString();
    }

}
