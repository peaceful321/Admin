package com.android.framework.util;

/**
 * 字符串操作工具类
 * Created by xuhuanchao on 2015/11/19.
 */
public class StringUtil {



    /**
     * 转字符串
     * @param param
     * @return
     */
    public static String nullToString(String param){
        return param == null ? "" : param.toString();
    }

    /**
     * 是否为空
     * @param param
     * @return
     */
    public static boolean isEmpty(String param) {
        return ((param == null) || param.equalsIgnoreCase("null") || param.length() == 0);
    }

    /**
     * 是否身份证格式
     * @param param
     * @return
     */
    public static boolean isIDCard(String param) {


        return false;
    }

    /**
     * 是否Email
     * @param param
     * @return
     */
    public static boolean isEmail(String param) {
        return false;
    }

    public static boolean isInteger() {
        return false;
    }


}
