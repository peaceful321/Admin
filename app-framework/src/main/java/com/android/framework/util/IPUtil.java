package com.android.framework.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by xuhuanchao
 * IP工具类
 */
public class IPUtil {

    private static final String TAG = "IPUtil";

    /**
     * 获取本机IP
     * @return
     */
    public static String getLocalIpAddress(){
        try{
            for (Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces(); enumeration.hasMoreElements(); ){
                NetworkInterface networkInterface = enumeration.nextElement();
                for (Enumeration<InetAddress> enumIpAddress = networkInterface.getInetAddresses(); enumIpAddress.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddress.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        }catch (SocketException e){
            Log.e(TAG, e.getMessage());
        }
        return "";
    }


    /**
     * 获取本机Mac地址
     * @return
     */
    public static String getLocalMacAddress(Context context){
        WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        return wifiInfo.getMacAddress();
    }


}
