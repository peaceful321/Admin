package com.java.framework.design_mode.singleton;

/**
 * Created by Ryan Xu on 2016/4/23.
 */
public class Singleton {

    private static Singleton instance = null;//懒汉模式

    private Singleton() {

    }

    public static Singleton newInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
