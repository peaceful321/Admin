package com.android.framework.util;

/**
 * Created by xuhuanchao on 2015/11/19.
 */
public class VerifyUtil {



    private static long lastClickedTime;//最后一次点击时间
    /**
     * 判断按钮是否被快速点击了两次
     * @return
     */
    public static boolean isFastDoubleClieck() {
        long currTime = System.currentTimeMillis();
        long timeDiff = currTime - lastClickedTime;
        if (timeDiff > 0 && timeDiff < 500) {
            return true;
        }
        lastClickedTime = currTime;
        return false;
    }


    /**
     * 判断对象是否为空
     * @param args
     * @return
     */
    public static boolean isNullObject(Object... args) {
        if (args == null) {
            return true;
        }
        for (Object obj : args) {
            if (obj == null) {
                return true;
            } else if (obj instanceof String) {
                String s = obj.toString();
                if (s.trim().length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
