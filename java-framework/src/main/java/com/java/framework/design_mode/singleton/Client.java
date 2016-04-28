package com.java.framework.design_mode.singleton;

/**
 * Created by Ryan Xu on 2016/4/23.
 */
public class Client {

    public static void main(String args[]) {

        Singleton s1 = Singleton.newInstance();

        Singleton s2 = Singleton.newInstance();

        if (s1 == s2) {
            System.out.println("同一个实例");
        } else {
            System.out.println("非同一个实例");
        }

    }
}
